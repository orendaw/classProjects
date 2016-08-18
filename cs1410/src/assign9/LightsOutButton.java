package assign9;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

/**
 * This class implements a LightsOutButton for use in the LightsOut class. It classifies 
 * each button to be on or off and randomizes the initial state of each button.
 * @author Orenda Williams
 *
 */

public class LightsOutButton extends JButton {

	private int row;
	private int col;
	private int status;
	private Color c;
	
	private static final long serialVersionUID = 1L;
	
	public LightsOutButton(int row, int col, Color c){
		
		this.row = row;
		this.col = col;
		this.c = c;
		Random rand = new Random();
		status = rand.nextInt(2);
		if (status == 1){
			this.setBackground(c);
			this.setText("( ! )");
		}
		else{
			status = 0;
			this.setBackground(Color.white);
			this.setText(" ");
		}
	}
	
	/**
	 * This method reverses the current status of this LightsOutButton. 
	 * If the button status is on (1), it will go off (0).
	 * If the button status is off, it will go on.
	 */
	public void toggle() {
		
		if(status == 0){
			status = 1;
			this.setBackground(c);
			this.setText("( ! )");
		}
		else{
			status = 0;
			this.setBackground(Color.white);
			this.setText(" ");
		}
	}
	
	/**
	 * Getter method for row of this button.
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * Getter method for column of this button.
	 */
	public int getCol(){
		return col;
	}
	
	/**
	 * This method returns a boolean describing if this button is currently on.
	 */
	public boolean isOn(){
		if(status == 1)
			return true;
		else
			return false;
	}
	
	public void setColor(Color c){
		this.c = c;
		if(status == 1)
			this.setBackground(c);
	}

}
