package assign5;

import java.util.Arrays;

/**
 * This class develops several methods to perform actions with/to arrays.
 * @author Orenda Williams
 *
 */

public class ArrayLibrary {
	
	public static void main(String[] args){
	}
	
	/**
	 * This method is designed to set the value of the first 
	 * array element to num, the value of the second array 
	 * element to num+1, and so on. This method should work even
	 * if array length is 0.
	 * 
	 * Example: after execution of fill(arr, 17), the contents 
	 * of arr should be 17 18 19 20 21
	 * 
	 * @param array - array to be filled
	 * @param num - value to begin filling with
	 */
	public static void fill(int[] array, int num){
		for(int i = 0; i < array.length; i++){
			array[i] = num + i;
		}
	}
	
	/**
	 * 	This method scales the value of each array element by the int num.
	 * 
	 * Example: after execution of scale(integers, 3), the contents of 
	 * integers should be 6 -27 261 18 0 36 -9
	 * 
	 * @param array - array to have the values scaled
	 * @param num - number to scale by
	 */
	public static void scale(int[] array, int num){
		for(int i = 0; i < array.length; i++){
			array[i] = array[i]*num;
		}
		
	}
	
	/**
	 * This method takes in an int array and returns the contents as a String.
	 * The ints will be separated with a space (' ') and the String will
	 * be bracketed with curly braces ('{' and '}').
	 * 
	 * @param array - array of ints to be converted to a String
	 * @return String containing ints of all the array elements
	 */
	public static String toString(int[] array){
		String result = "{";
		for(int i = 0; i < array.length; i++){
			result += array[i];
			if (!(i == array.length-1)){
				result += " ";
			}
		}
		return result + "}";
	}
	
	/**
	 * This method takes an array of Strings and a String item to look for.
	 * It returns true if the array contains the item and false otherwise.
	 * 
	 * @param array - array of Strings to be searched
	 * @param item - String to search for
	 * @return returns true if the array contains the item
	 */
	public static boolean contains(String[] array, String item){
		boolean result = false;
		for(int i = 0; i < array.length; i++){
			if(array[i].equals(item))
				result = true;
		}
		
		return result;
	}
	
	/**
	 *  the side effect of the method is to reverse the order of 
	 *  the items in the array from index i to index j (inclusive)
	 *  
	 *  Example: after execution of reverse(letters, 3, 5), the 
	 *  contents of letters should be 'a' 'b' 'c' 'f' 'e' 'd' 'g' 'h'
	 *  
	 *  Notes:  method should work even if the array's length is 0. 
	 *   0 <= i <= j < must be true.
	 *  
	 * @param array - array of char to have values reversed between i and j
	 * @param i - lower index of array (where reverse starts)
	 * @param j - higher index of array (where reverse stops)
	 */
	public static void reverse(char[] array, int i, int j){
		for(int k = 0; k<((j-i)/2 + 1); k++){
			char temp = array[i+k];
			array[i+k] = array[j-k];
			array[j-k] = temp;
		}
	}

	/**
	 * This method takes an array of integers and returns the average of
	 * all the values that the array contains.
	 * 
	 * @param array - array of int to be averaged
	 * @return a double that is the average
	 */
	public static double average(int[] array){
		int sum = 0;
		int count = 0;
		
		for(int i = 0; i < array.length; i++){
			sum += array[i];
			count++;
		}
		
		return sum / (double) count;
	}
	
	/**
	 * This method takes an array of int and returns the median
	 * value as a double.
	 * @param array - int values to find the median of
	 * @return double value that is the median of the values within the array
	 */
	public static double median(int[] array){
		double result = 0;
		int[] copy = Arrays.copyOf(array, array.length);
		Arrays.sort(copy);
		if(copy.length % 2 == 0){
			result = (copy[copy.length/2] + copy[(copy.length/2) - 1])/2.0;
		}
		else{
			result = copy[(copy.length/2)];
		}
		return result;
	}
	
	/**
	 * This method takes an array of int and returns the "mode" (most
	 * frequently occurring value within the array).
	 * 
	 * Notes: The length of the array must be at least 1. 
	 * The values of the array elements must also
	 * range from 1 to 9 (inclusive). If multiple values occur 
	 * most frequently, the method returns any one of the them.
	 * 
	 * @param array of int to find mode of
	 * @return int that is the mode of the array
	 */
	public static int mode(int[] array){
		
		int[] holder = new int[10];
		
		for(int i = 0; i < array.length; i++){
			holder[array[i]]++;
		}		
		
		int result = 0;
		
		for(int i = 0; i < holder.length; i++){
			if (holder[result] < holder[i]){
				result = i;
			}
		}
		return result;
	}
	
	/**
	 * This method takes in a 2D array and an int value indicating
	 * a column within that 2D array. The method then copies all
	 * values from within that column to another 1D array 
	 * and returns the new array.
	 * 
	 * NOTE: This method assumes that all of the columns within the 2D
	 * array are of the same length.
	 * 
	 * @param array - 2D array to have one of its columns copied
	 * @param column - the index of the column that is desired to be copied
	 * @return a new 1D array containing the copied column
	 */
	public static int[] columnCopy(int[][] array, int column){
		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++){
			result[i] = array[i][column];
		}
		return result;
	}
	
	/**
	 * This method takes in a 2D array of doubles and returns 
	 * a 1D array that condenses the values of the 2D array into 
	 * a single column row by row.
	 * 
	 * This method assumes that all rows will have the same
	 * number of columns and that there is at least
	 * one row and one column in the array.
	 * 
	 * Example: 
	 * 
	 * 2D array is { { 32.5, 9.88 }, { -7.0, 104.85 }, { 47.91, -2.23 } }
	 * this method will return { 32.5 9.88 -7.0 104.85 47.91 -2.23 }
	 * 
	 * @param array - 2D array to be condensed
	 * @return 1D array containing the values of the 2D array
	 */
	public static double[] linearize(double[][] array){
		double[] result = new double[array.length * array[0].length];
		int count = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++){
				result[count] = array[i][j];
				count++;
			}
		}
		
		return result;
	}
}
