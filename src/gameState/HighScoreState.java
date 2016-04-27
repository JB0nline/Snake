package gameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import main.Game;

/**
 * The high score screen. Doesn't do anything yet. Will eventually use file
 * system to read in the high scores from the game.
 * 
 * @author Jordan Barraclough
 *
 */
public class HighScoreState extends GameState {

	// CONSTRUCTOR
	public HighScoreState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	//FUNCTIONS
	public void initialise() {
	}

	public void update() {
	}

	public void draw(Graphics2D g) {
		// Background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		// Text
		g.setFont(new Font("Tahoma", Font.PLAIN, 20));
		g.setColor(Color.BLACK);
		String s = "There isn't anything here yet, Jordan has been to lazy to code it.";
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s, Game.WIDTH / 2 - length / 2, 50);

		s = "Let's just pretend that there's something here, press enter to go back to menu";
		length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s, Game.WIDTH / 2 - length / 2, 70);
	}

	public void keyPressed(int key) {
		if (key == KeyEvent.VK_ENTER)
			gsm.setState(GameStateManager.MENUSTATE);
	}

	public void keyReleased(int key) {
	}
}
