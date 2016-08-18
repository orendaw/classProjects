package part3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import part3.Region2d;

/** 
 * A JPanel for displaying a BufferedImage.
 *
 * @author Erin Parker
 */
public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener{
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;
	private boolean regionActive;
	
	public ImagePanel(BufferedImage img) {
		image = img;
		setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
		addMouseListener(this);
		addMouseMotionListener(this);
		regionActive = false;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		minX = 0;
		minY = 0;
		maxX = 0;
		maxY = 0;

		regionActive = false;
	}

	public void mouseEntered(MouseEvent arg0) {
		// unused method		
	}

	public void mouseExited(MouseEvent arg0) {
		// unused method		
	}
	
	/** 
	 * The method sets the minX and minY to the location where the mouse 
	 * is first pressed.
	 */
	public void mousePressed(MouseEvent e) {
		minX = e.getX();
		minY = e.getY();
		regionActive = true;
	}

	/**
	 * This method prints out X,Y information useful during development.
	 */
	public void mouseReleased(MouseEvent arg0) {
		repaint();
	}
	
	/**
	 * This method sets the maxX and maxY values as the mouse is dragged.
	 */
	public void mouseDragged(MouseEvent e) {
		maxX = e.getX();
		maxY = e.getY();
		regionActive = true;
		repaint();
	}

	public void mouseMoved(MouseEvent arg0) {
		// unused method		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		g.setColor(new Color(105, 105, 105, 125));
		g.fillRect(minX, minY, maxX - minX, maxY - minY);
	}
	
	/**
	 * Getter for the selected region.
	 * 
	 * @return a Region2d object that represents the region selected on the panel
	 */
	public Region2d getSelectedRegion() {
		if (minX > maxX){
			int temp = minX;
			minX = maxX;
			maxX = temp;
		}
		if(minY > maxY){
			int temp = minY;
			minY = maxY;
			maxY = temp;
		}
		if(minX == 0 && minY == 0 && maxX == 0 && maxY == 0){
			maxX = image.getWidth();
			maxY = image.getHeight();
			regionActive = false;
		}
		
		return new Region2d(minX, maxX, minY, maxY);
	}
	
	public boolean isRegionActive(){
		return regionActive;
	}
}
