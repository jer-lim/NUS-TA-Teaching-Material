import java.util.stream.*;

class Main {
	public static void main(String[] args) {
		IntStream numbers = IntStream.rangeClosed(1, 100);
		numbers.filter(Main::isPerfect)
		.forEach((i) -> System.out.println(i));
	}

	public static boolean isPerfect(int n) {
		return IntStream.range(1, n)
				.filter((i) -> (n % i == 0))
				.reduce(0, (i, j) -> (i + j)) == n;
	}
}