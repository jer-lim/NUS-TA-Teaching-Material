abstract class AbstractClass {
	int a;
	public AbstractClass(int a) {
		this.a = a;
	}

	protected abstract void f();

	public void g() {
		this.f();
	}
}

class A extends AbstractClass {
	public A(int a) {
		// Calls AbstractClass(a)
		super(a);
	}

	@Override
	protected void f() {
		this.a++;
	}

	// g() calls this f()
}