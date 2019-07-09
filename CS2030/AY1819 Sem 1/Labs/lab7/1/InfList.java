import java.util.function.*;

class InfList<T> implements InfiniteList<T> {
	Supplier<T> headSupplier;
	Supplier<InfList<T>> tailSupplier;
	public InfList(Supplier<T> h, Supplier<InfList<T>> t) {
		this.headSupplier = h;
		this.tailSupplier = t;
	}

	public static <T> InfList<T> generate(Supplier<T> supplier) {
		return new InfList<T>(supplier, () -> InfList.generate(supplier));
	}

}