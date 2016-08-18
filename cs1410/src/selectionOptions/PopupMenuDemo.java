package selectionOptions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * This program creates and launches a GUI to demonstrate the use of 
 * pop-up menus for selection.
 * 
 * @author Erin Parker, last updated 4/6/16
 */
public class PopupMenuDemo extends JFrame implements ActionListener {
		
	private JMenuItem rock;
	private JMenuItem paper;
	private JMenuItem scissors;
	
	private JLabel displayLabel;

	public PopupMenuDemo() {
		
		// Create a pop-up menu to contain the three options.
		JPopupMenu optionsMenu = new JPopupMenu();
	
		// Create each option.
		rock = new JMenuItem("Rock");
		rock.addActionListener(this);
		optionsMenu.add(rock);
		
		paper = new JMenuItem("Paper");
		paper.addActionListener(this);
		optionsMenu.add(paper);
		
		scissors = new JMenuItem("Scissors");
		scissors.addActionListener(this);
		optionsMenu.add(scissors);
		
		// Add listener to this component so it can bring up a pop-up menu.
	    addMouseListener(new PopupListener(optionsMenu));
		
		// Create a label for displaying messages to the user.
		displayLabel = new JLabel("Waiting . . . (hint: do a right-click)");
		
		// Add the label to this frame.
		setContentPane(displayLabel);
		
		// Set up this frame.
		setTitle("Popup menu demo");
		setPreferredSize(new Dimension(300, 200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		// The only possible event for this GUI is selecting an item from the menu.
		
		JMenuItem item = (JMenuItem)e.getSource();
		displayLabel.setText("You selected " + item.getText());
	}

	public static void main(String[] args) {
		PopupMenuDemo frame = new PopupMenuDemo();
		frame.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
}