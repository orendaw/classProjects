package assign8;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This tester class is to test the modifications made to the Deck class for assignment 8.
 * @author Orenda Williams
 *
 */
public class DeckTester {	

	@Test
	public void testDeckCreate() {
		Deck test = new Deck();
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.TWO));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.THREE));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.FOUR));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.FIVE));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.SIX));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.SEVEN));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.EIGHT));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.NINE));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.TEN));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.JACK));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.QUEEN));
		assertEquals(test.deal(), new PlayingCard(CardSuit.CLUBS, CardValue.KING));
		assertEquals(test.deal(), new PlayingCard(CardSuit.DIAMONDS, CardValue.ACE));
		
	}	

}
