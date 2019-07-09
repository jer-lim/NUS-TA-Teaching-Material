import java.util.Scanner;
import java.util.stream.IntStream;

class Main {

    static boolean isPrime(int x) {
        return IntStream
            .range(2, x)
            .noneMatch(d -> x % d == 0);
    }

    static IntStream factors(int x) { 
        return IntStream
            .rangeClosed(2, x)
            .filter(d -> x % d == 0);
    }

    static IntStream primeFactors(int x) {
        return factors(x)
            .filter(d -> isPrime(d));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("Prime factors of " + n + " are:");
        primeFactors(n)
            .forEach(x -> System.out.print(" " + x));
        System.out.println();



        //System.out.println(Reverse(sc.nextInt()));
    }
}
