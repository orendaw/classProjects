package assign4;

import java.awt.*;

import java.awt.Color;

/**
 * This class uses graphics object and t parameter to draw an animation.
 * date : 2/11/2016
 * @author Orenda Williams
 *
 */

public class Animation {

	/**
	 * This method draws a spaceship fighting some asteroids.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param t
	 *            Number of milliseconds that have passed since animation
	 *            started
	 */
	public static void paintFrame(Graphics g, int t) {

		drawSky(g, 1000, 600, t);
		
		//Asteroid, lazer, and text drawings
		
		if(2000 <= t && t < 2350){
			drawLazer(g, 60 + (t-2000), 280, 1);
		}
		if(t < 2350){
			drawAsteroid(g, 1000 - t/4, 250, 1);
		}
		if(2345 <= t && t < 2700){
			g.setColor(Color.red);
			g.drawString("BOOM", 412, 250);
		}
		
		// 2nd asteroid
		
		if(4000 <=t && t < 9950){
			drawAsteroid(g, 1000 - (t-4000)/8, 100, 2);
		}
		if(5750 <=t && t < 6390){
			drawLazer(g, 60 + (t-5750), 150, 1);
		}
		if(6250 <=t && t < 6835){
			drawLazer(g, 60 + (t-6250), 160, 1);
		}
		if(7750 <=t && t < 8168){
			drawLazer(g, 60 + (t-7750), 150, 1);
		}
		if(8250 <=t && t < 8613){
			drawLazer(g, 60 + (t-8250), 160, 1);
		}
		if(9750 <=t && t < 9946){
			drawLazer(g, 60 + (t-9750), 155, 1);
		}
		if(9946 <= t && t < 10500){
			g.setFont(new Font("Arial", Font.BOLD, 30)); 
			g.setColor(Color.red);
			g.drawString("BOOM", 256, 150);
		}
		
		if(10500< t){
			g.setFont(new Font("Arial", Font.BOLD, 90));
			g.setColor(Color.orange);
			g.drawString("SUCCESS", 300, 300);
		}
		
		// UFO Drawings
		if(t < 2000) {
			if(t / 1000 % 2 == 0) {
				drawUFO(g, 0, 50 + t/10, 1);
			}
			else {
				drawUFOYellow(g, 0, 50 + t/10, 1);
			}
		}
		else if(2000 <= t && t < 4000) {
			if(t / 1000 % 2 == 0) {
				drawUFO(g, 0, 250 - (t - 2000) / 10, 1);
			}
			else {
				drawUFOYellow(g, 0, 250 - (t - 2000) / 10, 1);
			}
		}
		else if(4000 <= t && t < 5000){
			drawUFO(g, 0, 50 + (t - 4000)/5, 1);
		}
		else if(5000 <= t && t < 6000) {
			drawUFORed(g, 0, 250 - (t - 5000) / 5, 1);
		}
		else if(6000 <= t && t < 7000){
			drawUFORed(g, 0, 50 + (t - 6000)/5, 1);
		}
		else if(7000 <= t && t < 8000){
			drawUFORed(g, 0, 250 - (t - 7000) / 5, 1);
		}
		else if(8000 <= t && t < 9000){
			drawUFORed(g, 0, 50 + (t - 8000)/5, 1);
		}
		else if(9000 <= t && t < 10000) {
			drawUFORed(g, 0, 250 - (t - 9000) / 5, 1);
		}
		else{
			if(t / 1000 % 2 == 0) {
				drawUFO(g, 0, 50 + (t - 10000) / 5, 1);
			}
			else {
				drawUFOYellow(g, 0, 50 + (t - 10000) / 5, 1);
			}

		}
		
	}
	
	/**
	 * This methods draws a sky background with some flickering stars (they grow and shrink
	 * to create flicker effect)
	 * @param g - Graphics object.
	 * @param x - width of sky
	 * @param y - height of sky
	 * @param t - time parameter that is used to create flickering stars
	 */
	
	public static void drawSky(Graphics g, int x, int y, int t){
		Color skyblue = new Color(98, 99, 130);
		g.setColor(skyblue);
		g.fillRect(0, 0, x, y);
		
		g.setColor(Color.YELLOW);
        g.fillOval(x/2, y/3, (int)(4+Math.sin(t)*5), (int)(4+Math.sin(t)*5));
        g.fillOval(x/3, 2*y/3, (int)(6+Math.sin(t)*5), (int)(6+Math.sin(t)*5));
        g.fillOval(x/4, y/2, (int)(5+Math.sin(t)*5), (int)(5+Math.sin(t)*5));
        g.fillOval(x/5, y/4, (int)(3+Math.sin(t)*5), (int)(3+Math.sin(t)*5));
        g.fillOval(2*x/3, y/4, (int)(4+Math.sin(t)*5), (int)(4+Math.sin(t)*5));
        g.fillOval(3*x/5, 2*y/3, (int)(3+Math.sin(t)*5), (int)(3+Math.sin(t)*5));
        g.fillOval(3*x/8, y/8, (int)(3+Math.sin(t)*5), (int)(3+Math.sin(t)*5));
        g.setColor(Color.BLACK);

	}
	
