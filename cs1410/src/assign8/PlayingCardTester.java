package assign8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * This tester class is for the PlayingCard methods that were modified for this assignment.
 * @author Orenda Williams
 *
 */
public class PlayingCardTester {

	PlayingCard p1;
	PlayingCard p2;
	PlayingCard p3;
	PlayingCard p4;
	PlayingCard p5;
	PlayingCard p6;
	
	@Before
	public void setUp(){
		p1 = new PlayingCard(CardSuit.CLUBS, CardValue.KING);
		p2 = new PlayingCard(CardSuit.DIAMONDS, CardValue.QUEEN);
		p3 = new PlayingCard(CardSuit.HEARTS, CardValue.ACE);
		p4 = new PlayingCard(CardSuit.SPADES, CardValue.TWO);
		p5 = new PlayingCard(CardSuit.DIAMONDS, CardValue.KING);
		p6 = new PlayingCard(CardSuit.CLUBS, CardValue.KING);
		
	}

	@Test
	public void testGetValue() {
		assertEquals(p1.getValue(), CardValue.KING);
		assertEquals(p2.getValue(), CardValue.QUEEN);
		assertEquals(p3.getValue(), CardValue.ACE);
		assertEquals(p4.getValue(), CardValue.TWO);
		assertEquals(p1.getValue(), p5.getValue());
	}

	@Test
	public void testToString() {
		assertEquals(p1.toString(), "king of clubs");
		assertEquals(p2.toString(), "queen of diamonds");
		assertEquals(p3.toString(), "ace of hearts");
		assertEquals(p4.toString(), "2 of spades");
	}

	@Test
	public void testEqualsObject() {
		assertFalse(p1.equals(p2));
		assertTrue(p1.equals(p6));
		assertFalse(p2.equals(p3));
		assertFalse(p1.equals(p5));
	}

	@Test
	public void testCompareTo() {
		assertEquals(p1.compareTo(p6), 0);
		assertEquals(p1.compareTo(p2), 1);
		assertEquals(p1.compareTo(p3), 12);
		assertEquals(p1.compareTo(p5), -1);		
	}

}
