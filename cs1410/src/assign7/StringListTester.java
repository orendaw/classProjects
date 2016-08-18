package assign7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This tester is for the StringList class and its methods.
 * 
 * Some tests require that other methods are already implemented, 
 * so be aware of this (methods required: insert(), remove(), contains())
 * 
 * @author Orenda Williams
 *
 */

public class StringListTester {
	
	StringList s1;
	StringList s2;
	StringList s3;
	
	@Before
	public void setUp() throws Exception {
		s1 = new StringList();
		s1.insert("hello", 0);
		s1.insert("world", 1);
		s1.insert("hello", 2);
		s2 = new StringList();
		for(int i = 0; i < 12; i++){
			s2.insert(Integer.toString(1 + i), i);
		}		
		s3 = new StringList();
	}

	@Test
	public void testContains() {
		assertTrue(s1.contains("hello"));
		assertTrue(s1.contains("world"));
		assertFalse(s2.contains("world"));
		assertTrue(s2.contains("12"));
		assertFalse(s3.contains("hello"));
		assertFalse(s3.contains("1"));			
		
		try{
			s1.contains(null);
			fail("s1.contains(null) should have thrown an exception and did not.");
		}
		catch(IllegalArgumentException e){
			final String msg = "String cannot be null";
		    assertEquals(msg, e.getMessage());
		}
	}
	
	@Test
	public void testInsert() {
		s3.insert("hello", 0);
		assertTrue(s3.contains("hello"));
		
		s2.insert("hello", 1);
		assertTrue(s2.contains("hello"));
		
		try{
			s3.insert("hello", 3);
			fail("s3.insert(\"hello\", 3) should have thrown an exception and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
		try{
			s3.insert("world", -1);
			fail("s3.insert(\"world\", -1) should have thrown an exception and did not.");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
				
		try{
			s3.insert(null, 1);
			fail("s3.insert(null, 3) should have thrown an exception and did not.");
		}
		catch(IllegalArgumentException e){
			final String msg = "String cannot be null";
		    assertEquals(msg, e.getMessage());
		}
		
	}

	@Test
	public void testRemove() {
		
		s1.remove("hello");
		assertFalse(s1.contains("hello"));
		
		s1.remove("world");
		assertFalse(s1.contains("world"));
		
		s2.remove("12");
		assertFalse(s2.contains("12"));
		
		s2.remove("hello");
		assertFalse(s2.contains("hello"));
		
		try{
			s1.remove(null);
			fail("s3.insert(\"hello\", 3) should have thrown an exception and did not");
		}
		catch(IllegalArgumentException e){
			final String msg = "String cannot be null";
		    assertEquals(msg, e.getMessage());
		}
	}

	@Test
	public void testSize() {
		assertTrue(s1.size() == 3);
		assertTrue(s2.size() == 12);
		assertTrue(s3.size() == 0);
		
		s2.insert("hello", 0);
		assertTrue(s2.size() == 13);
		
		s3.remove("all");
		assertTrue(s3.size() == 0);
	}

	@Test
	public void testToString() {
		assertTrue(s1.toString().equals("hello, world, hello"));
		assertTrue(s2.toString().equals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12"));
		assertTrue(s3.toString().equals(""));
		
		s2.insert("hello", 4);
		assertTrue(s2.toString().equals("1, 2, 3, 4, hello, 5, 6, 7, 8, 9, 10, 11, 12"));
		
		s3.insert("hey you", 0);
		assertTrue(s3.toString().equals("hey you"));
		
	}

}