	/**
	 * This method draws a UFO with an orange ship
	 * @param g - Graphics object
	 * @param posX - position of UFO in x
	 * @param posY - position of UFO in y
	 * @param size - size of UFO, can be a scalar int only.
	 */
	
	public static void drawUFO(Graphics g, double posX, double posY, int size){
		g.setColor(Color.gray);
		g.fillRect((int)posX+20*size, (int)posY+40*size, 50*size, 20*size);
		g.fillArc((int)posX+(5*size), (int)posY +(40*size+20*size) - (30*size), 80*size, 60*size, 180, 180);
		g.setColor(Color.orange);
		g.fillArc((int)posX+30*size, (int)posY+30*size, 30*size, 20*size, 180, -180);
		g.setColor(Color.darkGray);
		g.fillArc((int)posX+15*size, (int)posY+45*size, 10*size, 10*size, 90, 180);
		g.fillArc((int)posX+30*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.fillArc((int)posX+50*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.fillArc((int)posX+65*size, (int)posY+45*size, 10*size, 10*size, 90, -180);
		g.setColor(Color.red);
		g.fillArc((int)posX+(20*size)-3*size+(25*size), (int)(posY+30*size)- 11*size, 6*size, 6*size, 0, 360);
		
		g.setColor(Color.black);
		g.drawRect((int)posX+20*size, (int)posY+40*size, 50*size, 20*size);
		g.drawArc((int)posX+30*size, (int)posY+30*size, 30*size, 20*size, 180, -180);
		g.drawArc((int)posX+15*size, (int)posY+45*size, 10*size, 10*size, 90, 180);
		g.drawArc((int)posX+30*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.drawArc((int)posX+50*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.drawArc((int)posX+65*size, (int)posY+45*size, 10*size, 10*size, 90, -180);
		g.drawLine((int)posX+(5*size), (int)posY +(40*size+20*size), 85*size, (int)posY +(40*size+20*size));
		g.drawArc((int)posX+(5*size), (int)posY +(40*size+20*size) - (30*size), 80*size, 60*size, 180, 180);
		g.drawLine((int)posX+(20*size)+(25*size), (int)posY+30*size, (int)posX+(20*size)+(25*size), (int)(posY+30*size)- 5*size);
		g.drawArc((int)posX+(20*size)-3*size+(25*size), (int)(posY+30*size)- 11*size, 6*size, 6*size, 0, 360);
	}
	
	/**
	 * This method draws a UFO with a red ship
	 * @param g - Graphics object
	 * @param posX - position of UFO in x
	 * @param posY - position of UFO in y
	 * @param size - size of UFO, can be a scalar int only.
	 */
	public static void drawUFORed(Graphics g, double posX, double posY, int size){
		g.setColor(Color.gray);
		g.fillRect((int)posX+20*size, (int)posY+40*size, 50*size, 20*size);
		g.fillArc((int)posX+(5*size), (int)posY +(40*size+20*size) - (30*size), 80*size, 60*size, 180, 180);
		g.setColor(Color.red);
		g.fillArc((int)posX+30*size, (int)posY+30*size, 30*size, 20*size, 180, -180);
		g.setColor(Color.darkGray);
		g.fillArc((int)posX+15*size, (int)posY+45*size, 10*size, 10*size, 90, 180);
		g.fillArc((int)posX+30*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.fillArc((int)posX+50*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.fillArc((int)posX+65*size, (int)posY+45*size, 10*size, 10*size, 90, -180);
		g.setColor(Color.red);
		g.fillArc((int)posX+(20*size)-3*size+(25*size), (int)(posY+30*size)- 11*size, 6*size, 6*size, 0, 360);
		
		g.setColor(Color.black);
		g.drawRect((int)posX+20*size, (int)posY+40*size, 50*size, 20*size);
		g.drawArc((int)posX+30*size, (int)posY+30*size, 30*size, 20*size, 180, -180);
		g.drawArc((int)posX+15*size, (int)posY+45*size, 10*size, 10*size, 90, 180);
		g.drawArc((int)posX+30*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.drawArc((int)posX+50*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.drawArc((int)posX+65*size, (int)posY+45*size, 10*size, 10*size, 90, -180);
		g.drawLine((int)posX+(5*size), (int)posY +(40*size+20*size), 85*size, (int)posY +(40*size+20*size));
		g.drawArc((int)posX+(5*size), (int)posY +(40*size+20*size) - (30*size), 80*size, 60*size, 180, 180);
		g.drawLine((int)posX+(20*size)+(25*size), (int)posY+30*size, (int)posX+(20*size)+(25*size), (int)(posY+30*size)- 5*size);
		g.drawArc((int)posX+(20*size)-3*size+(25*size), (int)(posY+30*size)- 11*size, 6*size, 6*size, 0, 360);
	}
	
	/**
	 * This method draws a UFO with a yellow ship
	 * @param g - Graphics object
	 * @param posX - position of UFO in x
	 * @param posY - position of UFO in y
	 * @param size - size of UFO, can be a scalar int only.
	 */
	
	public static void drawUFOYellow(Graphics g, double posX, double posY, int size){
		g.setColor(Color.gray);
		g.fillRect((int)posX+20*size, (int)posY+40*size, 50*size, 20*size);
		g.fillArc((int)posX+(5*size), (int)posY +(40*size+20*size) - (30*size), 80*size, 60*size, 180, 180);
		g.setColor(Color.yellow);
		g.fillArc((int)posX+30*size, (int)posY+30*size, 30*size, 20*size, 180, -180);
		g.setColor(Color.darkGray);
		g.fillArc((int)posX+15*size, (int)posY+45*size, 10*size, 10*size, 90, 180);
		g.fillArc((int)posX+30*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.fillArc((int)posX+50*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.fillArc((int)posX+65*size, (int)posY+45*size, 10*size, 10*size, 90, -180);
		g.setColor(Color.red);
		g.fillArc((int)posX+(20*size)-3*size+(25*size), (int)(posY+30*size)- 11*size, 6*size, 6*size, 0, 360);
		
		g.setColor(Color.black);
		g.drawRect((int)posX+20*size, (int)posY+40*size, 50*size, 20*size);
		g.drawArc((int)posX+30*size, (int)posY+30*size, 30*size, 20*size, 180, -180);
		g.drawArc((int)posX+15*size, (int)posY+45*size, 10*size, 10*size, 90, 180);
		g.drawArc((int)posX+30*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.drawArc((int)posX+50*size, (int)posY+45*size, 10*size, 10*size, 0, 360);
		g.drawArc((int)posX+65*size, (int)posY+45*size, 10*size, 10*size, 90, -180);
		g.drawLine((int)posX+(5*size), (int)posY +(40*size+20*size), 85*size, (int)posY +(40*size+20*size));
		g.drawArc((int)posX+(5*size), (int)posY +(40*size+20*size) - (30*size), 80*size, 60*size, 180, 180);
		g.drawLine((int)posX+(20*size)+(25*size), (int)posY+30*size, (int)posX+(20*size)+(25*size), (int)(posY+30*size)- 5*size);
		g.drawArc((int)posX+(20*size)-3*size+(25*size), (int)(posY+30*size)- 11*size, 6*size, 6*size, 0, 360);
	}
	
	/**
	 * This method draws an asteroid.
	 * @param g - Graphics object
	 * @param posX - position of asteroid in x
	 * @param posY - position of asteroid in y
	 * @param size - size of asteroid, can be a scalar int only.
	 */
	
	public static void drawAsteroid(Graphics g, int x, int y, int size){
		Color body = new Color(56, 32, 4);
		Color crater = new Color(94, 53, 5);
		
		g.setColor(body);
		g.fillOval(x+10*size, y+10*size, 50*size, 50*size);
		g.setColor(crater);
		g.fillOval(x+15*size, y+15*size, 10*size, 10*size);
		g.fillOval(x+20*size, y+40*size, 5*size, 5*size);
		g.fillOval(x+40*size, y+25*size, 8*size, 8*size);
		g.fillOval(x+25*size, y+20*size, 2*size, 2*size);
		
	}
	
	/**
	 * This method draws a green lazer beam
	 * @param g - Graphics object
	 * @param posX - position of lazer in x
	 * @param posY - position of lazer in y
	 * @param size - size of lazer, can be a scalar int only.
	 */
	
	public static void drawLazer(Graphics g, int x, int y, int size){
		g.setColor(Color.green);
		g.fillRect(x, y, 20, 5);
	}
	
}
