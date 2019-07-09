import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

class Main {
   static long countRepeats(int[] array) {
      return IntStream
         .rangeClosed(1, array.length - 1)
         .filter(x -> array[x - 1] == array[x] &&
                 (x == array.length - 1 ||
                  array[x] != array[x + 1]))
         .count();
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

      System.out.println("Number of occurrences: " + 
              countRepeats(toIntArray(list)));
   }
}
