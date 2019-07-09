import java.util.*;
public class TerribleCode {
    public static void main(String[] args) {
        //Read in a stream of integers (delimited by new line) until EOF.
        //Print the sum of all positive integers.
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int numInputs = recursiveInput(numbers, new Scanner(System.in), 0);
        System.out.print(recursiveSum(numbers,numInputs));
    }

    private static int recursiveInput(List<Integer> list, Scanner scanner, int nextNumber) {
    	if (scanner.hasNext()) {
    		nextNumber = scanner.nextInt();
    		if (nextNumber > -1) {
    			return 1 + recursiveInput(list,scanner,nextNumber);
    		}
    	}
    	return 0;
    }

    private static int recursiveSum(List<Integer> list, int counter) {
    	return --counter > -1 ?
    		list.get(counter) + recursiveSum(list,counter)
    		: 0;
    }
}
