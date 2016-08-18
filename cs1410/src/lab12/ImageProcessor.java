package lab12;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/** 
 * Image processing application.
 * Opens an image file, applies a filter to the image to generate a new image,
 * displays both images. 
 * 
 * @author Erin Parker
 */
public class ImageProcessor {
	
	// Change these values as need to use different filters on different image files.
	public static String filename = "/Users/parker/Desktop/sunset.jpg";
	
	public static int FILTER = 1;  // (From Lecture 31) 1 -- maximize green, 2 -- blackout, 
								   // (You create in this lab) 3 -- swap red and green, 
								   // 4 -- swap red and blue, 5 -- swap green and blue

	public static void main(String[] args) {
		
		// Read the image file into a BufferedImage object.
		BufferedImage origImage = null;
		try {
			origImage = ImageIO.read(new File(filename));
		}
		catch(Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		
		// Filter the image.
		ImageFilter f = null;
		
		if(FILTER == 1)
			f = new MaximizeGreenFilter();
		else if(FILTER == 2)
			f = new BlackoutFilter();
//		else if(FILTER == 3)  					UNCOMMENT after you build each of these filters
//			f = new RedGreenSwapFilter();
//		else if(FILTER == 4)
//			f = new RedBlueSwapFilter();
//		else if(FILTER == 5)
//			f = new GreenBlueSwapFilter();
		
		BufferedImage filteredImage = f.filter(origImage);
		
		// Display both the original and the filtered image using tabs.
		JTabbedPane pane = new JTabbedPane();
		pane.add("Original image", new ImagePanel(origImage));
		pane.add("Filtered image", new ImagePanel(filteredImage));

		JFrame filteredImgFrame = new JFrame();
		filteredImgFrame.add(pane);
		filteredImgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		filteredImgFrame.pack();
		filteredImgFrame.setVisible(true);
	}
}
