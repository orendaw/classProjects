package assign3;

import java.util.Scanner;

/**
 * This class contains a variety of methods that utilize Scanners and perform different 
 * actions to their contents. 
 * @author Orenda Williams
 * date: Feb 4 2016
 *
 */
public class LoopPatterns {

	public static void main(String[] Args){
		if(sum(new Scanner("5 1 1 -2 70")) != 75)
			System.out.println("TEST FAILED - sum1");
		if(sum(new Scanner("-5 0 0 0 5")) != 0)
			System.out.println("TEST FAILED - sum2");
		if(sum(new Scanner("")) != 0)
			System.out.println("TEST FAILED - sum3");
		if(sum(new Scanner("1")) != 1)
			System.out.println("TEST FAILED - sum4");
		
		if(searchWord(new Scanner("apple bee cat bee cat dog"), "tac") != false)
			System.out.println("TEST FAILED - searchWord1");
		if(searchWord(new Scanner("apple bee cat bee cat dog"), "cat") != true)
			System.out.println("TEST FAILED - searchWord2");
		if(searchWord(new Scanner("11 dogs ran home"), "11") != true)
			System.out.println("TEST FAILED - searchWord3");
		if(searchWord(new Scanner("11 dogs ran home"), "1 1") != false)
			System.out.println("TEST FAILED - searchWord4");
		
		if(average(new Scanner("3.2 9.0 -7.1 104.5")) != 27.4)
			System.out.println("TEST FAILED - average1");
		if(average(new Scanner("1 1 1")) != 1.)
			System.out.println("TEST FAILED - average2");
		if(average(new Scanner("0 1 1 1")) != .75)
			System.out.println("TEST FAILED - average3");
		if(average(new Scanner("0 0 0 0 0")) != 0)
			System.out.println("TEST FAILED - average4");
		
		if(moreWordsOfEvenLength(new Scanner("I love Java")) != true)
			System.out.println("TEST FAILED - moreWordsOfEvenLength1");
		if(moreWordsOfEvenLength(new Scanner("Dogs rule and cats drool.")) != true)
			System.out.println("TEST FAILED - moreWordsOfEvenLength2");
		if(moreWordsOfEvenLength(new Scanner("I love Java!")) != false)
			System.out.println("TEST FAILED - moreWordsOfEvenLength3");
		if(moreWordsOfEvenLength(new Scanner("")) != false)
			System.out.println("TEST FAILED - moreWordsOfEvenLength4");
		
		if(emphasize(new Scanner("I am so *angry* right now! ")).compareTo("I am so ANGRY right now! ") != 0)
			System.out.println("TEST FAILED - emphasize1");
		if(emphasize(new Scanner("I am *so angry* right now! ")).compareTo("I am SO ANGRY right now! ") != 0)
			System.out.println("TEST FAILED - emphasize2");
		if(emphasize(new Scanner("I am so *angry* right *now!* ")).compareTo("I am so ANGRY right NOW! ") != 0)
			System.out.println("TEST FAILED - emphasize3");
		if(emphasize(new Scanner("I am so angry right now! ")).compareTo("I am so angry right now! ") != 0)
			System.out.println("TEST FAILED - emphasize4");
		
		if(firstLetters(new Scanner("Let me Google that for you")).compareTo("LmGtfy") != 0)
			System.out.println("TEST FAILED - firstLetters1");
		if(firstLetters(new Scanner("how are you today?")).compareTo("hayt") != 0)
			System.out.println("TEST FAILED - firstLetters2");
		if(firstLetters(new Scanner("!! What are you doing ?!")).compareTo("!Wayd?") != 0)
			System.out.println("TEST FAILED - firstLetters3");
		if(firstLetters(new Scanner("")).compareTo("") != 0)
			System.out.println("TEST FAILED - firstLetters4");
		
		if(countDivBy3(new Scanner("2 -30 9 55 -10 48")) != 3)
			System.out.println("TEST FAILED - 1countDivBy3");
		if(countDivBy3(new Scanner("")) != 0)
			System.out.println("TEST FAILED - 2countDivBy3");
		if(countDivBy3(new Scanner("3 5 6 7")) != 2)
			System.out.println("TEST FAILED - 3countDivBy3");
		if(countDivBy3(new Scanner("1 1 1 1 1")) != 0)
			System.out.println("TEST FAILED - 4countDivBy3");
		
		if(firstWord(new Scanner("one two three four")).compareTo("four") != 0)
			System.out.println("TEST FAILED - firstWord1");
		if(firstWord(new Scanner("z y x")).compareTo("x") != 0)
			System.out.println("TEST FAILED - firstWord2");
		if(firstWord(new Scanner("apple boy cat")).compareTo("apple") != 0)
			System.out.println("TEST FAILED - firstWord3");
		if(firstWord(new Scanner("hfllo hello")).compareTo("hello") != 0)
			System.out.println("TEST FAILED - firstWord4");
		
		if(countInRange(new Scanner("-11.8 -2.0 9.25 3.0 5.0"), -2.0, 5.1) != 3)
			System.out.println("TEST FAILED - countInRange1");
		if(countInRange(new Scanner("0 0 0 0"), -2.0, 5.1) != 4)
			System.out.println("TEST FAILED - countInRange2");
		if(countInRange(new Scanner("1 2 3 4"), 2, 5) != 3)
			System.out.println("TEST FAILED - countInRange3");
		if(countInRange(new Scanner("6 7 8 9"), -2.0, 5.1) != 0)
			System.out.println("TEST FAILED - countInRange4");
		
		if(!(sumOfTangents(new Scanner("4.3 6.5 8.7")) < 1.63 && sumOfTangents(new Scanner("4.3 6.5 8.7")) > 1.62))
			System.out.println("TEST FAILED - sumOfTangents1");
		if(!(sumOfTangents(new Scanner("1 2 3")) < -.77 && sumOfTangents(new Scanner("1 2 3")) > -.78))
			System.out.println("TEST FAILED - sumOfTangents2");
		if(!(sumOfTangents(new Scanner("-1 2.5 4")) < -1.1 && sumOfTangents(new Scanner("-1 2.5 4")) > -1.2))
			System.out.println("TEST FAILED - sumOfTangents3");
		if(sumOfTangents(new Scanner("0")) != 0)
			System.out.println("TEST FAILED - sumOfTangents4");
		
		System.out.println("TESTING COMPLETE.");
			
		
	}
	/**
	 * This method takes a Scanner of integers and returns their sum. If the Scanner
	 * is empty, it returns 0.
	 * @param integers - a Scanner containing integers only.
	 * @return the sum of all inputted integers as an int.
	 */
	public static int sum(Scanner integers){
		int result = 0;
		while(integers.hasNextInt()){
			result += integers.nextInt();
		}
		return result;
	}
	
