package lec34.paint;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import lec33.PaintPanel5;

import java.awt.event.*;

/**
 * Creates and launches a GUI for painting / drawing ovals.
 * 
 * @author Erin Parker, last updated 4/13/16
 */
public class Paint extends JFrame implements ActionListener {

	// Menu item for closing GUI
	private JMenuItem closeItem;
	private JMenuItem clearItem;
	
	// Menu items for selecting a color
	private JMenuItem cyanItem;
	private JMenuItem pinkItem;
	private JMenuItem greenItem;
	private JMenuItem magentaItem;
	private JMenuItem orangeItem;
	
	// PaintPanel
	private PaintPanel6 panel;
	
	public Paint() {

		// Make a PaintPanel the content of this frame.
		panel = new PaintPanel6();
		setContentPane(panel);

		// Add a File menu with a Close option.
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		clearItem = new JMenuItem("Clear");
		clearItem.addActionListener(this);
		fileMenu.add(clearItem);
		closeItem = new JMenuItem("Close");
		closeItem.addActionListener(this);
		fileMenu.add(closeItem);
		menubar.add(fileMenu);
		
		// Add a Set-color menu with options for several colors.
		JMenu colorMenu = new JMenu("Set color");
		cyanItem = new JMenuItem("Cyan");
		cyanItem.addActionListener(this);
		colorMenu.add(cyanItem);
		pinkItem = new JMenuItem("Pink");
		pinkItem.addActionListener(this);
		colorMenu.add(pinkItem);
		greenItem = new JMenuItem("Green");
		greenItem.addActionListener(this);
		colorMenu.add(greenItem);
		magentaItem = new JMenuItem("Magenta");
		magentaItem.addActionListener(this);
		colorMenu.add(magentaItem);
		orangeItem = new JMenuItem("Orange");
		orangeItem.addActionListener(this);
		colorMenu.add(orangeItem);
		menubar.add(colorMenu);
		setJMenuBar(menubar);

		// Use a tool tip to explain the purpose of the Set-color menu.
		colorMenu.setToolTipText("Select the color of the next oval to be drawn.");
		
		// Setup this frame.
		setPreferredSize(new Dimension(700, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();
		
		if(src == closeItem) 
			dispose();   // close the window

		if(src == clearItem) 
			panel.clearPanel(); 
		else {
			Color newColor = null;
			if(src == cyanItem) 
				newColor = Color.cyan;
			else if(src == pinkItem)	
				newColor = Color.pink;
			else if(src == greenItem)	
				newColor = Color.green;
			else if(src == magentaItem)	
				newColor = Color.magenta;
			else 	
				newColor = Color.orange;
			panel.setCurrentColor(newColor); 
		}
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Paint p = new Paint();
		p.setVisible(true);
	}
}