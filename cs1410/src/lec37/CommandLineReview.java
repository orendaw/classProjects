package lec37;

/**
 * This program adds X to Y, Z times and prints the result.  
 * It assumes that the user runs the program with command-line 
 * arguments X Y Z (in that order).
 * 
 * Examples:
 * 	  java CommandLineReview 2 3 4          prints 11
 * 	  java CommandLineReview 3 2 4          prints 14
 * 	  java CommandLineReview 10 0 5         prints 50
 * 
 * @author Erin Parker, last updated 4/20/16 
 */
public class CommandLineReview {

	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);

		int result = y;
		for(int i = 0; i < z; i++) {
			result += x;
		}
		
		System.out.println("The result is " + result);
	}
}