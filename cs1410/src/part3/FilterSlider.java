package part3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * This class extends the JSlider class.
 * Its purpose is to force user to select values for
 * some of the JSlider features (min, max, starter value, 
 * major/minor ticks, and ToolTipText) and also
 * associates a JLabel and a FilterButton to the slider.
 * @author Orenda Williams
 *
 */
public class FilterSlider extends JSlider implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private int start;
	private JLabel label;
	private FilterButton button;
	
	public FilterSlider(int min, int max, int start, String tipText, 
			int major, int minor, FilterButton button, JLabel label){
		
		super(min, max, start);
		this.setToolTipText(tipText);
		this.setMajorTickSpacing(major);
		this.setMinorTickSpacing(minor);
		this.setPaintLabels(true);
		this.setPaintTicks(true);
		this.setVisible(false);
		this.button = button;
		this.start = start;
		this.label = label;
		this.label.setVisible(false);
		
		button.addActionListener(this);
		
	}

	/**
	 * This method resets the sliders value to the starter value from
	 * when the slider was initialized; it also sets
	 * the associated JLabel and the slider itself to not be visible.
	 */
	public void reset(){
		this.setValue(start);
		this.getLabel().setVisible(false);
		this.setVisible(false);
	}
	
	/**
	 * Returns the associated JLabel
	 * @return JLabel associated with this slider
	 */
	public JLabel getLabel(){
		return label;
	}

	/**
	 * Sets the associated JLabel and this slider to be visible when
	 * the associated FilterButton is selected.
	 * @param a - actionEvent related to FilterButton
	 */
	public void actionPerformed(ActionEvent a) {
		if(button.isSelected()){
			label.setVisible(true);
			this.setVisible(true);
		}
	}
}
