package assign8;

import java.util.Random;

public class Deck {

	private PlayingCard[] cards;
	private int nextCardIndex;
	
	public Deck() {
		cards = new PlayingCard[52];
		
		CardSuit[] suits = { CardSuit.CLUBS, CardSuit.DIAMONDS, CardSuit.HEARTS, CardSuit.SPADES };
		CardValue[] values = { CardValue.ACE, CardValue.TWO, CardValue.THREE, CardValue.FOUR,
								CardValue.FIVE, CardValue.SIX, CardValue.SEVEN, CardValue.EIGHT, CardValue.NINE, 
								CardValue.TEN, CardValue.JACK, CardValue.QUEEN, CardValue.KING };
		
		int cardCount = 0;
		for(int i = 0; i < suits.length; i++)
			for(int j = 0; j < 13; j++)
				cards[cardCount++] = new PlayingCard(suits[i], values[j]);
		
		nextCardIndex = 0;
	}

	/**
	 * Deals the next card from the deck.
	 * 
	 * @return the next card
	 */
	public PlayingCard deal() {
		if(nextCardIndex >= cards.length)
			throw new RuntimeException("Out of cards");
		
		PlayingCard result = cards[nextCardIndex];
		nextCardIndex++;
		return result;
	}
	
	/**
	 * Deals the next count cards from the deck.
	 * 
	 * @param count
	 * @return the next count cards
	 */
	public PlayingCard[] deal(int count) {
		if(count < 0)
			throw new RuntimeException("deal count must be non-negative");
		
		PlayingCard[] hand = new PlayingCard[count];
		for(int i = 0; i < count; i++)
			hand[i] = deal();
		return hand;
	}
	
	/** 
	 * Randomly shuffles the deck.
	 */
	public void shuffle() {
		Random rng = new Random();
		for(int i = 0; i < cards.length; i++)
			swap(i, rng.nextInt(cards.length));
		nextCardIndex = 0;
	}
	
	/**
	 * A private helper method that swaps the cards at indexes i and j.
	 * 
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		PlayingCard temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;                 
	}
}
