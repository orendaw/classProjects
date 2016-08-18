package assign8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HandTester {
	
	Hand s1;
	Hand s2;
	Hand s3;
	Hand s4;
	Hand s5;
	
	@Before
	public void setUp() throws Exception {
		s1 = new Hand();
		s1.addCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.ACE));
		s1.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.JACK));
		s2 = new Hand();
		s2.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.TWO));
		s2.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.NINE));
		s2.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.QUEEN));
		s3 = new Hand();
		s3.addCard(new PlayingCard(CardSuit.SPADES, CardValue.TWO));
		s3.addCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.NINE));
		s3.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		s4 = new Hand();
		s4.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		s4.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.JACK));
		s4.addCard(new PlayingCard(CardSuit.SPADES, CardValue.ACE));
		s5 = new Hand();
		s5.addCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.THREE));
		s5.addCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.FIVE));
		s5.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.TEN));
		s5.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.KING));
		s5.addCard(new PlayingCard(CardSuit.HEARTS, CardValue.KING));
	}

	@Test
	public void testAddCard() {
		s1.addCard(new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		assertEquals(s1.cardCount(), 3);
	}

	@Test
	public void testRemoveCard() {
		s1.removeCard(new PlayingCard(CardSuit.DIAMONDS, CardValue.ACE));
		assertEquals(s1.cardCount(), 1);
		s1.removeCard(new PlayingCard(CardSuit.HEARTS, CardValue.JACK));
		assertEquals(s1.cardCount(), 0);
		s1.removeCard(new PlayingCard(CardSuit.HEARTS, CardValue.KING));
		assertEquals(s1.cardCount(), 0);
		s5.removeCard(new PlayingCard(CardSuit.HEARTS, CardValue.KING));
		assertEquals(s5.cardCount(), 4);
	}

	@Test
	public void testRemoveAllCards() {
		s1.removeAllCards();
		assertEquals(s1.cardCount(), 0);
		s1.removeAllCards();
		assertEquals(s1.cardCount(), 0);
		s5.removeAllCards();
		assertEquals(s5.cardCount(), 0);
	}

	@Test
	public void testCardCount() {
		assertEquals(s1.cardCount(), 2);
		assertEquals(s2.cardCount(), 3);
		assertEquals(s3.cardCount(), 3);
		assertEquals(s4.cardCount(), 3);
		assertEquals(s5.cardCount(), 5);
	}

	@Test
	public void testSort() {
		s1.sort();
		assertEquals(s1.getCard(0), new PlayingCard(CardSuit.DIAMONDS, CardValue.ACE));
		assertEquals(s1.getCard(1), new PlayingCard(CardSuit.HEARTS, CardValue.JACK));
		s2.sort();
		assertEquals(s2.getCard(0), new PlayingCard(CardSuit.HEARTS, CardValue.TWO));
		assertEquals(s2.getCard(1), new PlayingCard(CardSuit.CLUBS, CardValue.NINE));
		assertEquals(s2.getCard(2), new PlayingCard(CardSuit.HEARTS, CardValue.QUEEN));
		s3.sort();
		assertEquals(s3.getCard(0), new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		assertEquals(s3.getCard(2), new PlayingCard(CardSuit.DIAMONDS, CardValue.NINE));
		s4.sort();
		assertEquals(s4.getCard(0), new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
	}

	@Test
	public void testGetCard() {
		assertEquals(s1.getCard(0), new PlayingCard(CardSuit.DIAMONDS, CardValue.ACE));
		try{
			s2.getCard(-1);
			fail("s2.getCard(-1) should have thrown an exception and did not.");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index must be in range.";
		    assertEquals(msg, e.getMessage());
		}
		try{
			s5.getCard(s5.cardCount());
			fail("s5.getCard(s5.cardCount()) should have thrown an exception and did not.");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index must be in range.";
		    assertEquals(msg, e.getMessage());
		}
	}

	@Test
	public void testGetHighestCard() {
		assertEquals(s1.getHighestCard(), new PlayingCard(CardSuit.HEARTS, CardValue.JACK));
		assertEquals(s2.getHighestCard(), new PlayingCard(CardSuit.HEARTS, CardValue.QUEEN));
		assertEquals(s3.getHighestCard(), new PlayingCard(CardSuit.DIAMONDS, CardValue.NINE));
		assertEquals(s4.getHighestCard(), new PlayingCard(CardSuit.CLUBS, CardValue.JACK));
		assertEquals(s5.getHighestCard(), new PlayingCard(CardSuit.HEARTS, CardValue.KING));
	}

	@Test
	public void testGetLowestCard() {
		assertEquals(s1.getLowestCard(), new PlayingCard(CardSuit.DIAMONDS, CardValue.ACE));
		assertEquals(s2.getLowestCard(), new PlayingCard(CardSuit.HEARTS, CardValue.TWO));
		assertEquals(s3.getLowestCard(), new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		assertEquals(s4.getLowestCard(), new PlayingCard(CardSuit.CLUBS, CardValue.ACE));
		assertEquals(s5.getLowestCard(), new PlayingCard(CardSuit.DIAMONDS, CardValue.THREE));
	}

	@Test
	public void testToString() {
		assertEquals(s1.toString(), "ace of diamonds, jack of hearts");
		assertEquals(s2.toString(), "2 of hearts, 9 of clubs, queen of hearts");
		assertEquals(s5.toString(), "3 of diamonds, 5 of diamonds, 10 of hearts, king of hearts, king of hearts");
	}

}
