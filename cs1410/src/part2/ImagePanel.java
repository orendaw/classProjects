package part2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/** 
 * A JPanel for displaying a BufferedImage.
 *
 * @author Erin Parker
 */
public class ImagePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	
	public ImagePanel(BufferedImage img) {
		image = img;
		setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
	}
	
	// More on this later in the week.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}
