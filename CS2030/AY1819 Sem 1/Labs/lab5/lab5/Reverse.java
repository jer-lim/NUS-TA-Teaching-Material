import java.util.Scanner;
import java.util.stream.IntStream;

class Main {

   static int reverse(int n) {
       int rev = IntStream
           .iterate(n, x -> x > 0, x -> x / 10)
           .reduce(0, (x, y) -> x * 10 + y % 10);

       return rev;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println(reverse(sc.nextInt()));
   }
}
