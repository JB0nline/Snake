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
	// FIELDS
	private PowerUp pUp;

	// CONSTRUCTOR
	public PlayingState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	// FUNCTIONS
	public void initialise() {
		int x = 0;
		int y = 0;
		int size = 10;
		while (x < size || x > Game.WIDTH - size - 5) {
			x = randomNumber(Game.WIDTH);
		}
		while (y < size || y > Game.HEIGHT - size - 5) {
			y = randomNumber(Game.HEIGHT);
		}

		pUp = new PowerUp(x, y, size, Color.RED);
	}

	public void update() {
		gsm.snake.update();
		gsm.snake.checkCollision(pUp);
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
		
		
		try {
			pUp.draw(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		gsm.snake.draw(g);
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

	private int randomNumber(int upperLimit) {
		int rand = (int) (Math.random() * upperLimit + 1);
		return rand;
	}

}
