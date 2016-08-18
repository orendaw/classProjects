package lec34.paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents an oval shape, with a method for drawing the oval onto a 
 * Graphics context.
 * 
 * @author Erin Parker, last updated 4/13/16
 */
public class Oval extends Shape {

	public Oval(int posX, int posY, int sizeX, int sizeY, Color color) {
		super(posX, posY, sizeX, sizeY, color);
	}
	
	/**
	 * Draws this oval.
	 */
	public void paintMe(Graphics g) {
		super.paintMe(g);  // sets color
		g.fillOval(getPosX(), getPosY(), getSizeX(), getSizeY());
	}
}