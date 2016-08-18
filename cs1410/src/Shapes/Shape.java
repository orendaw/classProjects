package Shapes;

import java.text.DecimalFormat;

/**
 * Abstract representation of a shape. Every shape has an area and a perimeter,
 * the calculation of which is defined by each category of shapes (circle,
 * triangle, ...).
 * 
 * @author Erin Parker, last updated 3/21/16
 */
public abstract class Shape implements Comparable<Shape> {

	/**
	 * Computes the area of a Shape object.
	 * 
	 * @return the area of this shape
	 */
	public abstract double area();

	/**
	 * Computes the perimeter of a Shape object.
	 * 
	 * @return the perimeter of this shape
	 */
	public abstract double perimeter();

	/**
	 * Constructs a user-friendly textual representation of this Shape object.
	 * 
	 * @return a string to represent this shape
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		return "perimeter = " + df.format(perimeter());
	}
	
	public int compareTo(Shape other) {
		if(this.perimeter() < other.perimeter()) {
			return -1;
		}
		if(this.perimeter() > other.perimeter()) {
			return 1;
		}
		return 0;
		
		// if they are integers:
		// return this.perimeter() - other.perimeter();
	}
	
	
}