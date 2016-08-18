package Shapes;

import java.util.Arrays;
import java.util.Random;

/**
 * This program demonstrates how to use the classes of the
 * Shape hierarchy.
 * 
 * @author Erin Parker, last updated 3/21/16
 */
public class ShapeDemo {
	
	// bounds on size of random shapes
	public static final int HIGH = 50; 
	public static final int LOW = 10;  

	public static void main(String[] args) {
		
		Random rng = new Random();
		
		// This one example of the power and convenience of inheritance --
		// we can collect "different" shapes in a single array because all
		// of the classes used have Shape as the base class.  (E.g., a 
		// Circle IS-A Shape.)
		Shape[] arr = new Shape[10];
		
		for(int i = 0; i < arr.length; i++) {
			int randNum = rng.nextInt(3);  // generates integer 0, 1, or 2
			
			if(randNum == 0) {
				arr[i] = new Circle(rng.nextInt(HIGH) + LOW);
			}
			else if (randNum == 1) {
				arr[i] = new Rectangle(rng.nextInt(HIGH) + LOW, rng.nextInt(HIGH) + LOW);
			}
			else {
				arr[i] = new Triangle(rng.nextInt(HIGH) + LOW, rng.nextInt(HIGH) + LOW, 
						rng.nextInt(HIGH) + LOW);
			}
		}
		
		// Use existing code to sort the shapes by perimeter and display.
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}