package assign8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Hand {
	
	private ArrayList<PlayingCard> hand;
	
	public Hand() {
		hand = new ArrayList<PlayingCard>();
	}
	
	/**
	 * Adds PlayingCard c from this hand.
	 * @param c - card to be added
	 */
	public void addCard(PlayingCard c) {   
		hand.add(c);
	}
	
	/**
	 * Removes PlayingCard c from this hand. If duplicates of c are contained, it will only
	 * remove one instance of it from this hand.
	 * @param c - card to be removed
	 */
	public void removeCard(PlayingCard c) {
		hand.remove(c);
	}
	
	/**
	 * Removes all PlayingCard objects from this hand.
	 */
	public void removeAllCards() {
		hand.clear();
	}
	
	/**
	 * Returns number of cards in this hand.
	 * @return returns number of cards in this hand
	 */
	public int cardCount() {
		return hand.size();
	}
	
	/**
	 * This method sorts this hand so that it is in ascending order and
	 *  the lowest card is at index 0.
	 */
	public void sort() {
		Collections.sort(hand);
	}
	
	/**
	 * This method returns the PlayingCard object at index i
	 * @param i - index to get PlayingCard from
	 * @return PlayingCard object
	 */
	public PlayingCard getCard(int i) {
		
		if ( i < 0 || i >= hand.size() )
			throw new IndexOutOfBoundsException("Index must be in range.");
		
		return hand.get(i);
	}
	
	/**
	 * This method returns the PlayingCard object in this hand with the largest value.
	 * @return PlayingCard object of highest value
	 */
	public PlayingCard getHighestCard() {
		
		if ( hand.isEmpty() )
			throw new NoSuchElementException("This hand currently contains no cards.");
		
		return Collections.max(hand);
	}
	
	/**
	 * This method returns the PlayingCard object in this hand with the smallest value.
	 * @return PlayingCard object of lowest value
	 */
	public PlayingCard getLowestCard() {
		if ( hand.isEmpty() )
			throw new NoSuchElementException("This hand currently contains no cards.");
		
		return Collections.min(hand);
	}
	
	/**
	 * This method returns a String representing the current hand in the following format:
	 * "4 of clubs, 6 of hearts, king of spades"	
	 * 
	 */
	public String toString() {
		
		String result = "";
		
		for (int i = 0; i < hand.size()-1; i++ )
			result += hand.get(i).toString() + ", ";
		
		return result += hand.get(hand.size()-1).toString();
	}
}
