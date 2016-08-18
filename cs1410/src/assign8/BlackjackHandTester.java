package assign8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the BlackjackHand class to ensure it works properly.
 * @author Orenda Williams
 *
 */

public class BlackjackHandTester {
	BlackjackHand s1;
	BlackjackHand s2;
	BlackjackHand s3;
	BlackjackHand s4;
	BlackjackHand s5;
	
	@Before
	public void setUp() throws Exception {
		s1 = new BlackjackHand();
		s1.addCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.ACE));
		s1.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.JACK));
		s2 = new BlackjackHand();
		s2.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.TWO));
		s2.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.NINE));
		s2.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.QUEEN));
		s3 = new BlackjackHand();
		s3.addCard(new PlayingCard(CardSuit.SPADES, CardValue.TWO));
		s3.addCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.NINE));
		s3.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		s4 = new BlackjackHand();
		s4.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		s4.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.JACK));
		s4.addCard(new PlayingCard(CardSuit.SPADES, CardValue.ACE));
		s5 = new BlackjackHand();
		s5.addCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.THREE));
		s5.addCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.FIVE));
		s5.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.TEN));
		s5.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.KING));
	}

	@Test
	public void testToString() {
		assertEquals(s1.toString(), "ace of diamonds, jack of hearts has Blackjack value 21");
		assertEquals(s2.toString(), "2 of hearts, 9 of clubs, queen of hearts has Blackjack value 21");
		assertEquals(s3.toString(), "2 of spades, 9 of diamonds, ace of clubs has Blackjack value 12");
		assertEquals(s4.toString(), "ace of clubs, jack of clubs, ace of spades has Blackjack value 12");
		assertEquals(s5.toString(), "3 of diamonds, 5 of diamonds, 10 of hearts, king of hearts has Blackjack value 28");
	}

	@Test
	public void testValue() {
		assertEquals(s1.value(), 21);
		assertEquals(s2.value(), 21);
		assertEquals(s3.value(), 12);
		assertEquals(s4.value(), 12);
		assertEquals(s5.value(), 28);
	}

}
