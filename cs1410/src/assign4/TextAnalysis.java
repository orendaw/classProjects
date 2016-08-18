package assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * This class has the user select and file and give a word and gives back some statistics
 * related to them.
 * date: 2/11/2016
 * @author Orenda Williams
 *
 */
public class TextAnalysis {
	
	public static void main(String[] args){
		
		try{
			String wordToFind = (JOptionPane.showInputDialog("Please enter a word to search for: ")).toLowerCase();
			
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
			
			try{
				Scanner book = new Scanner(f);
				int numOfDesiredWord = wordInFile(book, wordToFind);
				
				book = new Scanner(f);
				double averageLength = averageWordLength(book);
				
				book = new Scanner(f);
				String wordBefore = wordBefore(book, wordToFind);
				
				book = new Scanner(f);
				String wordAfter = wordAfter(book, wordToFind);
				
				book = new Scanner(f);
				String longestWord = findLongestWord(book);
				
				JOptionPane.showMessageDialog(null, "The word " + wordToFind + " shows up " + numOfDesiredWord + " times.\n"
					+ "The average length of all words is " + averageLength + ".\n"
					+ "The word that occurs lexicographically before " + wordToFind + " is " + wordBefore + ".\n"
					+ "The word that occurs lexicographically after " + wordToFind + " is " + wordAfter + ".\n"
					+ longestWord + " is the longest word. " + wordToFind + " is " + (longestWord.length() - wordToFind.length()) + " characters shorter.");
			
				}
				catch(FileNotFoundException e){
					JOptionPane.showMessageDialog(null, "File not found.");
				}
		}
		catch(NullPointerException e){}		
	}

	/**
	 * A method that finds the number of times a user's target word occurs in a Scanner.
	 * @param file - the Scanner to be searched within
	 * @param word - the word to count how many times it appears
	 * @return int - returns how many times the target word appears within the Scanner 
	 */
	public static int wordInFile(Scanner file, String word){
		int count = 0;
		while(file.hasNext()){
			if (file.next().toLowerCase().compareTo(word) == 0)
				count++;
		}
		return count;
	}

	/**
	 * This method finds the average lengths of all words within a Scanner and returns a double.
	 * @param file - Scanner that is desired to find average word length
	 * @return double - average word length within a Scanner
	 */
	public static double averageWordLength(Scanner file){
		int total = 0;
		int count = 0;
		
		while (file.hasNext()){
			total += file.next().length();
			count++;
		}
		
		return total / (double)count;
	}
	
	/**
	 * Finds the word that is lexicographically before the target word within a Scanner.
	 * @param s - the Scanner to be searched within
	 * @param word - the target word
	 * @return String - the word that is lexicographically before the target word
	 */
	public static String wordBefore(Scanner s, String word){
		
		String bestSoFar = word;
		
		while (s.hasNext()){
			String current = s.next().toLowerCase();
			if(current.compareTo(word) < 0){
				if(current.compareTo(bestSoFar) > 0 || bestSoFar.equals(word)){
					bestSoFar = current;
				}
			}
		}
		return bestSoFar;
	}
	
	/**
	 * Finds the word that is lexicographically after the target word within a Scanner.
	 * @param s - the Scanner to be searched within
	 * @param word - the target word
	 * @return String - the word that is lexicographically after the target word
	 */
	public static String wordAfter(Scanner s, String word){
		
		String bestSoFar = word;
		
		while (s.hasNext()){
			String current = s.next().toLowerCase();
			if(current.compareTo(word) > 0 ){
				if (current.compareTo(bestSoFar) < 0 || bestSoFar.equals(word)){
					bestSoFar = current;
				}
			}
		}
		return bestSoFar;
	}
/**
 * This method finds the longest word in a Scanner
 * @param s - Scanner to be searched
 * @return returns longest string within Scanner
 */
	public static String findLongestWord (Scanner s){
		String bestSoFar = "";
		
		while (s.hasNext()){
			String current = s.next();
			if(current.length() > bestSoFar.length()){
				bestSoFar = current;
			}
		}
		
		return bestSoFar;
	}

}
