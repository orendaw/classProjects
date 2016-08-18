package selectionOptions;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This program creates and launches a GUI to demonstrate the use of 
 * radio boxes for selection.
 * 
 * @author Erin Parker, last updated 4/6/16
 */
public class RadioButtonDemo extends JFrame implements ActionListener {
	
	private JRadioButton rock;
	private JRadioButton paper;
	private JRadioButton scissors;
	
	private JButton selectButton;
	
	private JLabel displayLabel;
	
	public RadioButtonDemo() {
		
		// Create the radio buttons.
		rock = new JRadioButton("Rock", true);  // true: set to be selected by default
		paper = new JRadioButton("Paper", false); 
		scissors = new JRadioButton("Scissors", false); 

		// Group the radio buttons together.
		// Only one of these may be selected at a time.
		ButtonGroup group = new ButtonGroup();
		group.add(rock);
		group.add(paper);
		group.add(scissors);
		
		// Add the radio buttons to a panel, organized by a layout.
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(3, 1));
		radioPanel.add(rock);
		radioPanel.add(paper);
		radioPanel.add(scissors);
		
		// Optionally put a border around the panel.
		radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select one:"));
		
		// Create a "Select" button for the user to click when the radio button selection is complete.
		selectButton = new JButton("Select");
		selectButton.addActionListener(this);
		
		// Create a label for displaying messages to the user.
		displayLabel = new JLabel("Waiting . . . ");
		
		// Add the radio buttons, "Select" button, and label to this frame.
		setLayout(new BorderLayout());
		add(radioPanel);   // Adds to CENTER by default.
		add(selectButton, BorderLayout.EAST);
		add(displayLabel, BorderLayout.NORTH);
		
		// Set up this frame.
		setTitle("Radio button demo");
		setPreferredSize(new Dimension(250, 175));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	public void actionPerformed(ActionEvent e) {
		// The only possible event for this GUI is a click of the "Select" button.
		
		// We do not listen for each radio button, since the user can change her mind.
		// Instead, we listen for the "Select" button and query which of the radio buttons 
		// is selected.
		if(rock.isSelected())
			displayLabel.setText("You selected ROCK.");
		else if(paper.isSelected())
			displayLabel.setText("You selected PAPER.");
		else // scissors.isSelected() must be true
			displayLabel.setText("You selected SCISSORS.");
	}
	
	public static void main(String[] args) {
		RadioButtonDemo frame = new RadioButtonDemo();
		frame.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
}