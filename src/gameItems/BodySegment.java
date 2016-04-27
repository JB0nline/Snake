package gameItems;

public class BodySegment {
	// FIELDS
	private int x, y, size;

	// Constructor
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
