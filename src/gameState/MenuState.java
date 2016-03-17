package gameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import main.Game;

public class MenuState extends GameState {

	// FIELDS

	private String[] options = { "Start", "Options", "High Scores", "Quit" };
	private int currentChoice = 0;

	// CONSTRUCTOR
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;

	}

	public void initialise() {

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public void draw(Graphics2D g) {
		// Draw Background
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		// Draw Title
		g.setFont(new Font("Tahoma", Font.PLAIN, 35));
		g.setColor(Color.BLACK);
		String s = "Snake";
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s, Game.WIDTH / 2 - length / 2, 50);

		// Draw Menu
		g.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], Game.WIDTH / 2, 250 + i * 35);
		}
	}

	private void select() {
		switch (currentChoice) {
		case 1:
			gsm.SetState(GameStateManager.PLAYINGSTATE);
			break;
		case 2:
			gsm.SetState(GameStateManager.OPTIONSSTATE);
			break;
		case 3:
			gsm.SetState(GameStateManager.HIGHSCORESTATE);
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Error processing Menu selection");
			break;
		}

	}

	public void keyPressed(int key) {
		if (key == KeyEvent.VK_ENTER) {
			select();
		}

		if (key == KeyEvent.VK_UP) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		
		

	}

	@Override
	public void keyReleased(int key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(int button) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(int button) {
		// TODO Auto-generated method stub

	}

}
