class A {
	String s;
	int i;

	public A(String s, int i) {
		this.s = s;
		this.i = i++;
	}

	public void f(A o) {
		s = o.g(i);
		i++;
	}

	public String g(int x) {
		x++;
		return s + (i + x);
	}

	public String toString() {
		return s + i;
	}
}

class Codetrace2 {
	public static void main(String[] args) {
		A a = new A("a", 1);
		A b = new A("b", 2);
		System.out.println(a + " " + b);
		a.f(b);
		System.out.println(a + " " + b);
	}
}