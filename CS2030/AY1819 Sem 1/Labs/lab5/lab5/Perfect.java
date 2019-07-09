import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
   static boolean isPerfect(int n) {
       int sum = IntStream
           .range(1, n)
           .filter(x -> n % x == 0)
           .sum();

       return sum == n;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println(isPerfect(sc.nextInt()));
   }
}
