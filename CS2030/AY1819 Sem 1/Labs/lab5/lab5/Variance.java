import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.OptionalDouble;

class Main {

    public static OptionalDouble variance(int[] array) {
        long count = IntStream.of(array).count();

        if (count == 0) {
            return OptionalDouble.empty();
        } else {
            double average = IntStream.of(array)
                .average()
                .getAsDouble();

            double sum = IntStream.of(array)
                .mapToDouble(x -> (x - average) * (x - average))
                .sum();

            return OptionalDouble.of(sum / (count - 1));
        }
    }

   static int[] toIntArray(List<Integer> list) {
       int[] array = new int[list.size()];
       int i = 0;

       for (int item : list) {
           array[i] = item;
           i++;
       }

       return array;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      List<Integer> list = new ArrayList<>();
      int n;

      while(sc.hasNextInt()) {
         list.add(sc.nextInt());
      }

      System.out.println("Variance: " + variance(toIntArray(list)));
   }
}
