class A {
	public int b;
	public A (int c) {
		this.b = c;
	}
	public void f(A other, int c) {
		c++;
		this.b++;
		other.b += c;
	}
}

public class Codetrace {
	public static void main(String[] args) {
		A a = new A(2);
		A b = new A(4);
		int c = 3;
		System.out.println(a.b + " " + b.b + " " + c);
		a.f(b, c);
		System.out.println(a.b + " " + b.b + " " + c);
	}
}



