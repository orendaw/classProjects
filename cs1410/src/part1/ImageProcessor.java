package part1;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import lab12.ImagePanel;

/** 
 * Image processing application that has user select an image file of type .jpg, .jpeg, .png, .bmp, or .gif.
 * The user then selects the desired filter to apply to the image and then chooses desired save location.
 * Image will be automatically saved as a .jpg
 * @author Orenda Williams
 */
public class ImageProcessor {
	
	// Change these values as need to use different filters on different image files.
	public static String filename;

	public static void main(String[] args) {
		
		JFileChooser chooser = new JFileChooser();
		String[] exts = {"jpg", "jpeg", "png", "bmp", "gif"};
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter(filename, exts);
		chooser.setFileFilter(extFilter);
		int outcome = chooser.showOpenDialog(null);
		
		BufferedImage origImage = null;
		
		if(outcome == JFileChooser.APPROVE_OPTION) {
			
			File filename = chooser.getSelectedFile();
			
			// Read the image file into a BufferedImage object.
			try {
				origImage = ImageIO.read(filename);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				System.exit(0);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "The program will close.");
			System.exit(0);
		}
		
				
		ImageFilter	f = pickOption();
					
		// Filter the image.	
		
		BufferedImage filteredImage = f.filter(origImage);		
		
		// Save file as a .jpg to chosen location.
		File saveFile;
		JFileChooser saveChooser = new JFileChooser();
		FileNameExtensionFilter extFilter2 = new FileNameExtensionFilter("jpg", exts);
		saveChooser.setFileFilter(extFilter2);
		int n = saveChooser.showSaveDialog(saveChooser);
		
		if(n == JFileChooser.CANCEL_OPTION || n == JFileChooser.ERROR_OPTION){
			JOptionPane.showMessageDialog(null, "The program will close.");
			System.exit(0);
		}
		
		saveFile = new File(saveChooser.getSelectedFile().toString() + ".jpg");
		
		try {
			ImageIO.write(filteredImage, "jpg", saveFile);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		JTabbedPane pane = new JTabbedPane();
		pane.add("Original image", new ImagePanel(origImage));
		pane.add("Filtered image", new ImagePanel(filteredImage));

		JFrame filteredImgFrame = new JFrame();
		filteredImgFrame.add(pane);
		filteredImgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		filteredImgFrame.pack();
		filteredImgFrame.setVisible(true);
		
	}
	
	/**
	 * This method opens up the pop up for filter selection and returns the user's choice.
	 * @return ImageFilter that user picked
	 */
	
	private static ImageFilter pickOption(){
		
		// Set up buttons for filter selection.
		JRadioButton maxGreenFilter = new JRadioButton("Maximize Green", false);
		JRadioButton bwFilter = new JRadioButton("Black and White", false);
		JRadioButton rgSwap = new JRadioButton("Swap red-green", false);
		JRadioButton gbSwap = new JRadioButton("Swap green-blue", false);
		JRadioButton rbSwap = new JRadioButton("Swap red-blue", false);
		JRadioButton biasFilter = new JRadioButton("Bias", false);
		JRadioButton blurFilter = new JRadioButton("Blur", false);
		JRadioButton rotateCW = new JRadioButton("Rotate Clockwise", false);
		JRadioButton rotateCCW = new JRadioButton("Rotate CounterCW", false);
		JRadioButton gainFilter = new JRadioButton("Gain", false);
		JRadioButton pixelFilter = new JRadioButton("Pixelate", false);
		JRadioButton sepiaFilter = new JRadioButton("Sepia", false);
		
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(maxGreenFilter);
		buttons.add(bwFilter);
		buttons.add(rgSwap);
		buttons.add(gbSwap);
		buttons.add(rbSwap);
		buttons.add(biasFilter);
		buttons.add(blurFilter);
		buttons.add(rotateCW);
		buttons.add(rotateCCW);
		buttons.add(gainFilter);
		buttons.add(pixelFilter);
		buttons.add(sepiaFilter);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(3, 4));
		radioPanel.add(maxGreenFilter);
		radioPanel.add(bwFilter);
		radioPanel.add(rgSwap);
		radioPanel.add(gbSwap);
		radioPanel.add(rbSwap);
		radioPanel.add(biasFilter);
		radioPanel.add(blurFilter);
		radioPanel.add(rotateCW);
		radioPanel.add(rotateCCW);
		radioPanel.add(gainFilter);
		radioPanel.add(pixelFilter);
		radioPanel.add(sepiaFilter);
		
		ImageFilter f = null;
		
		int n = JOptionPane.showOptionDialog(null, radioPanel, "Select Filter", JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.QUESTION_MESSAGE, null, null, null);
		
		if (n == -1){
			JOptionPane.showMessageDialog(null, "The program will close.");
			System.exit(0);
		}
		
		if(maxGreenFilter.isSelected())
			f = new MaximizeGreenFilter();
		else if(rgSwap.isSelected())  			
			f = new RedGreenSwapFilter();
		else if(rbSwap.isSelected())
			f = new RedBlueSwapFilter();
		else if(gbSwap.isSelected())
			f = new GreenBlueSwapFilter();
		else if(bwFilter.isSelected())
			f = new BlackAndWhiteFilter();
		else if(blurFilter.isSelected())
			f = new BlurFilter();
		else if(rotateCW.isSelected())
			f = new RotateClockwiseFilter();
		else if(rotateCCW.isSelected())
			f = new RotateCounterClockwiseFilter();
		else if(gainFilter.isSelected())
			f = new GainFilter();
		else if(biasFilter.isSelected())
			f = new BiasFilter();
		else if(pixelFilter.isSelected())
			f = new PixelateFilter();
		else if(sepiaFilter.isSelected())
			f = new SepiaFilter();
		
		if(f == null){
			JOptionPane.showMessageDialog(null, "Please select an option.");
			f = pickOption();
		}
		
		return f;
	}
}

