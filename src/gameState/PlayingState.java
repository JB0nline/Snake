package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import gameItems.PowerUp;
import gameState.GameStateManager;
import main.Game;

/**
 * The state of the game where the player is playing the main mode of the game.
 * 
 * @author Jordan Barraclough
 *
 */
public class PlayingState extends GameState {
	//FIELDS
	private PowerUp pUp;
	
	// CONSTRUCTOR
	public PlayingState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	// FUNCTIONS
	public void initialise() {
		int x = 100;
		int y = 100;
		
		
		pUp = new PowerUp(x,y,10,Color.RED);
	}

	public void update() {
		gsm.snake.update();
	}

	public void draw(Graphics2D g) {
		// Draw Background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 20));
		String s = "Playing State";
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s, Game.WIDTH / 2 - length / 2, 50);

		gsm.snake.draw(g);
		pUp.draw(g);
	}

	public void keyPressed(int key) {
		if (key == KeyEvent.VK_ESCAPE) {
			gsm.setState(GameStateManager.PAUSESTATE);
		}
		if (key == KeyEvent.VK_UP) {
			gsm.snake.upPressed();
		}
		if (key == KeyEvent.VK_DOWN) {
			gsm.snake.downPressed();
		}
		if (key == KeyEvent.VK_LEFT) {
			gsm.snake.leftPressed();
		}
		if (key == KeyEvent.VK_RIGHT) {
			gsm.snake.rightPressed();
		}
	}

	public void keyReleased(int key) {
	}

}
