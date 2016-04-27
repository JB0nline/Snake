package gameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import main.Game;

/**
 * The game over state. Used when the player loses the game. The user can press
 * enter from this screen to return the game to the menu state.
 * 
 * @author Jordan Barraclough
 *
 */
public class GameOverState extends GameState {

	// CONSTRUCTOR
	public GameOverState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	// FUNCTIONS
	public void initialise() {
		// NOTHING TO INITIALISE
	}

	public void update() {
		// NOTHING TO UPDATE
	}

	public void draw(Graphics2D g) {

		// Draw Background
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 35));
		String s = "Game Over";
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s, Game.WIDTH / 2 - length / 2, 50);

		g.setFont(new Font("Tahoma", Font.PLAIN, 25));

		s = "Press ENTER to return to the menu screen";
		length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s, Game.WIDTH / 2 - length / 2, 500);
	}

	public void keyPressed(int key) {
		if (key == KeyEvent.VK_ENTER) {
			gsm.setState(GameStateManager.MENUSTATE);
		}
	}

	public void keyReleased(int key) {
	}
}
