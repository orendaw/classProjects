package selectionOptions;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This program creates and launches a GUI to demonstrate the use of 
 * combo boxes for selection.
 * 
 * @author Erin Parker, last updated 4/6/16
 */
public class ComboBoxDemo extends JFrame implements ActionListener {

	private JLabel displayLabel;
	
	public ComboBoxDemo() {
		
		String[] arr = { "Rock", "Paper", "Scissors" };

		//Create the combo box, selecting item at index 1 by default.
		JComboBox<String> optionList = new JComboBox<String>(arr);
		optionList.setSelectedIndex(1);
		optionList.addActionListener(this);
		
		// Create a label for displaying messages to the user.
		displayLabel = new JLabel("Waiting . . . ");
		
		// Add the combo box and label to this frame.
		setLayout(new BorderLayout());
		add(optionList);   // Adds to CENTER by default.
		add(displayLabel, BorderLayout.NORTH);
		
		// Set up this frame.
		setTitle("Combo box demo");
		setPreferredSize(new Dimension(150, 100));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	public void actionPerformed(ActionEvent e) {
		// The only possible event for this GUI is selecting an item in the combo box,
		// so we are guaranteed that this is a safe cast -- okay to ignore warning.
        JComboBox<String> cb = (JComboBox<String>)e.getSource();
        Object item = cb.getSelectedItem();        
        displayLabel.setText("You selected " + item);
	}
	
	public static void main(String[] args) {
		ComboBoxDemo frame = new ComboBoxDemo();
		frame.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
}