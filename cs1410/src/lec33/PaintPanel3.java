package lec33;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * Defines a specific kind of GUI panel for drawing ovals.
 * 
 * @author Erin Parker, last updated 4/8/16
 */
public class PaintPanel3 extends JPanel implements MouseListener {

	// Position, size, and color of the oval drawn.
	private int positionX;
	private int positionY;
	private int diameterX;
	private int diameterY;
	private Color color;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a PaintPanel containing a single oval.
	 */
	public PaintPanel3() {
		positionX = 100;
		positionY = 100;
		diameterX = 50;
		diameterY = 50;
		color = Color.black;
		setBackground(Color.WHITE);
		addMouseListener(this);
	}

	/**
	 * Sets the color of the next oval to be drawn.
	 */
	public void setCurrentColor(Color c) {
		color = c;
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
		
		// Also, draw a filled oval.
		g.setColor(color);
		g.fillOval(positionX, positionY, diameterX, diameterY);
	}
	
	// The following methods are from the MouseListener interface.
	// For any not used, simply leave empty.

	/**
	 * The method is invoked when the user clicks the mouse on the GUI.
	 * 
	 * @param e -- object with info on the mouse event
	 */
	public void mouseClicked(MouseEvent e) {
		positionX = e.getX();   // set x, y of oval to location of mouse click
		positionY = e.getY();
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