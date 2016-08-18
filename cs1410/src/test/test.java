package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import test.A;

public class test {
	
	public static void main(String[] args){

		
		int x = 5;
		increment(x);
		System.out.println(x);

	}
	
	public static void increment(int i) {
		i = i + 1;
		}

	
	public static char getLabGrade(int labScore) {
		if(labScore < 0 || labScore >10)
		throw new IllegalArgumentException();
		
		switch(labScore){
		case 6:
			return 'D';
		case 7:
			return 'C';
		case 8:
			return 'B';
		case 9:
			return 'A';
		default:	
			return 'E';
		}
	}

	public static void foo(int x) {
	    int result = 0;
	    switch(x) {
	        case 3:
	            result = x + 1;
	        case 4:
	            result = x + x;
	            break;
	        case 6:
	            result = x - 2;
	    }
	    System.out.println(result);
	}
	
	public static int f(int[] a) {
	    int s = 0;
	    for(int i = 1; i < a.length; i = i+2) {
	        s = s + a[i];
	    }
	    return s;
	}
	
public static String wordAfter(Scanner s, String word){
		
		String bestSoFar = word;
		
		while (s.hasNext()){
			String current = s.next();
			if(current.compareTo(word) > 0 ){
				if (current.compareTo(bestSoFar) < 0 || bestSoFar == word){
					bestSoFar = current;
				}
			}
		}
		
		return bestSoFar;
	}
	public static String nextWord( final Scanner scanner, final String word )
    {
        String higher = null, curr;
        while ( scanner.hasNext() )
        {
            curr = scanner.next();
            if ( curr.compareTo( word ) > 0 )
            {
                if ( higher == null || curr.compareTo( higher ) < 0 )
                    higher = curr;
            }
        }
        return higher;
    }

}
