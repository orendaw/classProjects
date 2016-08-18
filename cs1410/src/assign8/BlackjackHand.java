package assign8;


/**
 * Representation of a BlackjackHand of cards
 * @author Orenda Williams
 *
 */
public class BlackjackHand extends Hand {
	

	public BlackjackHand() {
		
	}
	
	/**
	 * This method returns the Blackjack Value of this hand as an int value.
	 * 
	 * It automatically calculates aces as 1 or 11 depending on how they will be ideally used.
	 * 
	 * @return Blackjack value of this hand
	 */
	public int value(){
		
		this.sort();
		
		int result = 0;
		
		for(int i = this.cardCount()-1; i >= 0; i--){
			if(this.getCard(i).getValue().compareTo(CardValue.ACE) == 0){
				if(result <= 10 - i)
					result += 11;
				else
					result += 1;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.TEN) == 0 ||
				this.getCard(i).getValue().compareTo(CardValue.JACK) == 0 ||
				this.getCard(i).getValue().compareTo(CardValue.QUEEN) == 0 ||
				this.getCard(i).getValue().compareTo(CardValue.KING) == 0 ){
				result += 10;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.TWO) == 0){
				result += 2;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.THREE) == 0){
				result += 3;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.FOUR) == 0){
				result += 4;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.FIVE) == 0){
				result += 5;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.SIX) == 0){
				result += 6;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.SEVEN) == 0){
				result += 7;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.EIGHT) == 0){
				result += 8;
			}
			
			if(this.getCard(i).getValue().compareTo(CardValue.NINE) == 0){
				result += 9;
			}		
		}
		
		return result;
	}
	
	/**
	 * Returns this hand and its Blackjack value as a String formatted as the 
	 * following example:
	 * 
	 * "ace of diamonds, jack of hearts has Blackjack value 21"
	 */
	public String toString(){
		
		String result = "";
		for (int i = 0; i < this.cardCount()-1; i++)
			result += this.getCard(i).toString() + ", ";
		
		return result + this.getCard(this.cardCount()-1).toString() + " has Blackjack value " + this.value();
	}
}
