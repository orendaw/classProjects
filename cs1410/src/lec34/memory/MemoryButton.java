package lec34.memory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * Represents a specific version of JButton for the Memory Game.
 * 
 * @author Erin Parker, last updated 4/13/16
 */
public class MemoryButton extends JButton {

	private int secretValue;
	private static final long serialVersionUID = 1L;
	
	public MemoryButton(int _secretValue) {
		super("?");
		secretValue = _secretValue;
		setFont(new Font("Dialog", Font.PLAIN, 24));
	}

	public void showValue() {
		setText("" + secretValue);
	}
	
	public void hideValue() {
		setText("?");
	}
	
	public int getValue() {
		return secretValue;
	}
	
	public void colorMe() {
		setBackground(Color.YELLOW);
		setOpaque(true);   
	}
}