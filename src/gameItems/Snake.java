package gameItems;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
	// FIELDS
	private ArrayList<BodySegment> segments;
	private boolean left, right, up, down;
	private int speed;
	private Color color;

	// CONSTRUCTOR
	public Snake() {
		segments = new ArrayList<BodySegment>();
		segments.add(new BodySegment(10, 10, 10));
		segments.add(new BodySegment(10, 20, 10));
		segments.add(new BodySegment(10, 30, 10));
		
		color = Color.BLUE;
		
		speed = 5;
		left = false;
		right = false; 
		up = false;
		down = true;
		
	}
	
	//FUNCTIONS
	public void update() {

	}

	public void draw(Graphics2D g) {

	}
}
