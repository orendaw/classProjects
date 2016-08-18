package lec33;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


/**
 * Defines a specific kind of GUI panel for drawing ovals.
 * 
 * @author Erin Parker, last updated 4/11/16
 */
public class PaintPanel4 extends JPanel implements MouseListener {

	private ArrayList<Oval> ovals;
	private int currentDiameter;
	private Color currentColor;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a PaintPanel containing a list of ovals.
	 */
	public PaintPanel4() {
		ovals = new ArrayList<Oval>();
		currentDiameter = 10;
		currentColor = Color.black;
		setBackground(Color.WHITE);
		addMouseListener(this);
	}
	
	/**
	 * Sets the color of the next oval(s) to be drawn.
	 */
	public void setCurrentColor(Color c) {
		currentColor = c;
	}

	/**
	 * This method is called by the system when a component needs to be painted.
	 * Which can be at one of three times:
	 *    --when the component first appears
	 *    --when the size of the component changes (including resizing by the user)
	 *    --when repaint() is called
	 * 
	 * Partially overrides the paintComponent method of JPanel.
	 * 
	 * @param g -- graphics context onto which we can draw
	 */
	public void paintComponent(Graphics g) {
		// Call parent JPanel's paintComponent method to fill in panel with background color.
		super.paintComponent(g);   
		
		// Also, draw all ovals in the list.
		for(Oval o : ovals)
			o.paintOval(g);
	}
	
	// The following methods are from the MouseListener interface.
	// For any not used, simply leave empty.

	/**
	 * The method is invoked when the user clicks the mouse on the GUI.
	 * 
	 * @param e -- object with info on the mouse event
	 */
	public void mouseClicked(MouseEvent e) {
		Oval o = new Oval(e.getX(), e.getY(), currentDiameter, currentDiameter, currentColor);
		ovals.add(o);
		currentDiameter += 10;  // update to make future ovals larger
		repaint();
	}

	public void mouseEntered(MouseEvent arg0) {
		// unused method
	}

	public void mouseExited(MouseEvent arg0) {
		// unused method
	}

	public void mousePressed(MouseEvent arg0) {
		// unused method
	}

	public void mouseReleased(MouseEvent arg0) {
		// unused method
	}
}