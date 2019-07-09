class Parent {
	void f() {
		System.out.println("f");
	}
}

class Child extends Parent {
	void f() {
		throw new UnsupportedOperationException();
	}
}

