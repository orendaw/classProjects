package Shapes;

/**
 * Representation of a circle.
 * 
 * @author Erin Parker, last updated 3/9/16
 */
public class Circle extends Shape {

	private double radius;
	
	public Circle(double _radius) {
		radius = _radius;
	}
	
	/**
	 * Computes the area of a Circle object.
	 * 
	 * @return the area of this circle
	 */
	public double area() {
		return Math.PI * radius * radius;
	}

	/**
	 * Computes the perimeter of a Circle object.
	 * 
	 * @return the perimeter of this circle
	 */
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	/**
	 * A "dummy" method added to demonstrate situations when this method
	 * can and cannot be called.  For example, if the type of an object
	 * is declared to be a Circle, this method can be called.  If the 
	 * type of an object is declared to be Shape, this method cannot be called.
	 */
	public void dummy() {
		// Intentionally left blank.
	}
}