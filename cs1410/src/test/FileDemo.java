package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * This program demonstrates how to open and read files,
 * using either the filename or a JFileChooser GUI.
 * 
 * @author Erin Parker, last updated 2/5/16
 */
public class FileDemo {

	public static void main(String[] args) {

//		demoFile();
		demoFileChooser();
	}

	/**
	 * This method demonstrates how to open and read a file using its
	 * name and path.  It also demonstrates when a NoSuchElementException
	 * can happen using a Scanner. 
	 */
	public static void demoFile() {
//		File f = new File("/Users/parker/Desktop/sample_file.txt");
		File f = new File("/Users/parker/Desktop/pride_and_prejudice.txt");
		Scanner s = null;

		try {
			s = new Scanner(f);
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: File " + f.getName() + " does not exist.");
			System.exit(0);
		}

		// Causes NoSuchElementException if the file contains < 100 words.
		for(int i = 0; i < 100; i++) {
			s.next();
		}
		
		s.close();
	}

	/**
	 * The method demonstrates how to use a JFileChooser GUI to 
	 * open a file.  It also demonstrates how to use a Scanner
	 * to read the file.
	 */
	public static void demoFileChooser() {

		// Open a file chooser.
		JFileChooser chooser = new JFileChooser();

		// Display a file chooser and find out what happened.
		int outcome = chooser.showOpenDialog(null);

		// If the user selected a file ...
		if(outcome == JFileChooser.APPROVE_OPTION) {

			// Make a scanner from the file the user chose.
			File f = chooser.getSelectedFile();
			Scanner wordCountScanner = null;

			try {
				wordCountScanner = new Scanner(f);
			}
			catch(FileNotFoundException e) {
				System.out.println("ERROR: File " + f.getName() + " does not exist.");
				System.exit(0);
			}

			System.out.println("File " + f.getName() + " contains " + 
					countWords(wordCountScanner) + " words.");

			wordCountScanner.close();
		}
		
		// Else, if the user did not select a file, do nothing.
	}

	/**
	 * Determines the number of words / tokens contains in a given Scanner.
	 * 
	 * @param s -- the Scanner
	 * @return the number of words
	 */
	public static int countWords(Scanner s) {
		int count = 0;
		while(s.hasNext()) {
			s.next();
			count++;
		}
		return count;
	}
}