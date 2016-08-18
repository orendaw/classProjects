package lec34.paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a general shape, with a method for partial 
 * drawing the shape onto a Graphics context.
 * 
 * @author Erin Parker, last updated 4/13/16
 */
public abstract class Shape {
	
	private int posX;
	private int posY;
	private int sizeX;
	private int sizeY;
	private Color color;
	
	public Shape(int _posX, int _posY, int _sizeX, int _sizeY, Color _color) {
		posX = _posX;
		posY = _posY;
		sizeX = _sizeX;
		sizeY = _sizeY;
		color = _color;
	}
	
	/**
	 * Getter for the x position of this shape. 
	 */
	public int getPosX() {
		return posX;
	}
	
	/**
	 * Getter for the y position of this shape. 
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * Getter for the size in the x dimension for this shape. 
	 */
	public int getSizeX() {
		return sizeX;
	}
	
	/**
	 * Getter for the size in the y dimension for this shape. 
	 */
	public int getSizeY() {
		return sizeY;
	}
	
	/**
	 * Setter for the size of this shape.
	 */
	public void setSize(int _sizeX, int _sizeY) {
		sizeX = _sizeX;
		sizeY = _sizeY;
	}
	
	/**
	 * Partially draw this shape by setting the color.
	 */
	public void paintMe(Graphics g) {
		g.setColor(color);
	}
}