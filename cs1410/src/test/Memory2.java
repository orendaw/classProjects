package test;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class implements a Memory Game GUI.
 * This is also a program for creating and launching the GUI
 * (see the main method).
 * 
 * This is the second version of the GUI built in class, 
 * with buttons included.
 * 
 * @author Erin Parker, last updated 3/28/16
 */
public class Memory2 extends JFrame {
	
	/**
	 * Creates a Memory Game GUI.
	 */
	public Memory2() {
		
		// Exit on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create a container to hold and organize the 16 buttons
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		
		// Create 16 buttons and for each button: 
		//    --construct the button and hide a secret value
		//    --add the button to the container (so it can be seen)
		
		ArrayList<Integer> secretValues = generateSecretValues(8);
	
		for(int i = 0; i < 16; i++) {
			MemoryButton button = new MemoryButton(secretValues.remove(0));
			panel.add(button);
		}
		
		// Set up the JFrame
		setTitle("Memory");
		setContentPane(panel);
		setPreferredSize(new Dimension(300, 300));
		pack();
	}
	
	/** 
	 * Generates a list of integers 1 to limit, two of each, 
	 * randomly shuffled.
	 * 
	 * (This is a helper method for the constructor -- make private.)
	 * 
	 * @param limit -- the largest integer generated
	 * @returns an ArrayList of integers
	 */
	private ArrayList<Integer> generateSecretValues(int limit) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= limit; i++) {
			list.add(i);
			list.add(i);
		}	
		Collections.shuffle(list);
		return list;
	}
	
	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// Create and launch the GUI
		Memory2 m = new Memory2();
		m.setVisible(true);
	}
}