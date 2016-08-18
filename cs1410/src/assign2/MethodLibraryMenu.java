package assign2;

import javax.swing.JOptionPane;

/**
 * This class runs a program that presents the user with some options to select that will then be calculated
 * and displayed back to them. 
 * 
 *  date: 1/28/201
 * @author Orenda Williams
 *
 */

public class MethodLibraryMenu {
	
	public static void main(String[] args){
		
		int choice = 0;
		while (choice != 4){
			
			choice = Integer.parseInt(JOptionPane.showInputDialog("1 - Convert gallons to cups \n "
																+ "2 - Convert Fahrenheit to Celsius \n "
																+ "3 - Check sign \n "
																+ "4 - Quit \n"
																+ "Enter your selection:"));
			
			if(choice == 1){
				int gallons = Integer.parseInt(JOptionPane.showInputDialog("Enter number of gallons: "));
				if (gallons >= 0){
					JOptionPane.showMessageDialog(null, gallons + " gallons is " + convertGallonsToCups(gallons) + " cups.");
				}
				else
					JOptionPane.showMessageDialog(null, "Please enter a non-negative number of gallons.");
					
			}
			else if(choice == 2){
				int degreesF = Integer.parseInt(JOptionPane.showInputDialog("Enter the degrees in Fahrenheit: "));
				JOptionPane.showMessageDialog(null, degreesF + " degrees Fahrenheit is " + convertFahrenheitToCelsius(degreesF) + " degrees Celsius.");
				
			}
			else if(choice == 3){
				int number = Integer.parseInt(JOptionPane.showInputDialog("Enter number to check: "));
				JOptionPane.showMessageDialog(null, number + " is " + describeSign(number) + ".");
			}
			else if(choice != 4){
				JOptionPane.showMessageDialog(null, choice + " is not a valid option. Please enter another selection.");
			}
		}
		
		
	}
	
	/**
	 * Calculates the number of cups that has the equivalent volume for the
	 * given number of gallons.
	 * @param gallons - the number of gallons to convert
	 * @return the number of cups converted
	 */
	public static int convertGallonsToCups(int gallons) {
		// using a conversion rate of 16 cups / gallon

		return gallons * 16;
	}
	
	/**
	 * This method calculates the temperature in Celcius when given the temperature in Fahrenheit 
	 * @param tempFahrenheit - degrees in Fahrenheit
	 * @return returns degrees in Celcius as a double
	 */
	public static double convertFahrenheitToCelsius(int tempFahrenheit){
		// using conversion formula Tc = (Tf - 32)* (5/9)
		return (tempFahrenheit - 32) * (5./9.);
	}
	
	/**
	 * This methods takes in an integer value (number) and returns a string describing
	 * the sign of the number (postive/negative/zero).
	 * @param number to be examined for sign.
	 * @return possible return values : "positive", "negative", "zero"
	 */
	public static String describeSign(int number){
		if (number > 0)
			return "positive";
		else if (number < 0)
			return "negative";
		else
			return "zero";
	}
}
