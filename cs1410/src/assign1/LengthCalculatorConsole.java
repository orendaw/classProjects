/**
 * A program that takes input from user in inches and returns the miles, 
 * yards, feet, and remaining inches.
 * 
 * @author - Orenda Williams
 */

package assign1;

import java.util.Scanner;

public class LengthCalculatorConsole {
	
	public static void main(String[]args){
	//Get input from user. I learned about Scanner input via YouTuber OnliveGamer (https://www.youtube.com/watch?v=JpoI_rdMgLM)
	System.out.print("Please input total inches: \n");
	Scanner userInput = new Scanner(System.in);
	int totalInches = Integer.parseInt(userInput.nextLine());
	userInput.close();
	
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
		
	System.out.println("Number of miles: " + miles +
										"\nNumber of yards: " + yards +
										"\nNumber of feet: " + feet +
										"\nNumber of inches: " + totalInches);
	
	}
}
