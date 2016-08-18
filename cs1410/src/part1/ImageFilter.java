package part1;

import java.awt.image.BufferedImage;

/**
 * An interface that ensures all classes representing an image filter
 * implement the filter method as specified below.
 * 
 * @author Erin Parker
 */
public interface ImageFilter {
	
	public BufferedImage filter(BufferedImage i);

}
