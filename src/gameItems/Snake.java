package gameItems;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
	// FIELDS
	private ArrayList<BodySegment> segments;
	private boolean left, right, up, down;
	private int speed, segmentSize;
	private Color color;

	// CONSTRUCTOR
	public Snake() {
		segmentSize = 10;
		segments = new ArrayList<BodySegment>();
		segments.add(new BodySegment(10, 50, segmentSize));
		segments.add(new BodySegment(10, 40, segmentSize));
		segments.add(new BodySegment(10, 30, segmentSize));
		segments.add(new BodySegment(10, 20, segmentSize));
		segments.add(new BodySegment(10, 10, segmentSize));
		
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
		
		BodySegment BSeg;
		
		for(int i = 0; i<segments.size();i++){
			BSeg = segments.get(i);
			g.setColor(color);
			g.fillRect(BSeg.getX(),BSeg.getY(),BSeg.getSize(),BSeg.getSize());
		}
	}
}
