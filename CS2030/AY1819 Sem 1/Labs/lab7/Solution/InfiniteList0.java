package cs2030.mystream;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.BinaryOperator;
import java.util.Optional;
import java.util.Scanner;
import java.util.ArrayList;

class InfiniteList0<T> implements InfiniteList<T> {

    Supplier<T> head;
    Supplier<InfiniteList0<T>> tail;
    Predicate<T> filterPredicate;
    Optional<Boolean> headFiltered;


    InfiniteList0() { }

    private InfiniteList0(Supplier<T> head) {
        this.head = head;
        headFiltered = Optional.empty();
    }

    InfiniteList0(Supplier<T> head, Supplier<InfiniteList0<T>> tail) {
        this.head = head;
        this.tail = tail;
        headFiltered = Optional.empty();
    }

    private InfiniteList0(Supplier<T> head, Supplier<InfiniteList0<T>> tail, 
            Optional<Boolean> headFiltered) {
        this.head = head;
        this.tail = tail;
        this.headFiltered = headFiltered;
    }

    private InfiniteList0(Supplier<T> head, Supplier<InfiniteList0<T>> tail, 
            Predicate<T> filterPredicate, Optional<Boolean> headFiltered) {
        this.head = head;
        this.tail = tail;
        this.filterPredicate = filterPredicate;
        this.headFiltered = headFiltered;
    }

    public static <T> InfiniteList0<T> generate(Supplier <T> s) {
        return new InfiniteList0<T>(s, () -> InfiniteList0.generate(s));
    }

    public static <T> InfiniteList0<T> iterate(T seed, Function<T,T> next) {
        return new InfiniteList0<T>(() -> seed,
                () -> InfiniteList0.iterate(next.apply(seed), next));
    }

    public InfiniteList0<T> limit(int n) {
        if (n <= 0) {
            return new EmptyList<T>();
        } else  if (isHeadFiltered()) {
            return new InfiniteList0<T>(head, () -> tail.get().limit(n), Optional.of(true));
        } else if (n == 1) {
            return new InfiniteList0<T>(head, () -> new EmptyList<T>());
        } else {
            return new InfiniteList0<T>(head, () -> tail.get().limit(n - 1));
        }
    }

    public <R> InfiniteList0<R> map(Function<? super T, ? extends R> mapper) {
        if (isHeadFiltered()) {
            return new InfiniteList0<R>(() -> mapper.apply(head.get()), () -> tail.get().map(mapper), Optional.of(true));
        } else {
            return new InfiniteList0<R>(() -> mapper.apply(head.get()), () -> tail.get().map(mapper), Optional.empty());

        }
    }

    public InfiniteList0<T> filter(Predicate<T> predicate) {
        if (isHeadFiltered()) {
            return new InfiniteList0<T>(head, () -> tail.get().filter(predicate), predicate, Optional.of(true));
        } else {
            return new InfiniteList0<T>(head, () -> tail.get().filter(predicate), predicate, Optional.empty());
        }
    }

    public boolean isEmpty() {
        return false;
    }

    public <U> U reduce (U identity, BiFunction<U, ? super T, U> accumulator) {
        U result = identity;
        InfiniteList0<T> list = this;
        while (!list.isEmpty()) {
            if (!list.isHeadFiltered()) {
                result = accumulator.apply(result, list.head.get());
            }
            list = list.tail.get();
        }
        return result;
    }

    public Optional<T> reduce (BinaryOperator<T> accumulator) {
        T result = null;
        boolean stillEmpty = true;
        InfiniteList0<T> list = this;
        while (!list.isEmpty()) {
            if (!list.isHeadFiltered()) {
                if (stillEmpty) {
                    result = list.head.get();
                    stillEmpty = false;
                } else {
                    result = accumulator.apply(result, list.head.get());
                }
            }
            list = list.tail.get();
        }
        if (stillEmpty) {
            return Optional.empty();
        } else {
            return Optional.of(result);
        }
    }


    public long count() {
        long i = 0;
        InfiniteList0<T> list = this;
        while (!list.isEmpty()) { // only empty if EmptyList instance
            if (!list.isHeadFiltered()) {
                i++;
            }
            list = list.tail.get();
        }
        return i;
    }

    public void forEach(Consumer<T> action) {
        InfiniteList0<T> list = this;
        while (!list.isEmpty()) {
            if (!list.isHeadFiltered()) {
                action.accept(list.head.get());
            }
            list = list.tail.get();
        }
    }

    public InfiniteList0<T> takeWhile(Predicate<T> predicate) {
        if (!this.isHeadFiltered()) {
            T myhead = this.head.get();
            if (!predicate.test(myhead)) {
                return new EmptyList<T>();
            }
            return new InfiniteList0<T>(() -> myhead, () -> tail.get().takeWhile(predicate));
        }
        return new InfiniteList0<T>(head, () -> tail.get().takeWhile(predicate), Optional.of(true));
    }

    public Object[] toArray() {
        ArrayList<Object> array = new ArrayList<>();
        InfiniteList0<T> list = this;
        while (!list.isEmpty()) {
            if (!list.isHeadFiltered()) {
                array.add(list.head.get());
            }
            list = list.tail.get();
        }
        return array.toArray();
    }

    private boolean isHeadFiltered() {
        boolean filtered = headFiltered.orElseGet(() -> {
        if (filterPredicate == null)
            return false;
        else 
            return !this.filterPredicate.test(this.head.get());
        });
        return filtered;
    }

    public String toString() {
        (new Scanner(System.in)).nextLine();
        return head + "(" + isHeadFiltered() + ")" + tail;
    }
}
