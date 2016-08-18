package part3;

import java.awt.image.BufferedImage;

/**
 * 	Filter rotates an image in the counterclockwise.
 * 
 * @author Orenda Williams, last updated 4/14/2016
 */

public class RotateCounterClockwiseFilter implements ImageFilter {

public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(i.getHeight(), i.getWidth(), BufferedImage.TYPE_INT_RGB);

		// For each pixel in the image . . . 
		for(int y = 0; y < i.getHeight(); y++)
			for(int x = 0; x < i.getWidth(); x++) {

				int pixel = i.getRGB(x, y);
				
				// Set the pixel of the new image.
				result.setRGB(y, result.getHeight()-1-x, pixel);
			}
		
		return result;
	}
}
