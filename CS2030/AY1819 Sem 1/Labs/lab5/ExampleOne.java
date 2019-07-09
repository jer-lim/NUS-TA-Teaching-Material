public class ExampleOne {
	public static void main(String[] args) {
		StringGenerator gen = new StringGenerator();
		String allCaps, noCaps;

		// Lambda is inferred as a StringTransformer
		allCaps = gen.getString((s) -> { return s.toUpperCase(); });
		noCaps = gen.getString((s) -> s.toLowerCase());
		print("Lambdas", allCaps, noCaps);

		// Can also pass in predefined methods
		allCaps = gen.getString(AllCaps::f);
		noCaps = gen.getString(NoCaps::f);
		print("Static methods", allCaps, noCaps);

		// Or store functions in variables
		StringTransformer capsLock = (s) -> s.toUpperCase();
		StringTransformer smallLock = (s) -> s.toLowerCase();
		allCaps = gen.getString(capsLock);
		noCaps = gen.getString(smallLock);
		print("Stored lambdas", allCaps, noCaps);
	}

	private static void print(String title, String one, String two) {
		System.out.println(title);
		System.out.println(one);
		System.out.println(two + "\n");
	}
}

@FunctionalInterface
interface StringTransformer {
	public String transform(String b);
}

class A implements StringTransformer {
	@Override
	public String transform(String b) {
		return b.toUpperCase();
	}
}

class StringGenerator {
	// Apply a transformation to a string given a StringTransformer
	public String getString(StringTransformer fi) {
		return fi.transform("DuRr HuRr DuRr");
	}
}

class AllCaps {
	public static String f(String s) {
		return s.toUpperCase();
	}
}

class NoCaps {
	public static String f(String s) {
		return s.toLowerCase();
	}
}