import java.lang.Math;

/**
 *  Encapsulates a point on a 2D plane.  
 *  @author Ooi Wei Tsang 
 *  @author Jeremy Lim A0164823A
 *  @version CS2030 AY17/18 Sem 1 Lab 1
 */
public class Point {
	private double x;
	private double y;

	/**
	 * Create a point at coordinate (x, y)
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Create a point as a midpoint between two given points p and q
	 *
	 * @param p the first point
	 * @param q the second point
	 */
	public Point(Point p, Point q) {
		// TODO: Add your code here
		this.x = (p.getX() + q.getX()) / 2;
		this.y = (p.getY() + q.getY()) / 2;
	}

	/**
	 * Clone another point
	 * @param q the point to clone
	 */
	public Point(Point q) {
		this.x = q.getX();
		this.y = q.getY();
	}

	/**
	 * Create a point as a midpoint between this point and q
	 *
	 * @param q the second point
	 */
	public Point midPoint(Point q) {
		return new Point(
			(this.x + q.x) / 2,
			(this.y + q.y) / 2);
	}


	/**
	 * Calculate the Euclidean distance of this point to a given point q.
	 *
	 * @param q another point
	 * @return the Euclidean distance between this point and q.
	 */
	public double distanceTo(Point q) {
		// TODO: Add your code here
		// Java is bad and this is super slow
		//return Math.hypot(q.getX() - this.x, q.getY() - this.y);

		return Math.sqrt((q.getX() - this.x) * (q.getX() - this.x) + (q.getY() - this.y) * (q.getY() - this.y));
	}

	/**
	 * Calculate the angle between this point and a given point q
	 *
	 * @param q another point
	 * @return the angle between this point and the given point q
	 */
	public double angleTo(Point q) {
		// TODO: Add your code here
		return Math.atan2(q.getY() - this.y, q.getX() - this.x);
	}

	/**
	 * Move the current point by a distance d at a given direction.
	 *
	 * @param theta the angle of the direction to move, in radian.
	 * @param d the distance to move
	 */
	public void move(double theta, double d) {
		// TODO: Add your code here
		this.x = this.x + d * Math.cos(theta);
		this.y = this.y + d * Math.sin(theta);
	}
	
	/**
	 * @return x
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * @return y
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Return a string representation of the point, showing its
	 * coordinates.
	 */
	@Override
	public String toString() {
		return String.format("(%.3f, %.3f)", x, y);
	}

	/**
	 * Check if a given point has the same coordinate as this point.
	 *
	 * @param obj The point to check against
	 * @return true if obj is a point and has the same coordinate; false
	 * otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point)obj;
			return (Math.abs(p.x - x) < 1E-15) && (Math.abs(p.y - y) < 1E-15);
		} else {
			return false;
		}
	}
}
