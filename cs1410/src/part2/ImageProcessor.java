package part2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
public class ImageProcessor extends JFrame implements ActionListener, ChangeListener {
	

	private static final long serialVersionUID = 1L;

	// Change these values as need to use different filters on different image files.
	public static String filename;
	
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JMenuItem open;
	private JMenuItem save;
	
	private BufferedImage origImage;
	private BufferedImage filteredImage;
	private ImageFilter f;

	private ButtonGroup buttons;
	private JRadioButton maxGreenFilter;
	private JRadioButton bwFilter;
	private JRadioButton rgSwap;
	private JRadioButton gbSwap;
	private JRadioButton rbSwap;
	private JRadioButton biasFilter;
	private JRadioButton blurFilter;
	private JRadioButton rotateCW;
	private JRadioButton rotateCCW;
	private JRadioButton gainFilter;
	private JRadioButton pixelFilter;
	private JRadioButton sepiaFilter;
	private JPanel radioPanel;
	
	private JSlider biasSlider;
	private JSlider gainSlider;
	private JSlider blurSlider;
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
		radioPanel.add(sliderPanel, BorderLayout.EAST);
				
		// set up frame
		setJMenuBar(menuBar);
		add(pane, BorderLayout.CENTER);
		radioPanel.setVisible(false);
		add(radioPanel, BorderLayout.SOUTH);
		sliderPanel.setVisible(false);
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
					
					if(pane.getTabCount() >= 1){
						pane.setComponentAt(0, new ImagePanel(origImage));
						pane.setPreferredSize(new Dimension(origImage.getWidth(), origImage.getHeight()));
						if(pane.getTabCount() > 1)
							pane.remove(1);
					}
					else{
						pane.add("Original image", new ImagePanel(origImage));
						pane.setPreferredSize(new Dimension(origImage.getWidth(), origImage.getHeight()));
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					System.exit(0);
				}
				radioPanel.setVisible(true);
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

		else{
			
			if(gainFilter.isSelected() || blurFilter.isSelected() || biasFilter.isSelected()){
				blurSlider.setVisible(false);
				gainSlider.setVisible(false);
				biasSlider.setVisible(false);
				sliderPanel.setVisible(true);
				
				if(blurFilter.isSelected()){
					f = new BlurFilter();
					blurSlider.setVisible(true);
				}
				else if(gainFilter.isSelected()){
					f = new GainFilter();
					gainSlider.setVisible(true);
				}
				else if(biasFilter.isSelected()){
					f = new BiasFilter();
					biasSlider.setVisible(true);
				}
			}
			else
				sliderPanel.setVisible(false);
			
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
			else if(rotateCW.isSelected())
				f = new RotateClockwiseFilter();
			else if(rotateCCW.isSelected())
				f = new RotateCounterClockwiseFilter();
			else if(pixelFilter.isSelected())
				f = new PixelateFilter();
			else if(sepiaFilter.isSelected())
				f = new SepiaFilter();
			
			filteredImage = f.filter(origImage);
			
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

	/**
	 * This method detects ChangeEvents for all the sliders (blur, bias, and gain).
	 */
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider)e.getSource();
		
		if(src == gainSlider){
			if(!src.getValueIsAdjusting()){
				int val = (int)src.getValue();
				double gainAmount = val*.25;
				f = new GainFilter(gainAmount);
			}
		}
		else if(src == biasSlider){
			if(!src.getValueIsAdjusting()){
				int biasAmount = (int)src.getValue();
				f = new BiasFilter(biasAmount);
			}
		}
		else if(src == blurSlider){
			if(!src.getValueIsAdjusting()){
				int blurAmount = (int)src.getValue();
				f = new BlurFilter(blurAmount);
			}
		}

