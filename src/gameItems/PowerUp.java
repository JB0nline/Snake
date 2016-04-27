package gameItems;

import java.awt.*;

public abstract class PowerUp {

	private int size,x,y;
	private Color color;
	private String name;
	
	public void draw(Graphics2D g){
		g.setColor(color);
		g.fillOval(x,y,size,size);
	}
}
