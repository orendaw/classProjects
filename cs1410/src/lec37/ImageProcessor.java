package lec37;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/** 
 * Image processing application.
 * Opens an image file, applies a filter to the image to generate a new image,
 * displays both images. 
 * 
 * @author Erin Parker, last updated 4/20/16
 */
public class ImageProcessor extends JFrame implements ActionListener {
	
	// Change this value as need to use a different image file.
	public static String filename = "/Users/orend_000/Desktop/pic.jpg";
	
	private BufferedImage origImage;   // original image
	private ImagePanel origPanel;      // panel containing original image
	private JMenuItem runFilter;       // menu it for running filter
	private JTabbedPane pane;          // pane containing both image panels
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) { 
		ImageProcessor ip = new ImageProcessor();
		ip.setVisible(true);
	}
	
	public ImageProcessor() {
				
		// Read the image file into a BufferedImage object.
		origImage = null;
		try {
			origImage = ImageIO.read(new File(filename));
		}
		catch(Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		
		// Add runFilter to menu
		runFilter = new JMenuItem("Run filter");
		runFilter.addActionListener(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(runFilter);		
		
		// Display the original image in a tabbed pane (filtered image to appear after filtering).
		pane = new JTabbedPane();
		origPanel = new ImagePanel(origImage);
		pane.add("Original image", origPanel);

		setJMenuBar(menuBar);
		add(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	/**
	 * This method is called to handle an event all components.
	 */
	public void actionPerformed(ActionEvent e) {
		// The only possible event is clicking the "Run Filter" menu item.
		
		// Filter the image.
		ImageRegionFilter f = new RedGreenSwapFilter();
		f.setRegion(origPanel.getSelectedRegion());
		BufferedImage filteredImage = f.filter(origImage);

		// Display filtered image, reusing second tab if it exists
		if(pane.getTabCount() > 1)
			pane.setComponentAt(1, new ImagePanel(filteredImage));
		else
			pane.add("Filtered image", new ImagePanel(filteredImage));
	}
}