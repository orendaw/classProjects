package lec35;

/**
 * This class contains sort methods, which implement the selection 
 * sort algorithm, as well as private helper methods that support 
 * the sort.
 * 
 * (This class is a container for methods, not a template for making
 * objects. Notice the lack of instance variables and that all 
 * methods are static.)
 * 
 * @author Erin Parker, last updated 4/15/16
 */
public class SelectionSort {
	
	/**
	 * Swaps items arr[i] and arr[j].
	 * 
	 * @param arr -- the array containing the elements to swap
	 * @param i -- index of first element to be swapped
	 * @param j -- index of second element to be swapped
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	/**
	 * Finds the smallest item in an array.
	 * 
	 * @param arr -- the array
	 * @return the index of the element in arr that is the smallest
	 */
	private static int findMinIndex(int arr[]) {
		int minIndex = 0;
		for (int i = 1; i < arr.length; i++){
			if (arr[i] < arr[minIndex])
				minIndex = i;
		}	
		return minIndex;
	}
	
	/**
	 * Finds the smallest item in an array, beginning the search at a 
	 * starting index.
	 * 
	 * @param arr -- the array
	 * @param startIndex -- the starting index
	 * @return the index of the element in arr that is the smallest
	 */
	private static int findMinIndex(int arr[], int startIndex) {
		int minIndex = startIndex;
		
		for(int i = startIndex + 1; i < arr.length; i++) {
			if(arr[i] < arr[minIndex])
				minIndex = i;
		}
		
		return minIndex;
	}
	
	/**
	 * Orders the integers in an array from smallest to largest,
	 * using the selection sort algorithm.
	 * 
	 * @param arr -- the array
	 */
//	public static void sort(int[] arr) {
//		for(int i = 0; i < arr.length-1; i++) 
//			swap(arr, i, findMinIndex(arr, i));
//	}
	
	/**
	 * Orders the integers in an array from smallest to largest,
	 * using the selection sort algorithm.
	 * 
	 * (This is the typical version, which does not use helper 
	 * methods.)
	 * 
	 * @param arr -- the array
	 */
	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < arr.length; j++)
				if(arr[j] < arr[minIndex])
					minIndex = j;
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	

	/**
	 * Orders the strings in an array from smallest to largest,
	 * using the selection sort algorithm.
	 * 
	 * @param arr -- the array
	 */
	public static void sort(String[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < arr.length; j++)
				if(arr[j].compareTo(arr[minIndex]) < 0)
					minIndex = j;
			String temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	/**
	 * Orders the items in an array from smallest to largest,
	 * using the selection sort algorithm.
	 * 
	 * @param arr -- the array
	 */
	public static <T extends Comparable<? super T>> void sort(T[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < arr.length; j++)
				if(arr[j].compareTo(arr[minIndex]) < 0)
					minIndex = j;
			T temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}	
	}
}