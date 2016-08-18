package part1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 	This filter blurs an image lightly.
 * 
 * @author Orenda Williams, last updated 4/14/2016
 */
public class BlurFilter implements ImageFilter {

public BufferedImage filter(BufferedImage i) {
		
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);

		// For each pixel in the image . . . 
		for(int y = 0; y < i.getHeight(); y++)
			for(int x = 0; x < i.getWidth(); x++) {
				
				ArrayList<Integer> pixels = new ArrayList<Integer>();
				pixels.add(i.getRGB(x, y));
				for(int j = -1; j < 2; j++){
					for(int k = -1; k < 2; k++){
						try{
							pixels.add(i.getRGB(x + j, y + k));
						}
						catch(ArrayIndexOutOfBoundsException e){}
					}
				}
				
				int redAmount = 0;
				int greenAmount = 0;
				int blueAmount = 0;
				
				// Decompose the pixel in the amounts of red, green, and blue.
				for(int j = 0; j < pixels.size(); j++){
					redAmount += (pixels.get(j) >> 16) & 0xff;
					greenAmount += (pixels.get(j) >> 8) & 0xff;
					blueAmount += (pixels.get(j) >> 0) & 0xff;
				}
				
				// Compose the new pixel.
				int newPixel = (redAmount/pixels.size() << 16 ) | (greenAmount/pixels.size()<< 8) | blueAmount/pixels.size();
				
				// Set the pixel of the new image.
				result.setRGB(x, y, newPixel);
			}
		
		return result;
	}
}
