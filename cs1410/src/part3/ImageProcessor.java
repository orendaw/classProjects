package part3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


/** 
 * Image processing application that has user select an image file of type .jpg, .jpeg, .png, .bmp, or .gif.
 * The user then selects the desired filter to apply to the image and then chooses desired save location.
 * Image will be automatically saved as a .jpg
 * @author Orenda Williams
 */
public class ImageProcessor extends JFrame implements ActionListener, ChangeListener{
	

	private static final long serialVersionUID = 1L;

	public static String filename;
	
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JMenuItem open;
	private JMenuItem save;
	private JCheckBoxMenuItem cumulative;
	
	private ImagePanel origPanel;
	private BufferedImage origImage;
	private BufferedImage filteredImage;
	private ImageRegionFilter f;

	private ArrayList<FilterButton> buttonArray;
	private ButtonGroup buttons;
	private FilterButton biasFilter;
	private FilterButton blurFilter;
	private FilterButton gainFilter;
	private JPanel radioPanel;
	
	private JButton crop;
	
	private FilterSlider biasSlider;
	private FilterSlider gainSlider;
	private FilterSlider blurSlider;
	private JPanel sliderPanel;
	
	private JTabbedPane pane;
	
	public static void main(String[] args) {
		ImageProcessor frame = new ImageProcessor();
		frame.setVisible(true);		
	}
	
	public ImageProcessor(){
		origImage = null;
		
		pane = new JTabbedPane();
		
		// set up panels and JMenuBar
		menuBar = createMenuBar();
		radioPanel = createButtonPanel();
		sliderPanel = createSliderPanel();
		radioPanel.setVisible(false);
		sliderPanel.setVisible(false);
		
		crop = new JButton("Crop Image");
		crop.addActionListener(this);
		crop.setVisible(false);
		
		// set up frame
		setJMenuBar(menuBar);
		add(pane, BorderLayout.NORTH);
		add(radioPanel, BorderLayout.CENTER);
		add(sliderPanel, BorderLayout.EAST);
		add(crop, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
	}
	
	/**
	 * This method detects and responds to all ActionEvents (from buttons and menu)
	 */
	public void actionPerformed(ActionEvent a) {
		
		String[] exts = {"jpg", "jpeg", "png", "bmp", "gif"};
		
		if(a.getSource() == open){
	    	JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter extFilter = new FileNameExtensionFilter(filename, exts);
			chooser.setFileFilter(extFilter);
			int outcome = chooser.showOpenDialog(null);
			
			if(outcome == JFileChooser.APPROVE_OPTION) {			
				try {
					origImage = ImageIO.read(chooser.getSelectedFile());
					origPanel = new ImagePanel(origImage);
					
					if(pane.getTabCount() >= 1){
						pane.setComponentAt(0, origPanel);
						pane.setPreferredSize(new Dimension(origImage.getWidth(), origImage.getHeight()));
						if(pane.getTabCount() > 1)
							pane.remove(1);
					}
					else{
						pane.add("Original image", origPanel);
						pane.setPreferredSize(new Dimension(origImage.getWidth(), origImage.getHeight()));
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					System.exit(0);
				}
				radioPanel.setVisible(true);
				cumulative.setVisible(true);
				this.pack();
			}
		}
		else if(a.getSource() == save){
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
		}
		
		else if(a.getSource() == cumulative){
			for(int i = 0; i < buttonArray.size(); i++){
				if(cumulative.isSelected())				
					buttons.remove(buttonArray.get(i));
				else
					buttons.add(buttonArray.get(i));
			}
		}
		
		else if(a.getSource() == crop){
			f = new Crop();
			f.setRegion(origPanel.getSelectedRegion());
			origImage = f.filter(origImage);
			origPanel = new ImagePanel(origImage);
			
			applyFilters(); 
			
			if(pane.getTabCount() > 1){
				pane.setComponentAt(0, origPanel);
				pane.setComponentAt(1, new ImagePanel(filteredImage));
			}
			else{
				pane.setComponentAt(0, origPanel);
				pane.add("Filtered image", new ImagePanel(filteredImage));
				save.setVisible(true);
			}
			pane.setSelectedIndex(1);
		}

		else{
			
			
			if(gainFilter.isSelected() || blurFilter.isSelected()|| biasFilter.isSelected()){
				
				sliderPanel.setVisible(true);
				
				if(!blurFilter.isSelected()){
					blurSlider.reset();
				}
				if(!gainFilter.isSelected()){
					gainSlider.reset();
				}
				if(!biasFilter.isSelected()){
					biasSlider.reset();
				}
			}
			else
				sliderPanel.setVisible(false);
			
			applyFilters();
			
			if(pane.getTabCount() > 1)
				pane.setComponentAt(1, new ImagePanel(filteredImage));
			else{
				pane.add("Filtered image", new ImagePanel(filteredImage));
				save.setVisible(true);
			}
			pane.setSelectedIndex(1);
		}
		this.pack();
	}
	
	public void mouseEvent(MouseEvent e){
		crop.setVisible(origPanel.isRegionActive());
	}

	/**
	 * This method detects ChangeEvents for all the sliders (blur, bias, and gain).
	 */
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider)e.getSource();
		
		if(src == gainSlider){
			if(!src.getValueIsAdjusting()){
				gainFilter.setFilter(new GainFilter((double)src.getValue()*.25));
			}
		}
		else if(src == biasSlider){
			if(!src.getValueIsAdjusting()){
				biasFilter.setFilter(new BiasFilter((int)src.getValue()));
			}
		}
		else if(src == blurSlider){
			if(!src.getValueIsAdjusting()){
				blurFilter.setFilter(new BlurFilter((int)src.getValue()));
			}
		}
			try{
				applyFilters();
				pane.setComponentAt(1, new ImagePanel(filteredImage));
			}
			catch(NullPointerException ex){}
				
		
}
	
