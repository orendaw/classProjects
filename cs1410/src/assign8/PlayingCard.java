package assign8;

/**
 * Represents a playing card (e.g, ace of spades, 2 of clubs, king of hearts).
 * 
 * @author Erin Parker and CS 1410 class
 */
public class PlayingCard implements Comparable<PlayingCard> {
		
	private final CardSuit suit;   
	private final CardValue value;  
		
	public PlayingCard(CardSuit _suit, CardValue _value) {   
		suit = _suit;
		value = _value;
	}
	
	/**
	 * Returns the suit of this playing card.
	 */
	public CardSuit getSuit() {
		return suit;
	}
	
	/**
	 * Returns the value of this playing card.
	 */
	public CardValue getValue() {    
		return value;
	}
	
	/**
	 * Returns a formatted string representation of this card (e.g., "ace of spades, "9 of hearts").
	 * 
	 * @return formatted string
	 */
	public String toString() {		
		return value + " of " + suit;
	}

	
	/** Returns true if the card represented by this object is equal to the
	 * other card.
	 * 
	 * @param other
	 * @return true if this is equal to other
	 */
	public boolean equals(Object other) {
		if(!(other instanceof PlayingCard))
			return false;
		
		PlayingCard rhs = (PlayingCard)other;
		
		return suit == rhs.suit && value == rhs.value;
	}

	/**
	 * The card with the higher value is the higher card. (E.g., 10 of clubs is 
	 * higher than 8 of spades.)
	 * 
	 * If the value of both cards is the same, use the suit to break the tie. 
	 * The ranking of suits from low to high is clubs, diamonds, hearts, spades. 
	 * (E.g., 5 of hearts is higher than 5 of diamonds.)
	 * 
	 * If the value and suit of both cards are the same, the two cards are considered equal.
	 */
	public int compareTo(PlayingCard other) {
		
		if ( value == other.getValue() ){
			return suit.compareTo( other.getSuit() );
		}
		
		return value.compareTo( other.getValue() );
		
	}
}
