class Circle {
	Point center;
	int radius;

	public boolean contains(Point p) {
		...
	}
}

class Point {
	double x;
	double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object p) {
		if (!p instanceof Point) return false;
		return (this.x == p.x && this.y == p.y);
	}

	@Override
	public String toString() {
		return "(" + String.format("%.3f", this.x) + ", "
				+ String.format("%.3f", this.y) + ")";
	}
}

