import java.util.*;
import java.util.function.*;

class Generics {
	public static void main(String[] args) {
		List<Number> list = new ArrayList<Number>();
		ArrayList<? extends Number> list2 = new ArrayList<Integer>();
		List<? extends Number> list3 = new ArrayList<Integer>();

		Predicate<Double> f = x -> x.isInfinite();

	}
}