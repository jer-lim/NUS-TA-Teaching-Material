import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numPoints = scanner.nextInt();

		Point points[] = new Point[numPoints];
		for (int i = 0; i < numPoints; ++i) {
			points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
		}

		// Level 1
		/*for (int i = 0; i < numPoints; ++i) {
			System.out.println(points[i]);
		}*/

		// Level 2
		/*for (int i = 0; i < numPoints-1; ++i) {
			System.out.println(points[i] + " and " + points[i+1]
				+ " has mid-point " + points[i].midPoint(points[i+1])
				+ " and angle " + String.format("%.3f", points[i].angleTo(points[i+1])));
		}*/

		// Level 3
		/*for (int i = 0; i < numPoints-1; ++i) {
			if (points[i].distanceTo(points[i+1]) <= 2) {
				Circle c = new Circle(points[i], points[i+1], 1, true);
				System.out.println(points[i] + " and " + points[i+1]
					+ " coincides with circle of centre " + c.getCenter());
			}
		}*/

		// Level 4
		int max = 0;

		for (int i = 0; i < numPoints-1; ++i) {
			Point p = points[i];
			for (int j = i + 1; j < numPoints; ++j) {
				Point q = points[j];

				if (p.distanceTo(q) <= 2) {
					int count = 0;
					Circle c = new Circle(p, q, 1, false);
					for (Point r : points) {
						if (c.contains(r)) count++;
					}
					if (count > max) max = count;

					count = 0;
					c = new Circle(p, q, 1, true);
					for (Point r : points) {
						if (c.contains(r)) count++;
					}
					if (count > max) max = count;
				}

			}
		}

		System.out.println("Maximum Disc Coverage: " + max);
	}
}