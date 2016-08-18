package Shapes;

/**
 * Representation of a triangle.
 * 
 * @author Erin Parker, last updated 3/9/16
 */
public class Triangle extends Shape {

	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(double _side1, double _side2, double _side3) {
		side1 = _side1;
		side2 = _side2;
		side3 = _side3;
	}
	
	/**
	 * Computes the area of a Triangle object.
	 * 
	 * @return the area of this triangle
	 */
	public double area() {
		double p = perimeter() / 2;
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}
	
	/**
	 * Computes the perimeter of a Triangle object.
	 * 
	 * @return the perimeter of this triangle
	 */
	public double perimeter() {
		return side1 + side2 + side3;
	}
}