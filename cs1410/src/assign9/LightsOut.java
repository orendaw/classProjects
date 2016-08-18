package assign9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * This class represents a game of LightsOut. It is responsible for launching the GUI needed
 * to play the game.
 * @author Orenda Williams
 *
 */

public class LightsOut extends JFrame implements ActionListener{
	
	private LightsOutButton[][] buttons;
	private boolean playMode;
	private JLabel msgLabel;
	private int moves;
	private JButton random;
	private JButton manual;
	private JButton settings;
	private JPanel panel;
	private int rows;
	private int cols;
	private static LightsOut g;

	private static final long serialVersionUID = 1L;
	
	public LightsOut(){
		rows = 5;
		cols = 5;
		newGame(rows, cols, Color.yellow);
	}
	
	public LightsOut(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		newGame(rows, cols, Color.yellow);
	}
	
	public static void main(String[] args){
		g = new LightsOut();
		g.setVisible(true);
	}
	
	private void newGame(int _rows, int _cols, Color _c){
		
		
		// exit on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// create a container
		panel = new JPanel();
		panel.setLayout(new GridLayout(_rows, _cols));
		
		// set up moves and playMode variable
		moves = 0;
		playMode = true;
		
		// set up random button
		random = new JButton();
		random.setText("Randomize");
		random.addActionListener(this);
		
		// set up manual button
		manual = new JButton();
		manual.setText("Enter Manual Setup");
		manual.addActionListener(this);
		
		// set up settings
		settings = new JButton();
		settings.setText("Settings");
		settings.addActionListener(this);
		
		// set up label
		msgLabel = new JLabel("Turn off all the lights.", JLabel.CENTER);
		msgLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		// set up 2D array of buttons
		buttons = new LightsOutButton[_rows][_cols];
		for(int i = 0; i < _rows; i++){
			for(int j = 0; j < _cols; j++){
				buttons[i][j] = new LightsOutButton(i, j, _c);
				buttons[i][j].setOpaque(true);
				panel.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
				buttons[i][j].setFocusable(false);
			}
		}
		
		// set up JFrame to have all needed components
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(panel, BorderLayout.CENTER);
		panel2.add(msgLabel, BorderLayout.NORTH);
		JPanel panel3 = new JPanel();
		panel3.add(random);
		panel3.add(manual);
		panel3.add(settings);
		panel2.add(panel3, BorderLayout.SOUTH);
		
		panel = panel2;   
		setTitle("Lights Out!");
		setContentPane(panel);
		setPreferredSize(new Dimension(400, 450));
		pack();
	}

	public synchronized void actionPerformed(ActionEvent a) {
		
			if (a.getSource() == settings){
				
				LightsOutSettings box = new LightsOutSettings();
				LightsOutSettings.main(null);
				
				while(!(box.isReady() == false)){
					int[] changes = box.getResult();
					
					this.rows = changes[1];
					this.cols = changes[2];
					
					g = new LightsOut(rows, cols);
					
					if (changes[0] == 0)
						colorize(Color.yellow);
					if (changes[0] == 1)
						colorize(Color.pink);
					if (changes[0] == 2)
						colorize(Color.orange);
				}
			}
				
			
		
			else if (a.getSource() == random){
				randomize();
			}
			else if (a.getSource() == manual){
				
				if(manual.getText().equals("Enter Manual Setup")){
					manual.setText("Exit Manual Setup");
					playMode = false;	
				}
				else if(manual.getText().equals("Exit Manual Setup")){
					manual.setText("Enter Manual Setup");
					playMode = true;	
				}							
			}			
			else{
				if(playMode == true){
					moves++;
					
					LightsOutButton button = (LightsOutButton)a.getSource();
					msgLabel.setText("Current moves: " + moves);
					
					button.toggle();
					if (!(button.getRow()-1 < 0))
						buttons[button.getRow()-1][button.getCol()].toggle();
					if (!(button.getRow()+1 > 4))
						buttons[button.getRow()+1][button.getCol()].toggle();
					if (!(button.getCol()-1 < 0))
						buttons[button.getRow()][button.getCol()-1].toggle();
					if (!(button.getCol()+1 > 4))
						buttons[button.getRow()][button.getCol()+1].toggle();
					
					playMode = false;
					for(int i = 0; i < 5; i++){
						for(int j = 0; j < 5; j++){
							if(buttons[i][j].isOn()){
								playMode = true;
							}
						}
					}					
					if(playMode == false){
						JOptionPane.showMessageDialog(panel, "YOU WIN! It took you " + moves + " moves.");
					}
				}				
				else{
					LightsOutButton button = (LightsOutButton)a.getSource();
					button.toggle();
				}				
			}	
			
	}
	
	
	/**
	 * This methods randomizes the state of all buttons in the game.
	 */
	public void randomize(){
		Random rand = new Random();
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(rand.nextInt(2) == 0)
					buttons[i][j].toggle();
			}
		}
	}
	
	/**
	 * This method changes the color of the lit tiles in the game.
	 * @param newColor - color to change to
	 */
	public void colorize(Color newColor){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				buttons[i][j].setColor(newColor);
			}
		}
	}
	
	
	

}
