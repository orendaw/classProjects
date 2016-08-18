package part2;

import java.awt.image.BufferedImage;

/**
 * This filter applies a Sepia tone to an image.
 * Based on algorithm gotten from https://groups.google.com/forum/#!topic/comp.lang.java.programmer/nSCnLECxGdA
 * 
 * Description of algorithm:
 * -Convert image to grayscale (I applied B&W filter)
 * -Select a sepia depth (I hardcoded this to be 20 as recommended)
 * -then change red and green values of image so that red +=(sepiaDepth*2) and green+= sepiaDepth 
 * 
 * @author orend_000
 *
 */

public class SepiaFilter implements ImageFilter {
	
public BufferedImage filter(BufferedImage i) {
	
		// Select sepiaDepth
		int sepiaDepth = 20;
		
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		// Filter the image to B&W	
		ImageFilter	f = new BlackAndWhiteFilter();
		BufferedImage filteredImage = f.filter(i);	
	
		// For each pixel in the image . . . 
		for(int y = 0; y < filteredImage.getHeight(); y++)
			for(int x = 0; x < filteredImage.getWidth(); x++) {

				int pixel = filteredImage.getRGB(x, y);
				
				int redAmount = (pixel >> 16) & 0xff;
				int greenAmount = (pixel >> 8) & 0xff;
				int blueAmount = (pixel >> 0) & 0xff;
				
				redAmount += (sepiaDepth*2);
				greenAmount += sepiaDepth;
				
			    if (redAmount>255) 
			    	redAmount=255;
			    if (greenAmount>255) 
			    	greenAmount=255;
				
				// Compose the new pixel.
				int newPixel = (redAmount << 16 ) | (greenAmount << 8) | blueAmount;
				
				// Set the pixel of the new image.
				result.setRGB(x, y, newPixel);
			}
		
		return result;
	}

}
