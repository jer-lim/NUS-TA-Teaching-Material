package cs2030.mystream;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Function;

class EmptyList<T> extends InfiniteList0<T> {
    
    EmptyList() { }

    public boolean isEmpty() {
        return true;
    }

    public <R> InfiniteList0<R> map(Function<? super T, ? extends R> mapper) {
        return new EmptyList<R>();
    }

    public InfiniteList0<T> filter(Predicate<T> predicate) {
        return this;
    }

    public InfiniteList0<T> limit(int n) {
        return this;
    }

    public String toString() {
        (new Scanner(System.in)).nextLine();
        return "EMPTY: " + head + "(" + headFiltered + ")" + tail;
    }

}
