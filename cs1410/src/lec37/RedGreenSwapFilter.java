package lec37;

import java.awt.image.BufferedImage;

/**
 * Represents an image filter that swaps the red amount and the green amount in 
 * each pixel.
 * 
 * HINT: This filter will still work for whole images (i.e., those without regions 
 * selected) by setting the Region2d to be the dimensions of the original image.
 * 
 * @author Erin Parker, last updated 4/20/16
 */
public class RedGreenSwapFilter extends ImageRegionFilter {

	public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);

		for(int y = 0; y < i.getHeight(); y++)
			for(int x = 0; x < i.getWidth(); x++) {

				if(y >= getMinY() && y <= getMaxY() && x >= getMinX() && x <= getMaxX()) {
				
					int pixel = i.getRGB(x, y);
					int redAmount = (pixel >> 16) & 0xff;
					int greenAmount = (pixel >> 8) & 0xff;
					int blueAmount = (pixel >> 0) & 0xff;
				
					int newPixel = (greenAmount << 16 ) | (redAmount << 8) | blueAmount;
					result.setRGB(x, y, newPixel);
				}
				else
					result.setRGB(x, y, i.getRGB(x, y));
			}
		
		return result;
	}
}