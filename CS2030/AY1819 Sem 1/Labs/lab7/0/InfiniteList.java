import java.util.function.*;

public interface InfiniteList<T> {
	public static <T> InfiniteList<T> generate(Supplier<T> supplier) {
		return MyList.generate(supplier);
	}

	public static <T> InfiniteList<T> iterate(T seed, UnaryOperator<T> next) {
		return MyList.iterate(seed, next);
	}

	public T get();
	public InfiniteList<T> next();
	public InfiniteList<T> limit(int size);
	public void forEach(Consumer<? super T> action);
}

class MyList<T> implements InfiniteList<T> {
	Supplier<T> headSupplier;
	Supplier<MyList<T>> tailSupplier;

	private MyList(Supplier<T> headSupplier, Supplier<MyList<T>> tailSupplier) {
		this.headSupplier = headSupplier;
		this.tailSupplier = tailSupplier;
	}

	public static <T> MyList<T> generate(Supplier<T> supplier) {
		return new MyList<T>(supplier,
			() -> MyList.generate(supplier));
	}

	public static <T> MyList<T> iterate(T seed, UnaryOperator<T> next) {
		return new MyList<T>(() -> seed,
			() -> MyList.iterate(next.apply(seed), next));
	}

	@Override
	public MyList<T> limit(int size) {
		if (size == 1) {
			return new MyList<T>(headSupplier,
			() -> null);
		}
		return new MyList<T>(headSupplier,
			() -> this.tailSupplier.get().limit(size - 1));
	}

	@Override
	public void forEach(Consumer<? super T> action) {
		MyList<T> list = this;
		while (list != null) {
			action.accept(list.headSupplier.get());
			list = list.tailSupplier.get();
		}
	}

	@Override
	public T get() {
		return headSupplier.get();
	}

	@Override
	public MyList<T> next() {
		return tailSupplier.get();
	}
}