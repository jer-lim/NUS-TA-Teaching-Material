import java.util.function.*;
import java.util.stream.*;

// Revision done in class in case functional interfaces come out in the plab
// NumberMapper maps a number using a predefined TriFunction
class Main2 {
	public static void main(String[] args) {
		NumberMapper nm = new NumberMapper(1);
		

		// Interfaces can have default methods
		A a = new A();
		System.out.println(a.increase(999));

		// The usual way
		System.out.println(
			nm.change(a)
		);

		// Lambda
		System.out.println(
			nm.change(
			(i,j,k) -> i+j+k
			)
		);

		// Anonymous Class
		System.out.println(
			nm.change(
			new TriFunction<Integer,Integer,Double,Double>() {
				@Override
				public Double apply(Integer one, Integer two, Double three) {
					return one + two + three;
				}
			}
			)
		);
	}
}

@FunctionalInterface
interface TriFunction<T,U,V,R> {
	R apply(T one, U two, V three);

	default int increase(int n) {
		return n+1;
	}
}

class A implements TriFunction<Integer, Integer, Double, Double> {
	@Override
	public Double apply(Integer one, Integer two, Double three) {
		return one + two + three;
	}
}

class NumberMapper {
	int n;
	public NumberMapper(int n) {
		this.n = n;
	}

	public double change(TriFunction<Integer,Integer,Double,Double> f) {
		return f.apply(n, n, n + 0.1);
	}
}