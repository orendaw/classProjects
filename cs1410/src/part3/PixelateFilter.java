package part3;

import java.awt.image.BufferedImage;

/**
 * 	Filter pixelates an image.
 * 
 * @author Orenda Williams, last updated 4/14/2016
 */

public class PixelateFilter extends ImageRegionFilter {
	
	private int pixSize;
	
	public BufferedImage filter(BufferedImage i) {
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		// choose pixelation size.
		
		pixSize = 10;

		// For each pixel in the image . . . 
		for(int y = 0; y < i.getHeight(); y+= pixSize)
			for(int x = 0; x < i.getWidth(); x+= pixSize) {
				
				int pixel = i.getRGB(x, y);
				
				// Set the surrounding pixels of the new image.
			       for(int k = y; (k < y + pixSize) && (k < result.getHeight()); k++) {
			            for(int j = x; (j < x + pixSize) && (j < result.getWidth()); j++) {
			            	result.setRGB(j, k, pixel);
			            }
			        }
			}
		
		for(int y = 0; y < i.getHeight(); y++)
			for(int x = 0; x < i.getWidth(); x++){
				if(!(y >= getMinY() && y <= getMaxY() && x >= getMinX() && x <= getMaxX())) {
					result.setRGB(x, y, i.getRGB(x, y));
				}
			}
		
		return result;
	}

}
