import java.util.function.*;
import java.util.Optional;

class Main {
	public static void main(String[] args) {
		InfiniteList<Integer> list = InfiniteList
			.iterate(1, i -> i + 1)
			.limit(5);

		list.forEach(System.out::println);
		//System.out.println(list.reduce((i,j) -> i+j));
		//System.out.println(list.limit(2).reduce((i,j) -> i+j));
	}
}

interface InfiniteList<T> {
	public static <T> InfiniteList<T> generate(
		Supplier<T> supplier) {
		return ActualList.generate(supplier);
	}

	public static <T> InfiniteList<T> iterate(
		T seed, UnaryOperator<T> next) {
		return ActualList.iterate(seed, next);
	}

	public T get();
	public InfiniteList<T> next();

	public InfiniteList<T> limit(int size);

	public void forEach(Consumer<? super T> action);
}

class ActualList<T> implements InfiniteList<T> {

	private Supplier<T> headSupplier;
	private Supplier<ActualList<T>> tailSupplier;
	private T head;
	private ActualList<T> tail;

	private ActualList(Supplier<T> headSupplier,
		Supplier<ActualList<T>> tailSupplier) {
		this.headSupplier = headSupplier;
		this.tailSupplier = tailSupplier;
	}

	public static <T> ActualList<T> generate(
		Supplier<T> supplier) {
		return new ActualList<T>(supplier,
			() -> ActualList.generate(supplier)
			);
	}

	public static <T> ActualList<T> iterate(
		T seed, UnaryOperator<T> next) {
		return new ActualList<T>(
			() -> seed,
			() -> ActualList.iterate(next.apply(seed), next)
			);
	}

	@Override
	public ActualList<T> limit(int size) {
		if (size == 0) {
			return null;
		}

		return new ActualList<T>(this.headSupplier,
			() -> this.tailSupplier.get().limit(size-1)
			);
	}
	@Override
	public void forEach(Consumer<? super T> action) {
		ActualList<T> list = this;
		while (list != null) {
			action.accept(list.get());
			list = list.next();
		}
	}

	@Override
	public T get() {
		return headSupplier.get();
	}
	@Override
	public ActualList<T> next() {
		if (tail == null) {
			tail = tailSupplier.get();
		}
		return tail;
	}
}