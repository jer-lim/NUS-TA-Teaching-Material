class Q4 {
	public static void main(String[] args) {
		ArrayList<Rectangle> shapes;

		for (Rectangle s : shapes) {
			s.resize(2,3);
			// Squares become rectangles!
		}

		for (Square s : shapes) {
			s.resize(2);
			System.out.println(s.getArea());
		}
	}
}

class Rectangle extends Square {
	int width; // Inherited
	int height;

	public Rectangle(int w, int h) {
		super(w); // Reuse Square constructor
		this.height = h;
	}

	// Reimplement everything
	// because of the new variable
}
