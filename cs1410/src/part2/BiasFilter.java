package part2;

import java.awt.image.BufferedImage;

/**
 * Increases or decreases the brightness of an image by adding X to each 
 * color component.  
 *    X > 0 increases brightness.
 *    X < 0 decreases brightness.
 * 
 * @author Erin Parker, last updated 4/21/2016 by Orenda Williams
 */
public class BiasFilter implements ImageFilter {
	
	private int biasFilter = 50;
	
	/**
	 * Uses default bias = 50 to create BiasFilter.
	 */
	public BiasFilter(){
		biasFilter = 50;
	}
	
	/**
	 * Constructor for BiasFilter that allows user to select the amount of bias desired for filter to apply.
	 * @param biasFilter - amount of bias desired
	 */
	public BiasFilter(int biasFilter){
		this.biasFilter = biasFilter;
	}
	
	public BufferedImage filter(BufferedImage img) {
				
		BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < img.getHeight(); y++)
			for(int x = 0; x < img.getWidth(); x++) {

				int pixel = img.getRGB(x, y);
				int redAmount = (pixel >> 16) & 0xff;
				int greenAmount = (pixel >> 8) & 0xff;
				int blueAmount = (pixel >> 0) & 0xff;
				
				redAmount += biasFilter;
				if(redAmount > 255) {
					redAmount = 255;
				}
				if(redAmount < 0) {
					redAmount = 0;
				}
				
				greenAmount += biasFilter;
				if(greenAmount > 255) {
					greenAmount = 255;
				}
				if(greenAmount < 0) {
					greenAmount = 0;
				}
				
				blueAmount += biasFilter;
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