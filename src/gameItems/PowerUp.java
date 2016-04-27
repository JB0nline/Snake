package gameItems;

import java.awt.*;

public abstract class PowerUp {
	
	protected int x,y,size;
	protected Color color;
	protected String name;
	
	public void draw(Graphics2D g){
		g.setColor(color);
		g.fillOval(x+(size/2), y+(size/2), size, size);
	}
}
