package assign5;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import assign5.ArrayLibrary;

/**
 * These JUnit tests examine the methods in the ArrayLibrary and ArrayLibraryExtra classes
 * to ensure they are working correctly. 
 * @author Orenda Williams
 *
 */

public class ArrayLibraryTester {
	
	int[] arr = new int[5];
	int[] integers = { 2, -9, 87, 6, 0, 12, -3 };
	int[] lost = { 4, 8, 15, 16, 23, 42 };
	String[] words = { "the", "quick", "brown", "fox" };
	char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
	int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
	int[] duplicates = { 4, 2, 3, 5, 4, 4, 3, 2, 9, 1, 3, 4, 5, 2, 1, 5 };
	int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
	double[][] numbers = { { 32.5, 9.88 }, { -7.0, 104.85 }, { 47.91, -2.23 } };
	int[] vector = { 0, -6, 10, -3 };

	@Test
	public void testAverage() {
		assertTrue(ArrayLibrary.average(primes) >= 21.8 && ArrayLibrary.average(primes) <= 21.9 );
		assertTrue(ArrayLibrary.average( new int[] {1} ) == 1 );
		assertTrue(ArrayLibrary.average( new int[] {1, 0, 0} ) >= .3 && ArrayLibrary.average(new int[] {1, 0, 0} ) <= .35 );
		assertTrue(ArrayLibrary.average( new int[] {-1, 0, 0} ) <= -.3 && ArrayLibrary.average(new int[] {-1, 0, 0} ) >= -.35 );
		assertTrue(ArrayLibrary.average(new int[] {0} ) == 0 );
	}
	
	@Test
	public void testColumnCopy() {
		assertTrue(Arrays.equals(ArrayLibrary.columnCopy(matrix, 1), new int[] {2, 6, 10}));
		assertTrue(Arrays.equals(ArrayLibrary.columnCopy(matrix, 0), new int[] {1, 5, 9}));
		assertTrue(Arrays.equals(ArrayLibrary.columnCopy(matrix, 2), new int[] {3, 7, 11}));
		assertTrue(Arrays.equals(ArrayLibrary.columnCopy(matrix, 3), new int[] {4, 8, 12}));
		int[][] colCopyTester = {
				{1, 2, 3},
				{1, 2, 4}
		};
		assertTrue(Arrays.equals(ArrayLibrary.columnCopy(colCopyTester, 2), new int[] {3, 4}));
	}
	
	@Test
	public void testContains() {
		assertTrue(ArrayLibrary.contains(words, "quick"));
		assertFalse(ArrayLibrary.contains(words, "FOX"));
		assertFalse(ArrayLibrary.contains(words, ""));
		assertFalse(ArrayLibrary.contains(words, " "));
		String[] containsTest = {" ", "a"};
		assertTrue(ArrayLibrary.contains(containsTest, " "));
	}
	
	@Test
	public void testFill() {
		int[] fillTest = new int[6];
		ArrayLibrary.fill(fillTest, 0);
		assertTrue(Arrays.equals(new int[] {0, 1, 2, 3, 4, 5}, fillTest));
		ArrayLibrary.fill(fillTest, 99);
		assertTrue(Arrays.equals(new int[] {99, 100, 101, 102, 103, 104}, fillTest));
		int[] fillTest2 = new int[0];
		ArrayLibrary.fill(fillTest2, 7);
		assertTrue(Arrays.equals(new int[] {}, fillTest2));
		ArrayLibrary.fill(arr, 17);
		assertTrue(Arrays.equals(new int[] {17, 18, 19, 20, 21}, arr));
		ArrayLibrary.fill(fillTest, -5);
		assertTrue(Arrays.equals(new int[] {-5, -4, -3, -2, -1, 0}, fillTest));
	}
	
	@Test
	public void testLinearize() {
		assertTrue(Arrays.equals(ArrayLibrary.linearize(numbers), new double[] {32.5, 9.88, -7.0, 104.85, 47.91, -2.23}));
		double[][] linearizeTester = { {1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}};
		assertTrue(Arrays.equals(ArrayLibrary.linearize(linearizeTester), new double[] {1, 1., 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}));
		double[][] linearizeTester2 = { {9.}};
		assertTrue(Arrays.equals(ArrayLibrary.linearize(linearizeTester2), new double[] {9.}));
		double[][] linearizeTester3 = {{-1}, {-2}, {-3}};
		assertTrue(Arrays.equals(ArrayLibrary.linearize(linearizeTester3), new double[] {-1, -2, -3}));
		double[][] linearizeTester4 = { {.5, .8, 0, 0}, {-5, -8, 1, 1}, {.5, .8, 1, 1}};
		assertTrue(Arrays.equals(ArrayLibrary.linearize(linearizeTester4), new double[] {.5, .8, 0, 0, -5, -8, 1, 1, .5, .8, 1, 1}));
	} 
	
