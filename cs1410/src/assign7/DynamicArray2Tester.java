package assign7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a group of test cases for each method for the DynamicArray2 object class. 
 * Many of the tests require that some methods within the class are implemented (such
 * as get(), set(), add()). 
 * 
 * @author Orenda
 *
 */

public class DynamicArray2Tester {
	
	DynamicArray2 arr1;
	DynamicArray2 arr2;
	DynamicArray2 arr3;
	
	/**
	 * Initialize the member variables in setUp().
	 * They will have the same state for each test.
	 */
	@Before
	public void setUp() throws Exception {
	
		arr1 = new DynamicArray2();
		arr2 = new DynamicArray2();
		for(int i = 0; i < 12; i++){
			arr2.add("1");
		}
		arr3 = new DynamicArray2();
		for(int i = 0; i < 12; i++) {
			arr3.add("" + (char)('A' + i));
		}
		
	}

	@Test
	public void testGet() {
		try{
			arr3.get(13);
			fail("arr3.get(13) should have thrown an IndexOutOfBoundsException and did not.");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
		try{
			arr3.get(-1);
			fail("arr3.get(-1) should have thrown an IndexOutOfBoundsException and did not.");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
	}
	
	@Test
	public void testGet2() {
		
		try{
			arr1.get(0);
			fail("arr1.get(0) should have thrown an IndexOutOfBoundsException and did not.");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
		arr1.add("test");
		assertTrue(arr1.get(0).equals("test"));
		
	}

	@Test
	public void testSet() {
		
		arr2.set(3, "3");
		assertTrue(arr2.get(3).equals("3"));
		
		arr3.set(0, "a");
		assertTrue(arr3.get(0).equals("a"));
		
		arr3.set(arr3.size()-1, "l");
		assertTrue(arr3.get(arr3.size()-1).equals("l"));
	}
	
	@Test
	public void testSet2(){
		
		try{
			arr2.set(arr2.size(), "3");
			fail("arr2.set(arr.size(), \"3\") should have thrown an IndexOutOfBoundsException and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
		try{
			arr2.set(-1, "3");
			fail("arr2.set(-1, \"3\") should have thrown an IndexOutOfBoundsException and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
		try{
			arr1.set(0, "3");
			fail("arr1.set(0, \"3\") should have thrown an IndexOutOfBoundsException and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
	}
	
	@Test
	public void testSize() {
		assertTrue(arr1.size() == 0);
		assertTrue(arr3.size() == 12);
		assertTrue(arr2.size() == 12);
	}

	@Test
	public void testSize2(){
		
		for(int i = 0; i < 20; i++){
			arr1.add("1" + i);
		}
		assertTrue(arr1.size() == 20);
		
		arr1.remove(arr1.size()-1);
		assertTrue(arr1.size() == 19);
		
		arr2.add("1");
		assertTrue(arr2.size() == 13);
		
		arr2.remove(0);
		assertTrue(arr2.size() == 12);
	}
	
	@Test
	public void testAddString() {
		for(int i = 0; i < arr3.size(); i++){
			assertTrue(arr3.get(i).equals("" + (char)('A' + i)));
		}
		
		arr1.add("test"); 
		assertTrue(arr1.get(0).equals("test"));
		
		arr1.add("test2");
		assertTrue(arr1.get(1).equals("test2"));
		
		arr3.add("M");
		assertTrue(arr3.get(arr3.size()-1).equals("M"));
		
		for(int i = 0; i < 6; i++){
			arr2.add("2");
		}
		
		assertTrue(arr2.get(arr2.size()-1).equals("2"));
		assertTrue(arr2.get(arr2.size()-2).equals("2"));
	}

	@Test
	public void testAddIntString() {
		arr2.add(4, "2");
			assertTrue("failed during arr2.add(4, \"2\")", arr2.get(4).equals("2"));
			assertTrue("failed during arr2.add(4, \"2\")", arr2.size() == 13);
			
		arr3.add(0, "a");
			assertTrue("failed during arr3.add(0, \"a\")", arr3.get(0).equals("a"));
			assertTrue("failed during arr3.add(0, \"a\")", arr3.get(1).equals("A"));
			assertTrue("failed during arr3.add(0, \"a\")", arr3.size() == 13);
			assertTrue("failed during arr3.add(0, \"a\")", arr3.get(12).equals("L"));
		
		arr3.add(1, "b");
			assertTrue("failed during arr3.add(1, \"b\")", arr3.get(0).equals("a"));
			assertTrue("failed during arr3.add(1, \"b\")", arr3.get(1).equals("b"));
			assertTrue("failed during arr3.add(1, \"b\")", arr3.get(2).equals("A"));
			assertTrue("failed during arr3.add(1, \"b\")", arr3.size() == 14);
			assertTrue("failed during arr3.add(1, \"b\")", arr3.get(13).equals("L"));
	}
	
	@Test
	public void testAddIntString2() {
		try{
			arr1.add(-1, "3");
			fail("arr1.add(-1, \"3\") should have thrown an IndexOutOfBoundsException and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
		try{
			arr3.add(13, "3");
			fail("arr3.add(13, \"3\") should have thrown an IndexOutOfBoundsException and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
	}	

	@Test
	public void testRemove() {
		arr3.remove(0);
			assertTrue("failed during arr3.remove(0)", arr3.get(0).equals("B"));
			assertTrue("failed during arr3.remove(0)", arr3.size() == 11);
			assertTrue("failed during arr3.remove(0)", arr3.get(arr3.size() - 1).equals("L"));
		
		arr3.remove(arr3.size() - 1);
			assertTrue("failed during arr3.remove(0)", arr3.get(0).equals("B"));
			assertTrue("failed during arr3.remove(0)", arr3.size() == 10);
			assertTrue("failed during arr3.remove(0)", arr3.get(arr3.size() - 1).equals("K"));
			
	}
	
	@Test
	public void testRemove2() {
		try{
			arr1.remove(0);
			fail("arr1.remove(0) should have thrown an IndexOutOfBoundsException and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
		try{
			arr3.remove(arr3.size());
			fail("arr3.remove(arr3.size()) should have thrown an IndexOutOfBoundsException and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
		
		try{
			arr3.remove(-1);
			fail("arr3.remove(-1) should have thrown an IndexOutOfBoundsException and did not");
		}
		catch(IndexOutOfBoundsException e){
			final String msg = "Index i is not valid.";
		    assertEquals(msg, e.getMessage());
		}
	}

	@Test
	public void testToString() {
		assertTrue(arr1.toString().equals("[]"));
		arr1.add("3");
		assertTrue(arr1.toString().equals("[3]"));
		assertTrue(arr3.toString().equals("[A, B, C, D, E, F, G, H, I, J, K, L]"));
		assertTrue(arr2.toString().equals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]"));
		arr2.set(4, "hello");
		assertTrue(arr2.toString().equals("[1, 1, 1, 1, hello, 1, 1, 1, 1, 1, 1, 1]"));
		
	}

}
