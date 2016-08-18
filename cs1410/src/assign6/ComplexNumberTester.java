package assign6;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 * This JUnit tester is to test the ComplexNumber class and its methods.
 * @author Orenda Williams
 *
 */
public class ComplexNumberTester {

	ComplexNumber c1;
	ComplexNumber c2;
	ComplexNumber c3;
	ComplexNumber c4;
	ComplexNumber c5;
	ComplexNumber c6;
	ComplexNumber c7;
	ComplexNumber n1;
	ComplexNumber n2;
	ComplexNumber n3;
	ComplexNumber n4;
	
	ComplexNumberExtra e1;
	ComplexNumberExtra e2;
	ComplexNumberExtra e3;
	ComplexNumberExtra e4;
	ComplexNumberExtra e5;
	ComplexNumberExtra e6;
	ComplexNumberExtra e7;

	/**
	 * Initialize the member variables in setUp().
	 * They will have the same state for each test.
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new ComplexNumber(2, -4.3);
		c2 = new ComplexNumber(-9.17);
		c3 = new ComplexNumber(2.0, -4.3);
		c4 = new ComplexNumber(-12.4, 9.33);
		c5 = new ComplexNumber(-10.87, 1);
		c6 = new ComplexNumber(8, 4);
		c7  = new ComplexNumber(1, -1);
		n1 = new ComplexNumber(1);
		n2 = new ComplexNumber(0);
		n3 = new ComplexNumber(-5);
		n4 = new ComplexNumber(0, -5);
		
		e1 = new ComplexNumberExtra(1.0, 3.5);
		e2 = new ComplexNumberExtra(2.555555, 0);
		e3 = new ComplexNumberExtra(0, 4.532356);
		e4 = new ComplexNumberExtra(7.2);
		e5 = new ComplexNumberExtra(5.);
		e6 = new ComplexNumberExtra(0, 4.);
		e7 = new ComplexNumberExtra(5, -5);
		
	}

	@Test
	public void getRealPartTest1() {
		assertEquals(2.0, c1.getRealPart(), .00001);
		assertEquals(-10.87, c5.getRealPart(), .00001);
		assertEquals(1.0, c7.getRealPart(), .00001);
		assertEquals(0, n4.getRealPart(), .00001);
	}
	
	@Test 
	public void getRealPartTest2(){
		assertEquals(1, n1.getRealPart(), .01);
		assertEquals(0, n2.getRealPart(), .01);
		assertEquals(-5, n3.getRealPart(), .01);
		
	}

	@Test
	public void getImaginaryPartTest1(){
		assertEquals(-4.3, c1.getImaginaryPart(), .00001);
		assertEquals(-5, n4.getImaginaryPart(), .00001);
		assertEquals(-1, c7.getImaginaryPart(), .00001);
		assertEquals(0, c2.getImaginaryPart(), .00001);
	}
	
	@Test
	public void getImaginaryPartTest2(){
		assertEquals(0, n1.getImaginaryPart(), .01);
		assertEquals(0, n2.getImaginaryPart(), .01);
		assertEquals(0, n3.getImaginaryPart(), .01);
	}

	@Test
	public void isARealNumberTest1() {
		assertTrue(c2.isARealNumber());
		assertTrue(n2.isARealNumber());
		assertTrue(n1.isARealNumber());
		assertFalse(n4.isARealNumber());
		
	}

	@Test
	public void isAnImaginaryNumberTest1() {
		assertFalse(c2.isAnImaginaryNumber());
		assertTrue(n2.isAnImaginaryNumber());
		assertFalse(n1.isAnImaginaryNumber());
		assertTrue(n4.isAnImaginaryNumber());
	}

	@Test
	public void toStringTest1() {
		assertEquals("2.0 - 4.3i", c1.toString());
		assertEquals("1.0 - 1.0i", c7.toString());
		assertEquals("1.0 + 0.0i", n1.toString());
		assertEquals("-5.0 + 0.0i", n3.toString());
	}

	@Test
	public void toStringTest2() {
		assertEquals("-9.17 + 0.0i", c2.toString());
		assertEquals("0.0 + 0.0i", n2.toString());
		assertEquals("0.0 - 5.0i", n4.toString());
		assertEquals("-12.4 + 9.33i", c4.toString());
	}
	 
	@Test
	public void equalsTest1() {
		assertTrue(c1.equals(c3));
		assertFalse(n3.equals(n4));
		assertFalse(c7.equals(n1));
		assertTrue(n2.equals(new ComplexNumber(0, 0)));
	}

	@Test
	public void equalsTest2() {
		assertFalse(c2.equals(c3));
		assertFalse(n2.equals(new ComplexNumberExtra(0,0)));
		assertFalse(n2.equals(n4));
		assertFalse(c6.equals(n2));
	}
	 
	@Test
	public void conjugateTest1() {
		ComplexNumber c1Conjugate = c1.conjugate();
		assertTrue(c1Conjugate.equals(new ComplexNumber(2, 4.3)));
		assertTrue("During conjugation of ComplexNumber(2, -4.3), the original complex number was modified", c1.equals(c3));
		
		ComplexNumber c7Conjugate = c7.conjugate();
		assertTrue(c7Conjugate.equals(new ComplexNumber(1, 1)));
		
		ComplexNumber n1Conjugate = n1.conjugate();
		assertTrue(n1Conjugate.equals(new ComplexNumber(1, 0)));
		
		ComplexNumber n4Conjugate = n4.conjugate();
		assertTrue(n4Conjugate.equals(new ComplexNumber(0, 5)));
	}

	@Test
	public void addTest1() {
		ComplexNumber c1Addc4 = c1.add(c4);
		assertTrue(c1Addc4.equals(new ComplexNumber(-10.4, 5.03)));
		assertTrue("During ComplexNumber(2, -4.3) + ComplexNumber(-12.4, 9.33), one or both of the original complex numbers was modified", c1.equals(c3));
		assertTrue("During ComplexNumber(2, -4.3) + ComplexNumber(-12.4, 9.33), one or both of the original complex numbers was modified", c4.equals(new ComplexNumber(-12.4, 9.33)));
		
		ComplexNumber n1Addn2 = n1.add(n2);
		assertTrue(n1Addn2.equals(new ComplexNumber(1, 0)));
		
		ComplexNumber n3Addn4 = n3.add(n4);
		assertTrue(n3Addn4.equals(new ComplexNumber(-5, -5)));
		
		ComplexNumber c1Addc7 = c1.add(c7);
		assertTrue(c1Addc7.equals(new ComplexNumber(3, -5.3)));
	}

	@Test
	public void subtractTest1() {
		ComplexNumber c1Subtractc5 = c1.subtract(c5);
		assertTrue(c1Subtractc5.equals(new ComplexNumber(12.87, -5.3)));
		assertTrue("During ComplexNumber(2, -4.3) - ComplexNumber(-10.87, 1), one or both of the original complex numbers was modified", c1.equals(c3));
		assertTrue("During ComplexNumber(2, -4.3) - ComplexNumber(-10.87, 1), one or both of the original complex numbers was modified", c5.equals(new ComplexNumber(-10.87, 1)));
		
		ComplexNumber c6Subtractc7 = c6.subtract(c7);
		assertTrue(c6Subtractc7.equals(new ComplexNumber(7, 5)));
		
		ComplexNumber n1Subtractn4 = n1.subtract(n4);
		assertTrue(n1Subtractn4.equals(new ComplexNumber(1, 5)));
		
		ComplexNumber c7Subtractn1 = c7.subtract(n1);
		assertTrue(c7Subtractn1.equals(new ComplexNumber(0, -1)));
	}
	
	@Test
	public void multiplyTest1() {
		ComplexNumber c1Multiplyc2 = c1.multiply(c2);
		assertTrue(c1Multiplyc2.equals(new ComplexNumber(-18.34, 39.431)));
		assertTrue("During ComplexNumber(2, -4.3) * ComplexNumber(-9.17), one or both of the original complex numbers was modified", c1.equals(c3));
		assertTrue("During ComplexNumber(2, -4.3) * ComplexNumber(-9.17), one or both of the original complex numbers was modified.", c2.equals(new ComplexNumber(-9.17)));
		
		ComplexNumber c1Multiplyn2 = c1.multiply(n2);
		assertTrue(c1Multiplyn2.equals(new ComplexNumber(0, 0)));
		
		ComplexNumber c1Multiplyn1 = c1.multiply(n1);
		assertTrue(c1Multiplyn1.equals(new ComplexNumber(2, -4.3)));
		
		ComplexNumber c1Multiplyn4 = c1.multiply(n4);
		assertTrue(c1Multiplyn4.equals(new ComplexNumber(-4.3*5, 10)));

	}
	 
	@Test
	public void divideTest1() {
		ComplexNumber c6Dividec7 = c6.divide(c7);
		assertTrue(c6Dividec7.equals(new ComplexNumber(2, 6)));
		assertTrue("During ComplexNumber(8, 4) / ComplexNumber(1, -1), one or both of the original complex numbers was modified.", c6.equals(new ComplexNumber(8, 4)));
		assertTrue("During ComplexNumber(8, 4) / ComplexNumber(1, -1), one or both of the original complex numbers was modified.", c7.equals(new ComplexNumber(1, -1)));
		
		ComplexNumber c6Dividen1 = c6.divide(n1);
		assertTrue(c6Dividen1.equals(new ComplexNumber(8, 4)));
		
		ComplexNumber n2Dividec7 = n2.divide(c7);
		assertTrue(n2Dividec7.equals(new ComplexNumber(0, 0)));
		
		
		try {
			c6.divide(n2);
			fail("Should have thrown Exception but did not!");
		} catch (RuntimeException e){
		    final String msg = "The real and imaginary part of the other ComplexNumber cannot both be zero.";
		    assertEquals(msg, e.getMessage());
		}
	}
	 
	@Test
	public void toStringExtraTest() {
		
		assertEquals("1 + 3.5i", e1.toString());
		assertEquals("2.5556", e2.toString());
		assertEquals("4.5324i", e3.toString());
		assertEquals("7.2", e4.toString());
		assertEquals("5", e5.toString());
		assertEquals("4i", e6.toString());
		assertEquals("5 - 5i", e7.toString());
		
	}

}
