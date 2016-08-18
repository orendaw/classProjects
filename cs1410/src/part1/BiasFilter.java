package part1;

import java.awt.image.BufferedImage;

/**
 * Increases or decreases the brightness of an image by adding X to each 
 * color component.  
 *    X > 0 increases brightness.
 *    X < 0 decreases brightness.
 * 
 * @author Erin Parker, last updated 4/14/2016 by Orenda Williams
 */
public class BiasFilter implements ImageFilter {
	
	private int X = 50;
	
	public BufferedImage filter(BufferedImage img) {
				
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < img.getHeight(); y++)
			for(int x = 0; x < img.getWidth(); x++) {

				int pixel = img.getRGB(x, y);
				int redAmount = (pixel >> 16) & 0xff;
				int greenAmount = (pixel >> 8) & 0xff;
				int blueAmount = (pixel >> 0) & 0xff;
				
				redAmount += X;
				if(redAmount > 255) {
					redAmount = 255;
				}
				if(redAmount < 0) {
					redAmount = 0;
				}
				
				greenAmount += X;
				if(greenAmount > 255) {
					greenAmount = 255;
				}
				if(greenAmount < 0) {
					greenAmount = 0;
				}
				
				blueAmount += X;
				if(blueAmount > 255) {
					blueAmount = 255;
				}
				if(blueAmount < 0) {
					blueAmount = 0;
				}
				
				int newPixel = (redAmount << 16 ) | (greenAmount << 8) | blueAmount;
				result.setRGB(x, y, newPixel);
			}
		
		return result;
	}
}