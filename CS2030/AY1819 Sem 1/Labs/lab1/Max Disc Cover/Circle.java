import java.lang.Math;

/**
 * Encapsulates a circle on a 2D plane.
 * @author Ooi Wei Tsang
 * @author Jeremy Lim A0164823A
 * @version CS2030 AY17/18 Sem 1 Lab 1
 */
public class Circle {
	private Point center;
	private double radius;

	/**
	 * Creates a circle that passes through both points p and q.
	 * Given any two points, there are exactly two circles that passes
	 * through both points.  Imagine you are walking from p to q, one
	 * of the circles would have the center on the left.  The other have
	 * the center on the right.
	 *
	 * If p and q are at the same point, then an infinite number of such
	 * circles exist.  If p and q are more than 2*radius apart, then
	 * no such circle exist.  In such case, create a circle with radius
	 * equals to Double.NaN.
	 *
	 * @param p the point where the created circle will passed through
	 * @param q another point where the created circle will passed through
	 * @param radius the radius of the circle created
	 * @param centerOnLeft if true, will return the circle with the center
	 *        on the left of line p to q; otherwise, on the right.
	 */
	public Circle(Point p, Point q, double radius, boolean centerOnLeft) {
		// TODO: Add you code here
		double pqLength = p.distanceTo(q);
		double pqAngle = p.angleTo(q);

		if (pqLength > 2 * radius){
			this.center = new Point(0, 0);
			this.radius = Double.NaN;
		} else {

			// Create center vector at PQ/2
			Point center = new Point(p, q);

			// Find MC
			// Angle of MC calculated by rotating PQ (MQ) 90 deg
			double mcLength = Math.sqrt((radius * radius) - ((pqLength / 2) * (pqLength / 2)));
			double mcAngle = centerOnLeft ? pqAngle + (Math.PI / 2) : pqAngle - (Math.PI / 2);

			center.move(mcAngle, mcLength);

			this.center = center;
			this.radius = radius;
		}
	}

	/**
	 * Creates a circle centered at center with given radius.
	 *
	 * @param center the point where the created circle is centered at
	 * @param radius the radius of the circle created
	 */
	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	/**
	 * Move the center of the centered to new position
	 *
	 * @param newPosition the new position of the circle
	 * @param radius the radius of the circle created
	 */
	public void moveTo(Point newPosition) {
		this.center = newPosition;
	}

	/**
	 * Return the area of the circle
	 *
	 * @return the area of the circle
	 */
	public double getArea() {
		return Math.PI*radius*radius;
	}

	/**
	 * Return radius of circle
	 * @return radius of circle
	 */
	public double getRadius() {
		return this.radius;
	}

	public Point getCenter() {
		return this.center;
	}

	/**
	 * Checks if point p is contained within this circle (including
	 * on the edge of the circle, up to the accuracy of 0.00001).
	 *
	 * @param p a point to check for containment
	 * @return true if this circle contains p; false otherwise.
	 */
	public boolean contains(Point p) {
		return p.distanceTo(center) < radius + 0.00001;
	}

	/**
	 * Return the perimeter of the circle.
	 *
	 * @return the perimeter of the circle.
	 */
	public double getPerimeter() {
		return Math.PI*2*radius;
	}

	/**
	 * Return a string representation of the circle, prefixing the
	 * coordinates of the center with "c:" and the radius with "r:"
	 *
	 * @return the string representation of this circle.
	 */
	@Override
	public String toString() {
		return "[" + super.toString() + " c: " + center + " r: " + radius + "]";
	}

	/**
	 * Check if a given circle has the same center and same radius.
	 *
	 * @param obj the circle to check
	 *
	 * @return true if obj is a circle and has the same center and
	 * radius as this circle; false otherwise or if obj is not a circle.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle c = (Circle)obj;
			return ((c.radius == radius) && (c.center.equals(center)));
		} else {
			return false;
		}
	}
}
