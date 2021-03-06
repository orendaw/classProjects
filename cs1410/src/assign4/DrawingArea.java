package assign4;

import java.awt.*;
import javax.swing.*;

/**
 * Represents an area where animated graphics can be drawn.
 */
public class DrawingArea extends JPanel {

	// Number of milliseconds that have elapsed since the
	// animation was started
	private int time = 0;

	/**
	 * Increases the elapsed time by delta milliseconds.
	 */
	public void tick(int delta) {
		synchronized (this) {
			time += delta;
		}
	}

	/**
	 * Resets elapsed time to zero
	 */
	public void clearTimer() {
		synchronized (this) {
			time = 0;
		}
	}

	/**
	 * Paints the display area to the screen.
	 */
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		int ticks;
		synchronized (this) {
			ticks = time;
		}
		Animation.paintFrame(g, ticks);
	}
}