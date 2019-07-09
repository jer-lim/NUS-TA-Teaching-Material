import java.util.*;
import java.util.function.*;

interface MyIntStream {
	public MyIntStream peek(Consumer<? super Integer> c); 
	public void addNumber(int i);
}

class IntStream implements MyIntStream {
	List<Integer> numbers = new LinkedList<Integer>();

	// Disallow creation without any values
	private IntStream() {}

	private IntStream(List<Integer> list) {
		this.numbers = new LinkedList<Integer>(list);
	}

	public static MyIntStream of(int... input) {
		IntStream stream = new IntStream();
		for(int i : input) {
			stream.numbers.add(i);
		}
		return stream;
	}

	public void addNumber(int i) {
		this.numbers.add(i);
	}

	// Intermediate operation example
	@Override
	public MyIntStream peek(Consumer<? super Integer> c) {
		for (int i : this.numbers) {
			c.accept(i);
		}
		return new IntStream(this.numbers);
	}

	@Override
	public String toString() {
		String output = "";
		for (int i : numbers) {
			output += i + ", ";
		}
		return output;
	}
}

public class Main {
	public static void main(String[] args) {
		//MyIntStream stream = new IntStream();
		MyIntStream stream = IntStream.of(1,4,8,15);
		MyIntStream newStream = stream.peek(System.out::println);
		newStream.addNumber(16);
		stream.peek(System.out::println);
		newStream.peek(System.out::println);
	}
}