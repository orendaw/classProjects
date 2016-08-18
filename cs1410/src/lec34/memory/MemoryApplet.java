package lec34.memory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class implements a Memory Game GUI as an applet.
 * 
 * @author Erin Parker, last updated 3/28/16
 */
public class MemoryApplet extends JApplet implements ActionListener {
	
	/**
	 * This method launches the applet, like the main method for a standalone
	 * application.
	 */
	public void init() {
		MemoryApplet m = new MemoryApplet();
		m.setVisible(true);
	}
	
	// buttons on game board currently selected
	private ArrayList<MemoryButton> buttonsSelected; 
	
	// helpful message for user
	private JLabel msgLabel;
	
	// counter for matches made so far
	private int matchCount;

	public MemoryApplet() {
		
		// Create a container to hold and organized the 16 buttons
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		
		// Create 16 buttons.  For each button, 
		//    --construct the button and hide a secret value
		//    --add the button to the container (so it can be seen)
		//    --add a listener for the button (what to do when user selects)
		
		ArrayList<Integer> secretValues = generateSecretValues(8);
	
		for(int i = 0; i < 16; i++) {
				MemoryButton button = new MemoryButton(secretValues.remove(0));
				panel.add(button);
				button.addActionListener(this);
		}
		
		// Keep track of buttons selected by the user, none yet
		buttonsSelected = new ArrayList<MemoryButton>();  
		
		// Add and place message label
		msgLabel = new JLabel("Let's play MEMORY!", JLabel.CENTER);
		msgLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(panel, BorderLayout.CENTER);
		panel2.add(msgLabel, BorderLayout.SOUTH);
		panel = panel2;   // to avoid changing code below the sets up JFrame
		
		// Initialize match counter
		matchCount = 0;
		
		// Set up the applet
		setContentPane(panel);
		setPreferredSize(new Dimension(300, 300));
	}
	
	/**
	 * This method is called when a button is selected.
	 */
	public void actionPerformed(ActionEvent e) {	
		
		// If two buttons were saved from last round, their values need to be hidden
		if(buttonsSelected.size() == 2) {
			buttonsSelected.get(0).hideValue();
			buttonsSelected.get(1).hideValue();
			buttonsSelected.clear();
		}
		
		// Get the button just selected by user
		MemoryButton button = (MemoryButton)e.getSource();
		
		// Disable the button selected by the user
		button.setEnabled(false);
		
		// Show the value for the button
		button.showValue();
		
		// Keep track of this button for future rounds
		buttonsSelected.add(button);
 
		// If this is the second button of a pair, check for a match
		if(buttonsSelected.size() == 2)
			if(button.getValue() == buttonsSelected.get(0).getValue()) {
				
				// Color buttons on match 
				button.colorMe();
				buttonsSelected.get(0).colorMe();
				
				// We are finished with these buttons, do not save for future round
				buttonsSelected.clear();
								
				// Check if game is over
				matchCount++;
				if(matchCount == 8)
					msgLabel.setText("You found all matches! Game over.");
				else
					msgLabel.setText("MATCH! " + matchCount + " found so far.");
			}
			else {  // Enable both buttons
				buttonsSelected.get(0).setEnabled(true);
				buttonsSelected.get(1).setEnabled(true);	
				
				msgLabel.setText(buttonsSelected.get(0).getValue() + " and " + buttonsSelected.get(1).getValue() + " do not match. Try again.");				
			}
		// This is the first button in a pair
		else
			msgLabel.setText("Select another button.");
	}
	
	/** 
	 * Returns a list of integers 1 to limit, two of each, 
	 * randomly shuffled.
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
	
	private static final long serialVersionUID = 1L;
}