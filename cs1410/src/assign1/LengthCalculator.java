/**
 * A program that takes input from user in inches and returns the miles, 
 * yards, feet, and remaining inches.
 * 
 * @author - Orenda Williams
 */

package assign1;

import javax.swing.JOptionPane;

public class LengthCalculator {
	
	public static void main(String[]args){
	//Get input from user.
	String userInput = JOptionPane.showInputDialog("Please input total inches:");
	int totalInches = Integer.parseInt(userInput);
	
	//Find miles and remainder.
	int miles = totalInches/63360;
	
	totalInches = totalInches%63360;
	
	//Find yards and remainder.
	
	int yards = totalInches/36;
	
	totalInches = totalInches%36;
	
	//Find feet and remainder.
	
	int feet = totalInches/12;
	
	totalInches = totalInches%12;
	
	//Return all values to user.
		
	JOptionPane.showMessageDialog(null, "Number of miles: " + miles +
										"\nNumber of yards: " + yards +
										"\nNumber of feet: " + feet +
										"\nNumber of inches: " + totalInches);
	
	}
}
