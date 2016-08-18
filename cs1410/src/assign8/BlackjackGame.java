package assign8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackjackGame {

	public static void main(String[] args){
		
		System.out.println("Let's play a game of Blackjack. \n Here are your cards: ");
		
		// Deal two hands.
		Deck d = new Deck();
		d.shuffle();
		BlackjackHand dealerHand = new BlackjackHand();
		BlackjackHand playerHand = new BlackjackHand();
		for(int i = 0; i < 2; i++) {
			dealerHand.addCard(d.deal());
			playerHand.addCard(d.deal());
		}
		
		
		Scanner consoleScanner = new Scanner(System.in);
		int playerChoice = 1;
		boolean tryAgain = true; // set to make sure loop executes at least once
		boolean playerWins = true;
		while(tryAgain) {
			System.out.println("\tYour hand : " + playerHand.toString());
			if (playerHand.value() == 21){
				System.out.println("BLACKJACK!! (automatic STAY)\n");
				break;
			}
			System.out.println("Would you like to hit or stay? ");
			System.out.println("ENTER 1 to HIT and 0 to STAY:");
			try {
				playerChoice = consoleScanner.nextInt();
				System.out.println();
				if(playerChoice != 1 && playerChoice != 0) {
					System.out.println("Your integer is not 1 or 0!!");
					tryAgain = true;
				}
				if(playerChoice == 1){
					System.out.println("You chose to HIT.");
					playerHand.addCard(d.deal());
					//System.out.println("\tYour hand : " + playerHand.toString());
					if (playerHand.value() > 21){
						System.out.println("You went BUST!\n");
						System.out.println("\tYour hand : " + playerHand.toString());
						System.out.println("\tDealer's hand : " + dealerHand.toString() + "\n");
						playerWins = false;
						tryAgain = false;
						break;
					}
				}
				if(playerChoice == 0){
					System.out.println("You chose to STAY.");
					
					System.out.println("\tDealer's hand : " + dealerHand.toString());
					
					while(dealerHand.value() < 17){
						System.out.println("The dealer HITs.");
						dealerHand.addCard(d.deal());
						System.out.println("\tDealer's hand : " + dealerHand.toString());
					}
					
					if(dealerHand.value() > 21){
						System.out.println("The dealer went BUST.\n");
						break;
					}
					
					if(dealerHand.value() == 21){
						System.out.println("Dealer got a BLACKJACK.");
					}
					else{
						System.out.println("The dealer STAYs.\n");
					}
					
					if(dealerHand.value() > playerHand.value()){
						playerWins = false;
					}
					break;
				}
			}
			catch(InputMismatchException e) {
				consoleScanner.next(); // advance past the non-integer token
				System.out.println("You didn't enter an integer!!");
				tryAgain = true; // the user did not input an integer, set to ensure repeat
			}
			
		}
		
		if(playerWins == true)
			System.out.println("-------------( You WIN! )-------------");
		else
			System.out.println("-------------( Dealer wins... )-------------");
		
		consoleScanner.close();
	}
}