package gameItems;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
	// FIELDS
	private ArrayList<BodySegment> segments;
	private boolean left, right, up, down;
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

		color = Color.BLUE;

		speed = 500;
		left = false;
		right = false;
		up = false;
		down = true;

	}

	// FUNCTIONS
	public void update() {
		
		if ((System.nanoTime() - moveTimer) / 1000000 > speed) {
			moveTimer = System.nanoTime();
			segments.remove(0);
			BodySegment BSeg = segments.get(segments.size()-1);
			if(right){
				segments.add(new BodySegment(BSeg.getX() + segmentSize, BSeg.getY(), segmentSize));
			}else if(left){
				segments.add(new BodySegment(BSeg.getX() - segmentSize, BSeg.getY(), segmentSize));
			}else if(down){
				segments.add(new BodySegment(BSeg.getX(), BSeg.getY() + segmentSize, segmentSize));
			}else{
				segments.add(new BodySegment(BSeg.getX(), BSeg.getY() - segmentSize, segmentSize));
			}
			
			
		}
	}

	public void draw(Graphics2D g) {

		BodySegment BSeg;

		for (int i = 0; i < segments.size(); i++) {
			BSeg = segments.get(i);
			g.setColor(color);
			g.fillOval(BSeg.getX() - (BSeg.getSize() / 2), BSeg.getY() - (BSeg.getSize() / 2), BSeg.getSize(),
					BSeg.getSize());
		}
	}
	
	public void leftPressed(){
		if(!right){
			resetDirection();
			left = true;
		}
	}
	
	public void rightPressed(){
		if(!left){
			resetDirection();
			right = true;
		}
	}
	
	public void upPressed(){
		if(!down){
			resetDirection();
			up = true;
		}
	}
	
	public void downPressed(){
		if(!up){
			resetDirection();
			down = true;
		}
	}
	private void resetDirection(){
		left = false;
		up = false;
		down = false;
		right = false;
	}
}