		pane.setComponentAt(1, new ImagePanel(f.filter(origImage)));
	}
	
	/**
	 * This method returns a JPanel with all the needed filter choice buttons on it.
	 * @return JPanel with all radio buttons for filter choices
	 */
	public JPanel createButtonPanel(){
		
		maxGreenFilter = new JRadioButton("Maximize Green", false);
		maxGreenFilter.addActionListener(this);
		maxGreenFilter.setToolTipText("This filter increases the green value in all pixels of the image to the maximum value.");
		bwFilter = new JRadioButton("Black and White", false);
		bwFilter.setToolTipText("This filter turns an image into a Black/White image.");
		bwFilter.addActionListener(this);
		rgSwap = new JRadioButton("Swap red-green", false);
		rgSwap.setToolTipText("This filter swaps the red and green color values of each pixel in the image.");
		rgSwap.addActionListener(this);
		gbSwap = new JRadioButton("Swap green-blue", false);
		gbSwap.addActionListener(this);
		gbSwap.setToolTipText("This filter swaps the green and blue color values of each pixel in the image.");
		rbSwap = new JRadioButton("Swap red-blue", false);
		rbSwap.addActionListener(this);
		rbSwap.setToolTipText("This filter swaps the red and blue color values of each pixel in the image.");
		biasFilter = new JRadioButton("Bias", false);
		biasFilter.addActionListener(this);
		biasFilter.setToolTipText("This filter increases/decreases the bias (brightness) of the image based on your selection."); 
		blurFilter = new JRadioButton("Blur", false);
		blurFilter.addActionListener(this);
		blurFilter.setToolTipText("This filter blurs the image to the value you select.");
		rotateCW = new JRadioButton("Rotate Clockwise", false);
		rotateCW.addActionListener(this);
		rotateCW.setToolTipText("This filter rotates an image Clockwise.");
		rotateCCW = new JRadioButton("Rotate CounterCW", false);
		rotateCCW.addActionListener(this);
		rotateCCW.setToolTipText("This filter rotates an image Counter Clockwise.");
		gainFilter = new JRadioButton("Gain", false);
		gainFilter.addActionListener(this);
		gainFilter.setToolTipText("This filter increases/decreases the gain (saturation) of the image based on your selection.");
		pixelFilter = new JRadioButton("Pixelate", false);
		pixelFilter.addActionListener(this);
		pixelFilter.setToolTipText("This filter pixelates the image.");
		sepiaFilter = new JRadioButton("Sepia", false);
		sepiaFilter.addActionListener(this);
		sepiaFilter.setToolTipText("This filter applies a Sepia overtone to the image.");
		
		buttons = new ButtonGroup();
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
		radioPanel.setLayout(new GridLayout(4, 3));
		radioPanel.add(maxGreenFilter);
		radioPanel.add(bwFilter);
		radioPanel.add(rgSwap);
		radioPanel.add(gbSwap);
		radioPanel.add(rbSwap);
		radioPanel.add(rotateCW);
		radioPanel.add(rotateCCW);
		radioPanel.add(pixelFilter);
		radioPanel.add(sepiaFilter);
		radioPanel.add(gainFilter);
		radioPanel.add(biasFilter);
		radioPanel.add(blurFilter);
		
		return radioPanel;
	}

	/**
	 * This method creates a JPanel containing sliders for bias, gain, and blur filters.
	 * @return JPanel containing sliders
	 */
	public JPanel createSliderPanel(){
		JPanel sliderPanel = new JPanel();
		biasSlider = new JSlider(-200, 200, 50);
		biasSlider.setToolTipText("Use the slider to select the amount of brightness you want in the image.");
		biasSlider.addChangeListener(this);
		biasSlider.setMajorTickSpacing(100);
		biasSlider.setMinorTickSpacing(50);
		biasSlider.setPaintLabels(true);
		biasSlider.setPaintTicks(true);
		biasSlider.setVisible(false);
		sliderPanel.add(biasSlider);
		
		gainSlider = new JSlider(2, 8, 6);
		gainSlider.setToolTipText("Use the slider to select the amount of gain you want in the image.");
		gainSlider.setVisible(false);
		gainSlider.addChangeListener(this);
		gainSlider.setMajorTickSpacing(2);
		gainSlider.setMinorTickSpacing(1);
		gainSlider.setPaintTicks(true);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(2, new JLabel("0.5"));
		labelTable.put(3, new JLabel("0.75"));
		// skip gain factor 1.0, since that produces an image the same as the original
		labelTable.put(5, new JLabel("1.25"));
		labelTable.put(6, new JLabel("1.5"));
		labelTable.put(7, new JLabel("1.75"));
		labelTable.put(8, new JLabel("2.0"));
		gainSlider.setLabelTable(labelTable);
		gainSlider.setPaintLabels(true);
		sliderPanel.add(gainSlider);
		
		blurSlider = new JSlider(3, 9, 3);
		blurSlider.setVisible(false);
		blurSlider.setToolTipText("Use the slider to select the amount of blur you want in the image.");
		blurSlider.addChangeListener(this);
		blurSlider.setMajorTickSpacing(3);
		blurSlider.setMinorTickSpacing(1);
		blurSlider.setPaintTicks(true);
		blurSlider.setPaintLabels(true);
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
		open.addActionListener(this);
		save.addActionListener(this);
		save.setVisible(false);
		fileMenu.add(open);
		fileMenu.add(save);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		
		return menuBar;
	}
}


