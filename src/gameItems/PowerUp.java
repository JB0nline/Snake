package gameItems;

import java.awt.*;

/**
 * The x and y relate to the top left position of the power up. The size is the
 * diameter of the circle.
 * 
 * @author Jordan Barraclough
 *
 */
public class PowerUp {
	// FIELDS
	protected int x, y, size;
	protected Color color;

	// CONSTRUCTOR
	/**
	 * Creates a power up at the location (x,y) of the set size and colour.
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 * @param size
	 *            Diameter of the circle
	 * @param color
	 *            Colour of the powerup
	 */
	public PowerUp(int x, int y, int size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}

	// FUNCTIONS
	/**
	 * Draw the power up
	 * 
	 * @param g
	 *            The graphic the power up needs to be drawn to.
	 */
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, size, size);
	}
}
