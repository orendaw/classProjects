package selectionOptions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This program creates and launches a GUI to demonstrate the use of 
 * menu bars for selection.
 * 
 * @author Erin Parker, last updated 4/6/16
 */
public class MenuBarDemo extends JFrame implements ActionListener {
	
	private JMenuItem rock;
	private JMenuItem paper;
	private JMenuItem scissors;
	
	private JLabel displayLabel;

	public MenuBarDemo() {
		
		// Create a menu to contain the three options
		JMenu optionsMenu = new JMenu("Options");
	
		// Create each option
		rock = new JMenuItem("Rock");
		rock.addActionListener(this);
		optionsMenu.add(rock);
		
		paper = new JMenuItem("Paper");
		paper.addActionListener(this);
		optionsMenu.add(paper);
		
		scissors = new JMenuItem("Scissors");
		scissors.addActionListener(this);
		optionsMenu.add(scissors);
		
		// Create a menu bar to reside at the top of the frame
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(optionsMenu);
		// Connect the menu bar to this frame
		setJMenuBar(menuBar);  
		
		// Create a label for displaying messages to the user
		displayLabel = new JLabel("Waiting . . . ");
		
		// Add the label to this frame
		setContentPane(displayLabel);
		
		// Set up this frame
		setTitle("Menu bar demo");
		setPreferredSize(new Dimension(200, 200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		// The only possible event for this GUI is selecting an item from the menu.
		
		JMenuItem item = (JMenuItem)e.getSource();
		displayLabel.setText("You selected " + item.getText());
	}

	public static void main(String[] args) {
		MenuBarDemo frame = new MenuBarDemo();
		frame.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
}
