package part3;

import java.awt.image.BufferedImage;

/**
 * This class provides a method to crop an image down to the selected region.
 * @author Orenda Williams
 *
 */

public class Crop extends ImageRegionFilter {

	public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(getMaxX() - getMinX(), getMaxY() - getMinY(), BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < i.getHeight(); y++)
			for(int x = 0; x < i.getWidth(); x++){
				if(y > getMinY() && y < getMaxY() && x > getMinX() && x < getMaxX())
					result.setRGB(x-getMinX(), y-getMinY(), i.getRGB(x, y));
			}
		return result;
	}
	
}