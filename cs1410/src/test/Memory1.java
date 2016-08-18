package test;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class implements a Memory Game GUI.
 * This is also a program for creating and launching the GUI
 * (see the main method).
 * 
 * This is the first version of the GUI built in class, 
 * just an "empty" JFrame.
 * 
 * @author Erin Parker, last updated 3/28/16
 */
public class Memory1 extends JFrame {

	/**
	 * Creates a Memory Game GUI.
	 */
	public Memory1() {
		
		// Exit on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create a container to hold and organize the 16 buttons
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		
		// Set up the JFrame.
		setTitle("Memory");
		setContentPane(panel);
		setPreferredSize(new Dimension(300, 300));
		pack();
	}
	
	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// Create and launch the GUI
		Memory1 m = new Memory1();
		m.setVisible(true);
	} 
}