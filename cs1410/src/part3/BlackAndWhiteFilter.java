package part3;

import java.awt.image.BufferedImage;

/**
 * 	Changes an image to black and white.
 * 
 * @author Orenda Williams, last updated 4/27/2016
 */
public class BlackAndWhiteFilter extends ImageRegionFilter {
	
public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);

		// For each pixel in the image . . . 
		for(int y = 0; y < i.getHeight(); y++)
			for(int x = 0; x < i.getWidth(); x++) {
				if(y >= getMinY() && y <= getMaxY() && x >= getMinX() && x <= getMaxX()) {
					int pixel = i.getRGB(x, y);
					
					// Decompose the pixel in the amounts of red, green, and blue.
					int redAmount = (pixel >> 16) & 0xff;
					int greenAmount = (pixel >> 8) & 0xff;
					int blueAmount = (pixel >> 0) & 0xff;
					
					int average = (redAmount + greenAmount + blueAmount)/3;
					
					// Compose the new pixel.
					int newPixel = (average << 16 ) | (average<< 8) | average;
					
					// Set the pixel of the new image.
					result.setRGB(x, y, newPixel);
				}
				else
					result.setRGB(x, y, i.getRGB(x, y));
			}
		
		return result;
	}

}
