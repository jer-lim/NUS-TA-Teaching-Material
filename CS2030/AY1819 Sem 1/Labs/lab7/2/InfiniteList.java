import java.util.function.*;

public interface InfiniteList<T> {
	public static <T> InfiniteList<T> generate(Supplier<T> supplier) {
		return InfList.generate(supplier);
	}

	public T get();

	public InfiniteList<T> next();
}