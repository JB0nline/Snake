package gameItems;

import java.awt.*;
import java.util.ArrayList;

import main.Game;

/**
 * The main snake class. Deals with all information and actions regarding the
 * snake.
 * 
 * @author Jordan Barraclough
 *
 */
public class Snake {
	// FIELDS
	private ArrayList<BodySegment> segments;
	private boolean left, right, up, down, changed;
	private int segmentSize;
	private Color color;
	private long moveTimer, speed;

	// CONSTRUCTOR
	public Snake() {
		segmentSize = 10;
		segments = new ArrayList<BodySegment>();
		segments.add(new BodySegment(10, 10, segmentSize));
		segments.add(new BodySegment(10, 20, segmentSize));
		segments.add(new BodySegment(10, 30, segmentSize));
		segments.add(new BodySegment(10, 40, segmentSize));
		segments.add(new BodySegment(10, 50, segmentSize));

		// Colour of the snake
		color = Color.BLUE;

		// Speed of the snake
		speed = 50;

		// Booleans to hold the direction of the snake.
		left = false;
		right = false;
		up = false;
		down = true;

	}

	// FUNCTIONS
	/**
	 * Updates the snake.
	 */
	public void update() {

		if ((System.nanoTime() - moveTimer) / 1000000 > speed) {
			moveTimer = System.nanoTime();
			// Changed is set to false so that the snake cannot change direction
			// more than once per tick
			changed = false;
			segments.remove(0);
			BodySegment BSeg = segments.get(segments.size() - 1);
			if (right) {
				if (BSeg.getX() + segmentSize > Game.WIDTH) {
					segments.add(new BodySegment(segmentSize, BSeg.getY(), segmentSize));
				} else {
					segments.add(new BodySegment(BSeg.getX() + segmentSize, BSeg.getY(), segmentSize));
				}
			} else if (left) {
				if (BSeg.getX() - segmentSize < segmentSize) {
					segments.add(new BodySegment(Game.WIDTH - segmentSize, BSeg.getY(), segmentSize));
				} else {
					segments.add(new BodySegment(BSeg.getX() - segmentSize, BSeg.getY(), segmentSize));
				}
			} else if (down) {
				if (BSeg.getY() + segmentSize > Game.HEIGHT) {
					segments.add(new BodySegment(BSeg.getX(), segmentSize, segmentSize));
				} else {
					segments.add(new BodySegment(BSeg.getX(), BSeg.getY() + segmentSize, segmentSize));
				}
			} else {
				if (BSeg.getY() - segmentSize < segmentSize) {
					segments.add(new BodySegment(BSeg.getX(), Game.HEIGHT - segmentSize, segmentSize));
				} else {
					segments.add(new BodySegment(BSeg.getX(), BSeg.getY() - segmentSize, segmentSize));
				}
			}

		}
	}

	/**
	 * Draws the snake.
	 * 
	 * @param g
	 *            The graphic the snake will be drawn to.
	 */
	public void draw(Graphics2D g) {

		BodySegment BSeg;

		for (int i = 0; i < segments.size(); i++) {
			BSeg = segments.get(i);
			g.setColor(color);
			g.fillOval(BSeg.getX() - (BSeg.getSize() / 2), BSeg.getY() - (BSeg.getSize() / 2), BSeg.getSize(),
					BSeg.getSize());
		}
	}

	/**
	 * Make the snake move left. Checks that right and changed are both false.
	 */
	public void leftPressed() {
		if (!right && !changed) {
			changed = true;
			resetDirection();
			left = true;
		}
	}

	/**
	 * Make the snake move right. Checks that left and changed are both false.
	 */
	public void rightPressed() {
		if (!left && !changed) {
			changed = true;
			resetDirection();
			right = true;
		}
	}

	/**
	 * Make the snake move up. Checks that down and changed are both false.
	 */
	public void upPressed() {
		if (!down && !changed) {
			changed = true;
			resetDirection();
			up = true;
		}
	}

	/**
	 * Make the snake move down. Checks that up and changed are both false.
	 */
	public void downPressed() {
		if (!up && !changed) {
			changed = true;
			resetDirection();
			down = true;
		}
	}

	/**
	 * Sets all the direction booleans to false.
	 */
	private void resetDirection() {
		left = false;
		up = false;
		down = false;
		right = false;
	}
}
