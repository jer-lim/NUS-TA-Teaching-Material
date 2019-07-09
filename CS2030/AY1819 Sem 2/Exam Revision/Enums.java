// Most basic enum
enum Color {
	RED,
	BLUE,
	GREEN,
	YELLOW,
	BLACK,
	WHITE
}

enum Color2 {
	RED(1,0,0),
	BLUE(0,0,1),
	GREEN(0,1,0),
	YELLOW(1,1,0),
	BLACK(0,0,0),
	WHITE(1,1,1);

	double red;
	double green;
	double blue;

	Color2(double r, double g, double b) {
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public double redness() {
		return this.red;
	}
}

class Enums {
	public static void main(String[] args) {
		System.out.println(isRed(Color.RED));
		System.out.println(isRed(Color.BLACK));

		System.out.println(Color2.RED.redness());
		System.out.println(Color2.GREEN.redness());
	}

	static boolean isRed(Color c) {
		return c == Color.RED;
	}
}

