package lec35;

import java.util.Arrays;

/**
 * This program compares the running time of the selection sort
 * method implemented in class to Java's sort method.
 * 
 * @author Erin Parker, last updated 4/15/16
 */
public class SortTimer {
	
	public static void main(String[] args) {
		
		final int N = 100000;
		
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		
		// Initialize each array such it is in "reverse-sorted" order (i.e., N, N-1, N-2, ..., 1)
		for(int i = 0; i < N; i++) {
			arr1[i] = N - i;
			arr2[i] = N - i;
		}
		
		// Collect the time required to sort N elements using selection sort
		long startTime = System.nanoTime();
		SelectionSort.sort(arr1);
		long endTime = System.nanoTime();
		System.out.println("Selection sort took " + (endTime - startTime) / 1000000000.0 + " sec to sort " + N + " elements.");

		// Collect the time required to sort N elements using Java's sort
		startTime = System.nanoTime();
		Arrays.sort(arr2);
		endTime = System.nanoTime();
		System.out.println("Java's sort took " + (endTime - startTime) / 1000000000.0 + " sec to sort " + N + " elements.");
	}
}