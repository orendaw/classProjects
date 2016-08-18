package lec33;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents an oval shape, with a method for drawing the oval onto a 
 * Graphics context.
 * 
 * @author Erin Parker, last updated 4/11/16
 */
public class Oval {
	
	// Position, size, and color of the oval
	private int positionX;
	private int positionY;
	private int diameterX;
	private int diameterY;
	private Color color;
	
	/**
	 * Creates a new oval.
	 * 
	 * @param _positionX
	 * @param _positionY
	 * @param _diameterX
	 * @param _diameterY
	 * @param _color
	 */
	public Oval(int _positionX, int _positionY, int _diameterX, int _diameterY, Color _color) {
		positionX = _positionX;
		positionY = _positionY;
		diameterX = _diameterX;
		diameterY = _diameterY;
		color = _color;
	}
	
	/**
	 * Sets the diameters of this oval.
	 * 
	 * @param _diameterX
	 * @param _diameterY
	 */
	public void setDiameter(int _diameterX, int _diameterY) {
		diameterX = _diameterX;
		diameterY = _diameterY;
	}

	/**
	 * Paints this oval onto g.
	 */
	public void paintOval(Graphics g) {
		g.setColor(color);
		g.fillOval(positionX, positionY, diameterX, diameterY);
	}
}