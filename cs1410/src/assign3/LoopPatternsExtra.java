package assign3;


public class LoopPatternsExtra {
	
	public static void main(String[] args){
		if(removeLetters("Mississippi River", "is").compareTo("Mpp Rver") != 0)
			System.out.println("TEST FAILED - removeLetters1");
		if(removeLetters("Sssss", "s").compareTo("") != 0)
			System.out.println("TEST FAILED - removeLetters2");
		if(removeLetters("", "is").compareTo("") != 0)
			System.out.println("TEST FAILED - removeLetters3");
		if(removeLetters(" apples are pretty great", " ").compareTo("applesareprettygreat") != 0)
			System.out.println("TEST FAILED - removeLetters4");
		

		System.out.println("TESTING COMPLETE.");
	}
	
	/**
	 * This methods takes two Strings and removes all of the characters that are within the
	 * second String from the first String.
	 * 
	 * example : removeLetters("Mississippi River", "is") will return "Mpp Rver"
	 * @param s1 - String to remove letters from
	 * @param s2 - String that tells what letters to remove
	 * @return returns String 1 with all letters within String 2 removed.
	 */
	public static String removeLetters(String s1, String s2){
		String result = "";
		for(int i = 0; i<s2.length(); i++){
			for(int j = 0; j<s1.length(); j++){
				if(s1.toLowerCase().charAt(j) == s2.toLowerCase().charAt(i)){
				result = s1.substring(0,j) + s1.substring(j+1, s1.length());
				s1 = result;
				j = -1;
				}
			}
		}
		return result;
	}

}
