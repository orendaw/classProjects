package assign7;

/**
 * This is a class that represents a dynamic array (one that can have a changing number
 * of indexes, unlike the default array object). It allows for room to grow or shrink
 * from the user's perspective.
 * 
 * @author Orenda Williams
 *
 */
public class DynamicArray2 {

	private String[] data;   
	private int count;       
	
	/**
	 * Creates an empty dynamic array with room to grow.
	 */
	public DynamicArray2() {
		data = new String[8];
		count = 0;
	}
	
	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return count;
	}
	
	/**
	 * Appends s to the end of the dynamic array
	 * @param s - String to be added to the array.
	 */
	public void add(String s) {
		
		add(count, s);
	}
	
	/**
	 *  Throws an IndexOutOfBoundsException if i is not a valid index
	 *  of the dynamic array (if i is greater than the array
	 *  size or <0), otherwise inserts s at index i.
	 *  
	 *  @param i - the index to insert s at
	 *  @param s - the String to be inserted
	 */
	 
	public void add(int i, String s) {	
		
		if(i < 0 || i > count)
			throw new IndexOutOfBoundsException("Index i is not valid.");
		
		try{
			count ++;
			for(int j = 1; j < (count - i); j++){
				if(count == 1)
					break;				
				data [count - j] = data[count - (j+1)];				
			}			
			data[i] = s;
		}
		catch(IndexOutOfBoundsException e){
			String[] newData = new String[data.length*2];
			for(int j = 0; j < i; j++) {
				newData[j] = data[j];
			}
			newData[i] = s;				
			for(int j = i + 1; j < count; j++) {
				newData[j] = data[j - 1];
			}
			data = newData;			
		}
	}
	
	/**
	 * Throws an IndexOutOfBoundsException if i is not a valid index
	 * of the dynamic array, otherwise removes the element at index i.
	 * 
	 * This will automatically shorten the array by one, it will
	 * not leave an empty string or null object.
	 * 
	 * @param i - index of element to be removed
	 */
	
	public void remove(int i) {	
		
		if(i < 0 || i >= count)
			throw new IndexOutOfBoundsException("Index i is not valid.");		
	
		for(int j = i; j < count; j++){
			data[j] = data[j + 1];
		}
		
		data[count] = null;
		
		count--;
	}
	
	/**
	 *  Throws an IndexOutOfBoundsException if i is not a valid index
	 *  of the dynamic array, otherwise returns the element at index i.
	 * @param i - index to get String from
	 * @return String that is stored at index i
	 */
	
	public String get(int i) {
		
		if(i < 0 || i >= count)
			throw new IndexOutOfBoundsException("Index i is not valid.");
		
		return data[i];
	}
	
	/**
	 *  Throws an IndexOutOfBoundsException if i is not a valid index
	 *  of the dynamic array, otherwise replaces the element at index i 
	 *  with s
	 * @param i - index to replace element at
	 * @param s - String to replace element at index with
	 */
	
	public void set(int i, String s) {
		
		if(i < 0 || i >= count)
			throw new IndexOutOfBoundsException("Index i is not valid.");
		
		data[i] = s;
	}
	
	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if(size() > 0) 
			result += get(0);
		
		for(int i = 1; i < size(); i++) 
			result += ", " + get(i);
		
		return result + "]";
	}
}
