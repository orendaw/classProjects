package part1;

import java.awt.image.BufferedImage;

/**
 * 	Filter swaps the red and green values of an image.
 * 
 * @author Orenda Williams, last updated 4/14/2016
 */

public class RedGreenSwapFilter implements ImageFilter {
	
public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);

		// For each pixel in the image . . . 
		for(int y = 0; y < i.getHeight(); y++)
			for(int x = 0; x < i.getWidth(); x++) {

				int pixel = i.getRGB(x, y);
				
				// Decompose the pixel in the amounts of red, green, and blue.
				int redAmount = (pixel >> 16) & 0xff;
				int greenAmount = (pixel >> 8) & 0xff;
				int blueAmount = (pixel >> 0) & 0xff;
				
				// Compose the new pixel.
				int newPixel = (greenAmount << 16 ) | (redAmount<< 8) | blueAmount;
				
				// Set the pixel of the new image.
				result.setRGB(x, y, newPixel);
			}
		
		return result;
	}

}
