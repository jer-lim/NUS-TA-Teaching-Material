import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
   static boolean isSquare(int n) {
       return IntStream
           .range(1, n / 2)
           .anyMatch(x -> n == x * x);
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println(isSquare(sc.nextInt()));
   }
}