	/**
	 * This methods takes a Scanner of words and a specific String and returns
	 * a boolean telling if the Scanner contains that specific String.
	 * @param words - a Scanner of words to search within
	 * @param wordToFind - a String that will be searched for
	 * @return true if the Scanner contains the String, false otherwise
	 */
	public static boolean searchWord(Scanner words, String wordToFind){
		boolean result = false;
		while(words.hasNext()){
			if (words.next().compareTo(wordToFind) == 0){
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * This methods takes a Scanner of Doubles and takes the average of all the doubles.
	 * @param values - a Scanner of values of type double
	 * @return a double that is the average of all values within the Scanner.
	 */
	public static double average(Scanner values){
		double sum = 0.;
		int count = 0;
		while(values.hasNextDouble()){
			sum += values.nextDouble();
			count++;
		}
		return sum/count;
	}
	
	/**
	 * This methods takes a Scanner of words and returns a boolean. 
	 * The boolean is true if more of the words within the Scanner are an even length
	 * and false otherwise.
	 * @param words - a Scanner of words
	 * @return boolean true if more of the words are an even length and false otherwise.
	 */
	public static boolean moreWordsOfEvenLength(Scanner words){
		int evenWords = 0;
		int oddWords = 0;
		while(words.hasNext()){
			if(words.next().length()%2 == 0)
				evenWords++;
			else
				oddWords++;
		}
		return evenWords>oddWords;
	}
	
	/**
	 * This method takes in a Scanner of words and returns a String that has capitalized
	 * anything between a pair of asterisks (**). The asterisks are also removed.
	 *  
	 * @param words - A Scanner of words
	 * @return a String that has capitalized anything between a pair of asterisks
	 */
	public static String emphasize(Scanner words){
		String result = "";
		words.useDelimiter("\\*");
		while(words.hasNext()){
			String currentString = words.next();
			result += currentString;
			
			if(words.hasNext()){
			currentString = words.next();
			result += currentString.toUpperCase();
			}
		}
		return result;
	}
	
	/**
	 * This methods takes in a Scanner of words and returns a String made of the first
	 * character of each word in the scanner.
	 * @param words - a Scanner of words
	 * @return a String made of first character of each word in the Scanner.
	 */
	public static String firstLetters(Scanner words){
		String result = "";		
		while(words.hasNext()){
			result = result + words.next().charAt(0);
		}
		return result;
	}
	
	/**
	 * This method takes in a Scanner of integers only and returns an int telling how 
	 * many of the integers in the Scanner are divisible by 3.
	 * @param numbers - Scanner of integers only
	 * @return number of integers within the Scanner that are divisible by 3
	 */
	public static int countDivBy3(Scanner numbers){
		int result = 0;
		while(numbers.hasNextInt()){
			if(numbers.nextInt() % 3 == 0){
				result++;
			}
		}
		return result;
	}
	
	/**
	 * This methods takes in a Scanner of words and returns a String containing the word
	 * that comes first in lexographical order within the Scanner.
	 * @param words - Scanner containing words
	 * @return first word in lexographical order within the Scanner
	 */
	public static String firstWord(Scanner words){
		String currentWord = "";
		String result = words.next();
		while(words.hasNext()){
			currentWord = words.next();
			if(result.compareTo(currentWord) > 0){
				result = currentWord;
			}
		}
		return result;
	}
	
	/**
	 * This method takes in a Scanner of values that are doubles and two double values that 
	 * make up a range (a is the low end of range, b is the high end of range) and returns
	 * an integer of how many values in the Scanner fall within that range.
	 * 
	 * @param values - Scanner of doubles
	 * @param a - low end of range
	 * @param b - high end of range
	 * @return number of values within the Scanner that fall within the range.
	 */
	public static int countInRange(Scanner values, double a, double b){
		int result = 0;
		while(values.hasNextDouble()){
			double currentNum = values.nextDouble();
			if (currentNum >= a && currentNum <= b){
				result++;
			}
		}
		return result;
	}
	
	/**
	 * This methods takes a Scanner of values that are doubles, finds the tangent
	 * of each value, and then sums them all together.
	 * 
	 * @param values - Scanner of doubles
	 * @return sum of the tangents of the values as a double.
	 */
	public static double sumOfTangents(Scanner values){
		double result = Math.tan(values.nextDouble());
		double currentTan = result;
		while(values.hasNextDouble()){
			currentTan = Math.tan(values.nextDouble());
			result += currentTan;
		}
		return result;
	}
}
