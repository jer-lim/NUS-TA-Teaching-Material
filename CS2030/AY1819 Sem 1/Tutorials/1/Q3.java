class Q3 {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(0, 0), 10);
		Circle c2 = new Circle(new Point(0, 0), 10);
		Object o1 = c1;
		Object o2 = c2;

		System.out.println(o1.equals(o2));
		System.out.println(o1.equals((Circle) o2));
		System.out.println(o1.equals(c2));
		System.out.println(o1.equals(c1));
		System.out.println(c1.equals(o2));
		System.out.println(c1.equals((Circle) o2));
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(o1));
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Point p) {
		return this.x == p.x && this.y == p.y;
	}
}

class Circle {
	Point centre;
	double radius;
	public Circle(Point centre, double radius) {
		this.centre = centre;
		this.radius = radius;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals(Object) called");
		if (obj == this) {
			return true;
		}
		if (obj instanceof Circle) {
			Circle circle = (Circle) obj;
			return (circle.centre.equals(centre) && circle.radius == radius);
		} else {
			return false;
		}
	}
	public boolean equals(Circle circle) {
		System.out.println("equals(Circle) called");
		return circle.centre.equals(centre) && circle.radius == radius;
	}
}

class A {
	void one(){}
	void two(){}
}

class B extends A {
	void one(){}
	void two(){}
	void three(){}
}

class C {
	public static void main(String[] args) {
		B b = new B();
		A a = b;
	}
}