package assign7;

/**
 * 
 * This class defines a StringList object and several methods for it.
 * 
 * A StringList is an ordered collection of non-null strings, 
 * in which the same string may occur more than once.
 * 
 * * This class utilizes DynamicArray2 object.
 * 
 * @author Orenda Williams
 */

// 
public class StringList {
	
	private DynamicArray2 list;
	
	/**
	 * Creates an empty StringList object
	 */
    public StringList() {
    	list = new DynamicArray2();
    }
    
    /**
     * Throws an IllegalArgumentException if e is null, 
     * otherwise adds e to the list at index i.
     * 
     * This will not replace the String at index i, it will
     * shift that element and all other following elements 
     * down by one.
     * 
     * @param e - String to be added
     * @param i - index to add String e at
     */
    public void insert(String e, int i) {
    	if (e == null){
    		throw new IllegalArgumentException("String cannot be null");
    	}
    	
    	list.add(i, e);
    		
    }
    
    /**
     * Throws an IllegalArgumentException if e is null, 
     * otherwise indicates whether the list contains e.
     * 
     * @param e - String to search for
     * @return boolean indicating if the StringList contains the String e
     */
    public boolean contains(String e) {
    	
    	if (e == null){
    		throw new IllegalArgumentException("String cannot be null");
    	}
    	
      	boolean result = false;    	
    	for (int i = 0; i < list.size(); i++){    		
    		if (list.get(i).equals(e))
    			result = true;    		
    	}
        return result;
    }
    
    /**
     * Throws an IllegalArgumentException if e is null, 
     * otherwise removes all occurrences of e from the list.
     * 
     * @param e - String to be removed from StringList object
     */
    public void remove(String e) {
    	if (e == null){
    		throw new IllegalArgumentException("String cannot be null");
    	}
    	
    	for (int i = 0; i < list.size(); i++){
    		if(list.get(i).equals(e)){
    			list.remove(i);
    			i--;
    		}
    	}
    }
    
    /**
     * Returns the number of strings in the list
     * @return an int indicating # of String within the StringList
     */
    public int size() {
        return list.size();
    }  
    
	/**
	 * Returns a formatted string version of this list
     * Examples: If list contains "a" followed by "b" followed by "c", 
     * this method should return the string "a, b, c".  If the list is 
     * empty, this method should return the empty string "".
	 */
    public String toString() {
    	
    	if (list.size() == 0)
    		return "";
    	
    	String result = "";
    	
    	for(int i = 0; i < list.size() - 1; i++)
    		result += list.get(i) + ", ";
    	
    	result += list.get(list.size()-1);
    	
    	return result;
    }
}