package assign9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This class represents the settings box for the LightsOut class.
 * @author Orenda Williams
 *
 */

public class LightsOutSettings extends JFrame implements ActionListener {

	private JRadioButton yellow;
	private JRadioButton pink;
	private JRadioButton orange;
	
	private JButton selectButton;
	private JLabel displayLabel;
	private JComboBox<String> rowList;
	private JComboBox<String> colList;
	private int[] result;
	private static LightsOutSettings frame;
	private static boolean isReady;
	
	private static final long serialVersionUID = 1L;
	
	public LightsOutSettings() {
		
		// Create the radio buttons.
		yellow = new JRadioButton("Yellow", true);  // true: set to be selected by default
		pink = new JRadioButton("Pink", false); 
		orange = new JRadioButton("Orange", false); 

		// Group the radio buttons together.
	
		ButtonGroup group = new ButtonGroup();
		group.add(yellow);
		group.add(pink);
		group.add(orange);
		
		// Add the radio buttons to a panel, organized by a layout.
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(3, 1));
		radioPanel.add(yellow);
		radioPanel.add(pink);
		radioPanel.add(orange);
		
		String[] rows = { "4", "5", "6", "7" };
		String[] cols = { "4", "5", "6", "7" };
		
		rowList = new JComboBox<String>(rows);
		rowList.setSelectedIndex(1);
		rowList.addActionListener(this);
		
		colList = new JComboBox<String>(cols);
		colList.setSelectedIndex(1);
		colList.addActionListener(this);
		
		JPanel comboPanel = new JPanel();
		comboPanel.setLayout(new GridLayout(2, 1));
		comboPanel.add(rowList);
		comboPanel.add(colList);
		
		
		
		radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select color:"));
		comboPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select rows and columns:"));
		comboPanel.setPreferredSize(new Dimension(250, 100));
		
		selectButton = new JButton("OK");
		selectButton.addActionListener(this);
		
		displayLabel = new JLabel("Settings: ");
		
		setLayout(new BorderLayout());
		add(radioPanel, BorderLayout.CENTER);   
		add(comboPanel, BorderLayout.EAST);
		add(selectButton, BorderLayout.SOUTH);
		add(displayLabel, BorderLayout.NORTH);
		
		setTitle("Lights Out! Settings");
		setPreferredSize(new Dimension(500, 300));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
	}
	
	
	
	public static void main(String[] args) {
		frame = new LightsOutSettings();
		frame.setVisible(true);
		isReady = false;
	}
	
	public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == selectButton){
				result();
				isReady = true;
				frame.setVisible(false);
			}
	}
		
	
	
	private void result(){
		result = new int[3];
		if(yellow.isSelected())
			result[0] = 0;
		else if(pink.isSelected())
			result[0] = 1;
		else if(orange.isSelected()){
			result[0] = 2;
		}
		result[1] = Integer.parseInt((String) rowList.getSelectedItem());
		result[2] = Integer.parseInt((String) colList.getSelectedItem());
		
	}
	
	public  int[] getResult(){
		
		return result;
	}

	public boolean isReady(){
		return isReady;
	}

}
