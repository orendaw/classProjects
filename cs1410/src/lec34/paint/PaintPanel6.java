package lec34.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Defines a specific kind of GUI panel for drawing shapes.
 * 
 * @author Erin Parker, last updated 4/13/16
 */
public class PaintPanel6 extends JPanel implements MouseListener, MouseMotionListener {

	private ArrayList<Shape> shapes;
	private int currentSize;
	private Color currentColor;
	private Random rng;

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a PaintPanel containing a list of shapes.
	 */
	public PaintPanel6 () {
		shapes = new ArrayList<Shape>();
		currentSize = 10;
		currentColor = Color.black;
		setBackground(Color.WHITE);
		addMouseListener(this);		
		addMouseMotionListener(this);
		rng = new Random();
	}
	
	/**
	 * Sets the color of the next shape(s) to be drawn.
	 */
	public void setCurrentColor(Color c) {
		currentColor = c;
	}
	
	/**
	 * "Erases" shapes from the panel and resets diameter.
	 */
	public void clearPanel() {
		shapes.clear();
		repaint();
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
	public void paintComponent (Graphics g) {
		// Call JPanel's paintComponent method to fill in panel with background color.
		super.paintComponent(g);   
		
		// Also, draw all shapes in the list.
		for(Shape s : shapes)
			s.paintMe(g);
	}
	
	// The following methods are from the MouseListener interface.
	// For any not used, simply leave empty.

	public void mouseClicked(MouseEvent e) {
		if(rng.nextBoolean()) 
			shapes.add(new Oval(e.getX(), e.getY(), currentSize, currentSize, currentColor));
		else
			shapes.add(new Rectangle(e.getX(), e.getY(), currentSize, currentSize, currentColor));
		currentSize += 10;  
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
	
	// The following methods are from the MouseListener interface.
	// For any not used, simply leave empty.

	/**
	 * This is called whenever the mouse is dragged inside this PaintPanel.
	 * Changes the size of the most recently created shape and instructs to repaint.
	 */
	public void mouseDragged(MouseEvent e) {
		shapes.get(shapes.size()-1).setSize(e.getX(), e.getY());
		repaint();
	}

	public void mouseMoved(MouseEvent arg0) {
		// unused method
	}
}