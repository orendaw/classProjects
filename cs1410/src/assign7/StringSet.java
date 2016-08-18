package assign7;

/**
 * 
 * This class defines a StringSet object and several useful methods.
 * 
 * A StringSet is a collection of non-null strings, with no duplicates
 * (i.e., no two elements may be equal). 
 * 
 * This class utilizes DynamicArray2 object.
 * 
 * @author Orenda Williams
 *
 */
public class StringSet {
	
    private DynamicArray2 set;
    
    /**
     * Creates an empty StringSet object
     */
    public StringSet() {
    	set = new DynamicArray2();
    }    
    
    /**
     * Throws an IllegalArgumentException if e is null, otherwise adds
     * e to the set if there is not already an element in the set equal to e.
     * 
     * @param e - String to be added assuming it does not already exist
     * within the StringSet
     */
    public void insert(String e) {
    	
    	if (e == null){
    		throw new IllegalArgumentException("String cannot be null");
    	}
    	
    	boolean alreadyExists = false;
    	for(int i = 0; i < set.size(); i++){
    		if(set.get(i).equals(e))
    			alreadyExists = true;    		
    	}
    	
    	if(alreadyExists != true){
    		set.add(e);
    	}
    }  
        
    /**
     *  Throws an IllegalArgumentException if e is null, otherwise
     *  indicates whether the set contains e.
     *  
     * @param e - String to be searched for
     * @return boolean describing if the StringSet object contains String e
     */
    public boolean contains(String e) {
    	
    	if (e == null){
    		throw new IllegalArgumentException("String cannot be null");
    	}
    	
    	boolean result = false;
    	
    	for(int i = 0; i < set.size(); i++){
    		if(set.get(i).equals(e))
    			result = true;
    	}
		
        return result;
    }
    
    /**
     *  Throws an IllegalArgumentException if e is null, otherwise
     *  removes e from the set
     *  
     * @param e - String to be removed from the set
     */
    public void remove(String e) {
    	
    	if (e == null){
    		throw new IllegalArgumentException("String cannot be null");
    	}
    	
    	for(int i = 0; i < set.size(); i++){
    		if(set.get(i).equals(e)){
    			set.remove(i);
    		}
    	}
    }
    
    /**
     *  Returns the number of strings in the set
     * @return int that is the number of Strings in the set
     */
    public int size() {
        return set.size();
    }  
    
     /**
      * Returns a formatted string version of this set
      * Examples: If set contains "a" and "b", this method should 
      * return the string "{a, b}".  If the set is empty, this 
      * method should return the string "{}".
      */
     
    public String toString() {
    	
    	if(set.size() == 0)
    		return "{}";
    	
    	String result = "{";    	
    	for(int i = 0; i < set.size() - 1; i++){
    		result += set.get(i) + ", ";
    	}    	
    	result += set.get(set.size() -1) + "}";
    	
    	return result;
    }
}