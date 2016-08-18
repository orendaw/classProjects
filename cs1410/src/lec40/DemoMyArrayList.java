package lec40;

/** 
 * This program demonstrates usage of MyArrayList objects.
 * 
 * @author Erin Parker, last updated 4/22/16
 */
public class DemoMyArrayList {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		for(int i = 0; i < 5; i++) {
			list.addLast(i);
		}		
		list.set(3, 8);
		list.removeLast();
		
		// Every time we call an instance method an 'implicit parameter' is passed,
		// which is the object before the dot.
		// Example:  list.size() passes the list object to the size method
		// Example:  list.get(3) passes the list object and the integer 3 to the get method	
		
		list.addLast(99);
		list.addLast(100);
		list.addLast(101);
		list.addLast(102);
		list.addLast(103);
		
		// QUESTION 1:  What is printed?
//		MyArrayList list2 = new MyArrayList();
//		list2.addLast(-2);
//		System.out.println(list.size());
		
		// QUESTION 2: What is printed?
//		f(list);
//		System.out.println(list.size());
		
		// QUESTION 3: What is printed?
//		f2(list);
//		System.out.println(list.size());
	}
	
	public static void f(MyArrayList x) {
	     x.addLast(-2);
	  }
	
	public static void f2(MyArrayList x) {
	     x = new MyArrayList();
	     x.addLast(-2);
	  }
}