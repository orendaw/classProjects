package Shapes;

/**
 * Representation of a rectangle.
 * 
 * @author Erin Parker and CS 1410 class, last updated 3/9/16
 */
public class Rectangle extends Shape {
	
	private double length;
	private double width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	/**
	 * Computes the area of a Rectangle object.
	 * 
	 * @return the area of this rectangle
	 */
	public double area() {
		return length * width;
	}

	/**
	 * Computes the perimeter of a Rectangle object.
	 * 
	 * @return the perimeter of this rectangle
	 */
	public double perimeter() {
		return 2 * length + 2 * width;
	}
}
