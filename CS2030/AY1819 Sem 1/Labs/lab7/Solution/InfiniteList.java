package cs2030.mystream;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.BinaryOperator;
import java.util.Optional;

public interface InfiniteList<T> {

    public static <T> InfiniteList<T> generate(Supplier <T> s) {
        return InfiniteList0.generate(s);
    }

    public static <T> InfiniteList<T> iterate(T seed, Function<T,T> next) {
        return InfiniteList0.iterate(seed, next); 
    }

    public InfiniteList<T> limit(int n);
    public <R> InfiniteList<R> map(Function<? super T, ? extends R> mapper);
    public InfiniteList<T> filter(Predicate<T> predicate);
    public boolean isEmpty();
    public <U> U reduce (U identity, BiFunction<U, ? super T, U> accumulator);
    public Optional<T> reduce (BinaryOperator<T> accumulator);
    public long count();
    public void forEach(Consumer<T> action);
    public InfiniteList<T> takeWhile(Predicate<T> predicate);
    public Object[] toArray();
}
