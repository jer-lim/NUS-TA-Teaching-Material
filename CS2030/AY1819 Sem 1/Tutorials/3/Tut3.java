class A {int x;A(int x) {this.x = x;}public A method() {return new A(x);}}
class B extends A {B(int x) {super(x);}public B method() {return new B(x);}}

public class Tut3 {
	public static void main(String[] args) {
		A b = new B(10);
		b.method();
	}
}