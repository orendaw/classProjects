package test;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class FilterMenu extends JFrame implements ActionListener {
	
	private JRadioButton maxGreenFilter;
	private JRadioButton bwFilter;
	private JRadioButton rgSwap;
	private JRadioButton gbSwap;
	private JRadioButton rbSwap;
	private JRadioButton biasFilter;
	private JRadioButton blurFilter;
	private JRadioButton rotateCW;
	private JRadioButton rotateCCW;
	private JRadioButton gainFilter;
	
	private JButton filterButton;
	
	private JLabel displayLabel;
	
	private int option;
	
	public FilterMenu() {
		
		// Create the radio buttons.
		maxGreenFilter = new JRadioButton("Maximize Green", false);
		bwFilter = new JRadioButton("Black and White", false);
		rgSwap = new JRadioButton("Swap red-green", false);
		gbSwap = new JRadioButton("Swap red-green", false);
		rbSwap = new JRadioButton("Swap red-green", false);
		biasFilter = new JRadioButton("Bias", false);
		blurFilter = new JRadioButton("Blur", false);
		rotateCW = new JRadioButton("Rotate Clockwise", false);
		rotateCCW = new JRadioButton("Rotate CounterCW", false);
		gainFilter = new JRadioButton("Gain", false);
		

		filterButton = new JButton("FILTER");
		filterButton.addActionListener(this);
		
		displayLabel = new JLabel("Pick a filter:");
		
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(maxGreenFilter);
		buttons.add(bwFilter);
		buttons.add(rgSwap);
		buttons.add(gbSwap);
		buttons.add(rbSwap);
		buttons.add(biasFilter);
		buttons.add(blurFilter);
		buttons.add(rotateCW);
		buttons.add(rotateCCW);
		buttons.add(gainFilter);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(3, 3));
		radioPanel.add(maxGreenFilter);
		radioPanel.add(bwFilter);
		radioPanel.add(rgSwap);
		radioPanel.add(gbSwap);
		radioPanel.add(rbSwap);
		radioPanel.add(biasFilter);
		radioPanel.add(blurFilter);
		radioPanel.add(rotateCW);
		radioPanel.add(rotateCCW);
		radioPanel.add(gainFilter);
		
		radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select one:"));
		
		setLayout(new BorderLayout());
		add(radioPanel);   // Adds to CENTER by default.
		add(filterButton, BorderLayout.SOUTH);
		add(displayLabel, BorderLayout.NORTH);
		
		setTitle("Filter Select");
		setPreferredSize(new Dimension(600, 200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();	
	}
	
	public void actionPerformed(ActionEvent e) {
		// The only possible event for this GUI is a click of the "Select" button.
		
		// We do not listen for each radio button, since the user can change her mind.
		// Instead, we listen for the "Select" button and query which of the radio buttons 
		// is selected.
		if(maxGreenFilter.isSelected())
			option = 1;
		else if(rgSwap.isSelected())
			option = 2;
		else if(gbSwap.isSelected())
			option = 3;
		else if(rbSwap.isSelected())
			option = 4;
		else if(bwFilter.isSelected())
			option = 5;
		else if(blurFilter.isSelected())
			option = 6;
		else if(rotateCW.isSelected())
			option = 7;
		else if(rotateCCW.isSelected())
			option = 8;
		else if(gainFilter.isSelected())
			option = 9;
			
	}
	
	public static void main(String[] args) {
		FilterMenu frame = new FilterMenu();
		frame.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
}
