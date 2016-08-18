
package test;

public class testcheck { 
	
	public static int sum(int n){
		if(n==1){
			return 1;
		}
		
		return n + sum(n);
	}
	
	public static void main(String[] args){
		int answer = sum(5);
	}

}
