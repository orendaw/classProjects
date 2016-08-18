package lec34.paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents an rectangle shape, with a method for drawing the rectangle onto a 
 * Graphics context.
 * 
 * @author Erin Parker, last updated 4/13/16
 */
public class Rectangle extends Shape {

	public Rectangle(int posX, int posY, int sizeX, int sizeY, Color color) {
		super(posX, posY, sizeX, sizeY, color);
	}
	
	/**
	 * Draws this rectangle.
	 */
	public void paintMe(Graphics g) {
		super.paintMe(g);  // sets color
		g.fillRect(getPosX(), getPosY(), getSizeX(), getSizeY());
	}
}