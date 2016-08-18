package assign8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * This tester class is for testing the CardValue enum class that was created for this assignment
 * @author Orenda Williams
 *
 */
public class CardValueTester {
	
	CardValue test1;
	CardValue test2;
	CardValue test3;
	CardValue test4;
	CardValue test5;
	CardValue test6;
	CardValue test7;
	CardValue test8;
	CardValue test9;
	CardValue test10;
	CardValue test11;
	CardValue test12;
	CardValue test13;
	
	@Before
	public void setUp(){
	test1 = CardValue.ACE;
	test2 = CardValue.TWO;
	test3 = CardValue.THREE;
	test4 = CardValue.FOUR;
	test5 = CardValue.FIVE;
	test6 = CardValue.SIX;
	test7 = CardValue.SEVEN;
	test8 = CardValue.EIGHT;
	test9 = CardValue.NINE;
	test10 = CardValue.TEN;
	test11 = CardValue.JACK;
	test12 = CardValue.QUEEN;
	test13 = CardValue.KING;
	}
	
	@Test
	public void testToString() {
		assertEquals(test1.toString(), "ace");
		assertEquals(test2.toString(), "2");
		assertEquals(test3.toString(), "3");
	}
	public void testToString2() {
		assertEquals(test4.toString(), "4");
		assertEquals(test5.toString(), "5");
		assertEquals(test6.toString(), "6");
	}
	public void testToString3() {
		assertEquals(test7.toString(), "7");
		assertEquals(test8.toString(), "8");
		assertEquals(test9.toString(), "9");
	}
	public void testToString4() {
		assertEquals(test10.toString(), "10");
		assertEquals(test11.toString(), "jack");
		assertEquals(test12.toString(), "queen");
		assertEquals(test13.toString(), "king");
	}

}
