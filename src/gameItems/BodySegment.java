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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}
}
