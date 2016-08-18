package assign8;

/**
 * This class represents the 13 possible card values of a PlayingCard
 * @author Orenda Williams
 *
 */

public enum CardValue {
	
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	
	/**
	 * Returns the value of this card formatted as a String.
	 */
	public String toString() {
		
		if (this == ACE)
			return "ace";
		if (this == TWO)
			return "2";
		if (this == THREE)
			return "3";
		if (this == FOUR)
			return "4";
		if (this == FIVE)
			return "5";
		if (this == SIX)
			return "6";
		if (this == SEVEN)
			return "7";
		if (this == EIGHT)
			return "8";
		if (this == NINE)
			return "9";
		if (this == TEN)
			return "10";
		if (this == JACK)
			return "jack";
		if (this == QUEEN)
			return "queen";
		return "king";
		
	}
}
