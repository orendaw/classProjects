package assign7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This tester class tests the StringSet class and its methods.
 * 
 * Some of the tests require that several methods within StringSet are implemented
 * before they work properly. Please check as needed.
 * 
 * @author Orenda Williams
 *
 */

public class StringSetTester {

	StringSet s1;
	StringSet s2;
	StringSet s3;
	
	@Before
	public void setUp() throws Exception {
		s1 = new StringSet();
		s1.insert("hello");
		s1.insert("world");
		s2 = new StringSet();
		for(int i = 0; i < 12; i++){
			s2.insert(Integer.toString(1 + i));
		}		
		s3 = new StringSet();
	}

	@Test
	public void testInsert() {
		s1.insert("hello");
			assertTrue("test failed during s1.insert(\"hello\")", s1.size() == 2);
		
		s2.insert("hello");
			assertTrue("test failed during s2.insert(\"hello\")", s2.contains("hello"));
			assertTrue("test failed during s2.insert(\"hello\")", s2.size() == 13);
		
		try{
			s3.insert(null);
			fail("s3.insert(null) should have thrown an exception and did not.");
		}
		catch(IllegalArgumentException e){
			final String msg = "String cannot be null";
		    assertEquals(msg, e.getMessage());
		}
		
		s3.insert("hello");
			assertTrue("test failed during s3.insert(\"hello\")", s3.size() == 1 && s3.contains("hello"));
		
	}

	@Test
	public void testContains() {
		assertTrue(s1.contains("hello"));
		assertTrue(s1.contains("world"));
		assertFalse(s3.contains(""));
		assertFalse(s1.contains(""));
		assertFalse(s2.contains("0"));
			
	}

	@Test
	public void testRemove() {
		s1.remove("hello");
			assertTrue("test failed during s1.remove(\"hello\")", s1.size() == 1);
			assertFalse("test failed during s1.remove(\"hello\")", s1.contains("hello"));
			assertTrue("test failed during s1.remove(\"hello\")", s1.contains("world"));
			
		s2.remove("0");
			assertTrue("test failed during s2.remove(\"0\")", s2.size() == 12);
			assertFalse("test failed during s2.remove(\"0\")", s1.contains("0"));
			
		s3.remove("hello");
			assertTrue("test failed during s3.remove(\"hello\")", s3.size() == 0);
			assertFalse("test failed during s3.remove(\"hello\")", s3.contains("hello"));
			
		s1.remove("");
			assertTrue("test failed during s1.remove(\"\")", s1.size() == 1);
			assertFalse("test failed during s1.remove(\"\")", s1.contains(""));
			assertTrue("test failed during s1.remove(\"\")", s1.contains("world"));
			
		try{
			s3.remove(null);
			fail("s3.remove(null) should have thrown an exception and did not.");
		}
		catch(IllegalArgumentException e){
			final String msg = "String cannot be null";
			assertEquals(msg, e.getMessage());
		}
		
	}

	@Test
	public void testSize() {
		assertTrue(s1.size() == 2);
		assertTrue(s2.size() == 12);
		s2.remove("1");
		assertTrue(s2.size() == 11);
		assertTrue(s3.size() == 0);
		s3.insert("boom");
		assertTrue(s3.size() == 1);
	}

	@Test
	public void testToString() {
		assertTrue(s1.toString().equals("{hello, world}"));
		assertTrue(s2.toString().equals("{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}"));
		assertTrue(s3.toString().equals("{}"));
		s3.insert("boom");
		assertTrue(s3.toString().equals("{boom}"));
		s3.remove("boom");
		assertTrue(s3.toString().equals("{}"));
		
	}

}
