package assign8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WarGame {
	
	public static void main(String[] args) {

		System.out.println("Let's play a game of WAR. How many cards would you like to play with?");

		// Get the number of cards from the console.
		Scanner consoleScanner = new Scanner(System.in);
		int numOfCards = 1;
		boolean tryAgain = true; // set to make sure loop executes at least once
		while(tryAgain) {
			tryAgain = false; // assume that the user will enter an integer
			System.out.println("Enter an integer between 1 and 26: ");
			try {
				numOfCards = consoleScanner.nextInt();
			}
			catch(InputMismatchException e) {
				consoleScanner.next(); // advance past the non-integer token
				System.out.println("You didn't enter an integer!!");
				tryAgain = true; // the user did not input an integer, set to ensure repeat
			}
			if(numOfCards < 1 || numOfCards > 26) {
				System.out.println("Your integer is not between 1 and 26!!");
				tryAgain = true;
			}
		}
	
		// Deal two hands.
		Deck d = new Deck();
		d.shuffle();
		Hand dealerHand = new Hand();
		Hand userHand = new Hand();
		for(int i = 0; i < numOfCards; i++) {
			dealerHand.addCard(d.deal());
			userHand.addCard(d.deal());
		}
		
		// Play WAR.
		int dealerScore = 0;
		int userScore = 0;
		for(int i = 0; i < numOfCards; i++) {
			PlayingCard dealerCard = dealerHand.getCard(i);
			PlayingCard userCard = userHand.getCard(i);
		
			System.out.println("\nDealer's card: " + dealerCard);
			System.out.println("Your card: " + userCard);
			
			if(dealerCard.compareTo(userCard) < 0) {
				userScore++;
				System.out.println("You win this round!");
			}
			else {
				dealerScore++;
				System.out.println("Dealer wins this round!");
			}
			System.out.println("Your score is " + userScore + ". Dealer score is " + dealerScore + ".");
		}
		
		System.out.println("\nFinal score is " + userScore + " for you and " + dealerScore + " for the dealer.");
		if(userScore > dealerScore)
			System.out.println("YOU WIN!!");
		else if(dealerScore > userScore)
			System.out.println("Dealer wins :(");
		else
			System.out.println("It's a tie.");
	}
}
