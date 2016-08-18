package lec35;

import java.util.Arrays;

/**
 * This program demonstrates how to sort an array of integers.
 * 
 * @author Erin Parker, last updated 4/15/16
 */
public class SortingDemo {
	
	public static void main(String[] args) {
		int[] arr = { 60, 8, -9, 32, 13, 14, 5, -9, 7, 13, 90, 897, -54, 0, 1, 21, -7, 60 };
		
		// How can we sort this list?
		SelectionSort.sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}