	@Test
	public void testMedian() {
		assertTrue(ArrayLibrary.median(primes) == 19.0);
		assertTrue(ArrayLibrary.median(duplicates)== 3.5);
		int[] medianTester = {1, 0, 0, 0, 0};
		assertTrue(ArrayLibrary.median(medianTester) == 0);
		int[] medianTester2 = {1, 1, 1, 0, 0};
		assertTrue(ArrayLibrary.median(medianTester2) == 1);
		int[] medianTester3 = {1, 1, 1, 0, 0, 0};
		assertTrue(ArrayLibrary.median(medianTester3) == .5);
	}
	
	@Test
	public void testMode() {
		assertTrue(ArrayLibrary.mode(duplicates) ==  4);
		int[] modeTester = {2, 4, 4, 5, 5};
		assertTrue(ArrayLibrary.mode(modeTester) == 4 || ArrayLibrary.mode(modeTester) == 5);
		int[] modeTester2 = {4};
		assertTrue(ArrayLibrary.mode(modeTester2) == 4);
		int[] modeTester3 = {1, 1, 1, 1, 9, 9, 9, 9, 9};
		assertTrue(ArrayLibrary.mode(modeTester3) == 9);
		int[] modeTester4 = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
		assertTrue(ArrayLibrary.mode(modeTester4) == 2);
	}
	
	@Test
	public void testReverse() {
		char[] reverseTest = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		ArrayLibrary.reverse(reverseTest, 0, 0);
		assertTrue(Arrays.equals(new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'}, reverseTest));
		ArrayLibrary.reverse(reverseTest, 0, reverseTest.length-1);
		assertArrayEquals(new char[] {'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'}, reverseTest);
		ArrayLibrary.reverse(reverseTest, 1, reverseTest.length-2);
		assertTrue(Arrays.equals(new char[] {'h', 'b', 'c', 'd', 'e', 'f', 'g', 'a'}, reverseTest));
		ArrayLibrary.reverse(reverseTest, 1, 2);
		assertTrue(Arrays.equals(new char[] {'h', 'c', 'b', 'd', 'e', 'f', 'g', 'a'}, reverseTest));
		ArrayLibrary.reverse(reverseTest, 5, 6);
		assertTrue(Arrays.equals(new char[] {'h', 'c', 'b', 'd', 'e', 'g', 'f', 'a'}, reverseTest));
	}
	
	@Test
	public void testScale() {
		ArrayLibrary.scale(integers, 3);
		assertTrue(Arrays.equals(new int[] {6, -27, 261, 18, 0, 36, -9}, integers));
		ArrayLibrary.scale(integers, 0);
		assertTrue(Arrays.equals(new int[] {0, 0, 0, 0, 0, 0, 0}, integers));
		int[] emptyArray = new int[0];
		ArrayLibrary.scale(emptyArray, 4);
		assertTrue(Arrays.equals(new int[] {}, emptyArray));
		int[] scaleTest2 = {-1, 0, 1};
		ArrayLibrary.scale(scaleTest2, 5);
		assertTrue(Arrays.equals(new int[] {-5, 0, 5}, scaleTest2));
		ArrayLibrary.scale(scaleTest2, 1);
		assertTrue(Arrays.equals(new int[] {-5, 0, 5}, scaleTest2));
	}
	
	@Test
	public void testToString() {
		int[] emptyArray = new int[0];
		int[] zeroArray = {0, 0, 0, 0, 0, 0, 0};
		assertTrue(ArrayLibrary.toString(lost).equals("{4 8 15 16 23 42}"));
		assertTrue(ArrayLibrary.toString(emptyArray).equals("{}"));
		assertTrue(ArrayLibrary.toString(zeroArray).equals("{0 0 0 0 0 0 0}"));
		assertTrue(ArrayLibrary.toString(vector).equals("{0 -6 10 -3}"));
		int[] toStringTest = {-1};
		assertTrue(ArrayLibrary.toString(toStringTest).equals("{-1}"));
	}
	
	@Test 
	public void testMatrixVectorMultiply() {
		assertTrue(Arrays.equals(ArrayLibraryExtra.matrixVectorMultiply(matrix, vector), new int[] {6, 10, 14}));
		
		int[] vector1 = {1, 1, 1, 1, 1};
		try {
			ArrayLibraryExtra.matrixVectorMultiply(matrix, vector1);
			fail("Should have thrown Exception but did not!");
		} catch (RuntimeException e){
		    final String msg = "The number of columns in the matrix must be the same as the length of the vector.";
		    assertEquals(msg, e.getMessage());
		}
		
		int[] vector2 = {0, 0, 0, 0};
		assertTrue(Arrays.equals(ArrayLibraryExtra.matrixVectorMultiply(matrix, vector2), new int[] {0, 0, 0}));
		
		int[] vector3 = {1, 1, 1};
		try {
			ArrayLibraryExtra.matrixVectorMultiply(matrix, vector3);
			fail("Should have thrown Exception but did not!");
		} catch (RuntimeException e){
		    final String msg = "The number of columns in the matrix must be the same as the length of the vector.";
		    assertEquals(msg, e.getMessage());
		}
		
		int[] vector4 = {-1, 0, 0, 0};
		assertTrue(Arrays.equals(ArrayLibraryExtra.matrixVectorMultiply(matrix, vector4), new int[] {-1, -5, -9}));
	}
}
