package part3;

import javax.swing.JRadioButton;

/**
 * This class represents a JRadioButton that has been modified to require and associated ImageFilter
 * and for the user to set a ToolTextTip when instantiating.
 * @author Orenda Williams
 *
 */
public class FilterButton extends JRadioButton {
	
	private static final long serialVersionUID = 1L;
	
	private ImageFilter filter;
	
	/**
	 * Creates a JRadioButton that has an associated ImageFilter
	 * (also requires a ToolTextTip to be added).
	 * @param title - text desired to be title of JRadioButton
	 * @param tipText - ToolTipText to be added
	 * @param filter - associated ImageFilter
	 */
	public FilterButton(String title, String tipText, ImageFilter filter){
		super(title);
		this.setToolTipText(tipText);
		this.filter = filter;
	}
	
	public ImageFilter getFilter(){
		return filter;
	}
	
	public void setFilter(ImageFilter filter){
		this.filter = filter;		
	}
}