	private void applyFilters() {

		crop.setVisible(origPanel.isRegionActive());

		filteredImage = origImage;
		
		for(int i = 0; i < buttonArray.size(); i++){
			if(buttonArray.get(i).isSelected()){
				if(buttonArray.get(i).getFilter() instanceof ImageRegionFilter){
					f = (ImageRegionFilter) buttonArray.get(i).getFilter();
					f.setRegion(origPanel.getSelectedRegion());		
					filteredImage = f.filter(filteredImage);
				}
				else
					filteredImage = buttonArray.get(i).getFilter().filter(filteredImage);
				
			}
		}
	}
	
	/**
	 * This method returns a JPanel with all the needed filter choice buttons on it.
	 * @return JPanel with all radio buttons for filter choices
	 */
	public JPanel createButtonPanel(){
		
		buttonArray = new ArrayList<FilterButton>();
		
		FilterButton maxGreenFilter = new FilterButton("Maximize Green", 
				"This filter increases the green value in all pixels of the image to the maximum value.", 
				new MaximizeGreenFilter());
		FilterButton bwFilter = new FilterButton("Black and White", 
				"This filter turns an image into a Black/White image.", 
				new BlackAndWhiteFilter());
		FilterButton rgSwap = new FilterButton("Swap red-green", 
				"This filter swaps the red and green color values of each pixel in the image.", 
				new RedGreenSwapFilter());
		FilterButton gbSwap = new FilterButton("Swap green-blue", 
				"This filter swaps the green and blue color values of each pixel in the image.",
				new GreenBlueSwapFilter());
		FilterButton rbSwap = new FilterButton("Swap red-blue", 
				"This filter swaps the red and blue color values of each pixel in the image.",
				new RedBlueSwapFilter());
		biasFilter = new FilterButton("Bias", 
				"This filter increases/decreases the bias (brightness) of the image based on your selection.",
				new BiasFilter());
		blurFilter = new FilterButton("Blur", 
				"This filter blurs the image to the value you select.",
				new BlurFilter());
		FilterButton rotateCW = new FilterButton("Rotate Clockwise", 
				"This filter rotates an image Clockwise.",
				new RotateClockwiseFilter());
		FilterButton rotateCCW = new FilterButton("Rotate CounterCW", 
				"This filter rotates an image Counter Clockwise.",
				new RotateCounterClockwiseFilter());
		gainFilter = new FilterButton("Gain", 
				"This filter increases/decreases the gain (saturation) of the image based on your selection.",
				new GainFilter());
		FilterButton pixelFilter = new FilterButton("Pixelate", 
				"This filter pixelates the image.",
				new PixelateFilter());
		FilterButton sepiaFilter = new FilterButton("Sepia", 
				"This filter applies a Sepia overtone to the image.",
				new SepiaFilter());

		buttonArray.add(pixelFilter);
		buttonArray.add(maxGreenFilter);
		buttonArray.add(bwFilter);
		buttonArray.add(rgSwap);
		buttonArray.add(gbSwap);
		buttonArray.add(rbSwap);
		buttonArray.add(biasFilter);
		buttonArray.add(blurFilter);
		buttonArray.add(gainFilter);
		buttonArray.add(sepiaFilter);
		buttonArray.add(rotateCW);
		buttonArray.add(rotateCCW);
		
		buttons = new ButtonGroup();
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(4, 3));
		for(int i = 0; i < buttonArray.size(); i++){
			buttonArray.get(i).addActionListener(this);
			buttons.add(buttonArray.get(i));
			radioPanel.add(buttonArray.get(i));
		}
		return radioPanel;
	}

	/**
	 * This method creates a JPanel containing sliders for bias, gain, and blur filters.
	 * @return JPanel containing sliders
	 */
	public JPanel createSliderPanel(){
		
		JPanel sliderPanel = new JPanel();
		biasSlider = new FilterSlider(-200, 200, 50, 
				"Use the slider to select the amount of brightness you want in the image.", 
				100, 50, biasFilter, new JLabel("Bias : "));
		biasSlider.addChangeListener(this);		
		
		gainSlider = new FilterSlider(2, 8, 6, 
				"Use the slider to select the amount of gain you want in the image.", 
				0, 0, gainFilter, new JLabel("Gain : "));
		gainSlider.addChangeListener(this);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(2, new JLabel("0.5"));
		labelTable.put(3, new JLabel("0.75"));
		labelTable.put(5, new JLabel("1.25"));
		labelTable.put(6, new JLabel("1.5"));
		labelTable.put(7, new JLabel("1.75"));
		labelTable.put(8, new JLabel("2.0"));
		gainSlider.setLabelTable(labelTable);	
		
		blurSlider = new FilterSlider(3, 9, 3, 
				"Use the slider to select the amount of blur you want in the image.", 
				3, 1, blurFilter, new JLabel("Blur : "));
		blurSlider.addChangeListener(this);
		
		sliderPanel.setLayout(new GridLayout(3, 2));
		sliderPanel.add(biasSlider.getLabel());
		sliderPanel.add(biasSlider);
		sliderPanel.add(gainSlider.getLabel());
		sliderPanel.add(gainSlider);
		sliderPanel.add(blurSlider.getLabel());
		sliderPanel.add(blurSlider);
		
		return sliderPanel;
	}
	
	/**
	 * This method creates a JMenuBar containing open/save options.
	 * @return JMenuBar containing open/save items
	 */
	public JMenuBar createMenuBar(){
		fileMenu = new JMenu("File");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		cumulative = new JCheckBoxMenuItem("Cumulative effect");
		open.addActionListener(this);
		save.addActionListener(this);
		cumulative.addActionListener(this);
		save.setVisible(false);
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(cumulative);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		
		return menuBar;
	}

}



