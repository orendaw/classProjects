package lec40;

import java.util.Arrays;

/**
 * This class represents a dynamic array of integers (very similar 
 * to DynamicArray2 of Assignment7).
 * 
 * @author Erin Parker, last updated 4/22/16
 */
public class MyArrayList {

	// The integers in this dynamic array are the ones stored
	// in the first "count" positions of "elements".
	private int[] elements;
	private int count;

	/**
	 * Constructs an empty dynamic array.
	 */
	public MyArrayList() {
		this.elements = new int[4];   // see slide #5
		this.count = 0;               // see slide #6
	}

	/**
	 * Provides the number of elements in the dynamic array,
	 * which is not the same as the length of the backing
	 * basic array (elements).
	 * 
	 * @return the size of this dynamic array
	 */
	public int size() {
		return this.count;
	}

	/**
	 * Adds e to the end of the dynamic array. If the capacity 
	 * of the backing basic array is exceeded, extends the array 
	 * by doubling its length.
	 * 
	 * @param e -- the element to be added to this dynamic array
	 */
	public void addLast(int e) {
		if (this.count == this.elements.length) {
			this.elements = Arrays.copyOf(this.elements, this.count * 2);  // see slide #24
		}
		this.elements[this.count] = e;
		this.count++;
	}

	/**
	 * Removes the last element of the dynamic array.
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 *             if this dynamic array is already empty
	 */
	public void removeLast() {
		if (this.count == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		this.count--;
	}

	/**
	 * Returns the element stored at the specified index of this dynamic array.
	 * 
	 * @param index -- the position of the desired element
	 * @throws ArrayIndexOutOfBoundsException
	 *             if 0 <= index < size() is false
	 */
	public int get(int index) {
		if (index < 0 || index >= this.count) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return this.elements[index];
	}

	/**
	 * Changes the element stored at the specified index of this dynamic array
	 * to new value.
	 * 
	 * @param index -- the position of the desired element
	 * @param value -- the new value of the element
	 * @throws ArrayIndexOutOfBoundsException
	 *             if 0 <= index < size() is false
	 */
	public void set(int index, int value) {
		if (index < 0 || index >= this.count) {
			throw new ArrayIndexOutOfBoundsException();
		}
		this.elements[index] = value;
	}

	/**
	 * Generates a user-friendly textual version of the dynamic array.
	 * 
	 * @return a string version of this dynamic array
	 */
	public String toString() {
		String result = "[";
		if (this.count > 0) {
			result += this.elements[0];
		}
		for (int i = 1; i < this.count; i++) {
			result += ", " + this.elements[i];
		}
		return result + "]";
	}
}