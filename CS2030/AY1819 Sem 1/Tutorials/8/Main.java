import java.util.function.*;
import java.util.stream.*;

class Main {
	public static void main(String[] args) {
		IntStream nums = IntStream.rangeClosed(0, 8);
		nums.map(i -> (new Fibbonaccer(i)).compute())
		.forEach(System.out::println);
	}
}