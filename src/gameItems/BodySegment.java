package gameItems;

/**
 * Used to hold the information about each body segment.
 * 
 * @author Jordan Barraclough
 *
 */
public class BodySegment {
	// FIELDS
	private int x, y, size;

	// CONSTRUCTOR
	/**
	 * Sets the position of the body segment of the snake
	 * 
	 * @param x
	 *            x-position of the segment
	 * @param y
	 *            y-position of the segment
	 * @param size
	 *            The size of the segment
	 */
	public BodySegment(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	// FUNCTIONS
	/**
	 * 
	 * @return The x-position of the segment
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return The y-position of the segment
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @return The size of the segment
	 */
	public int getSize() {
		return size;
	}
}
