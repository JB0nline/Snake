package gameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

import gameItems.Snake;
import main.Game;

/**
 * Manages the state of the game. Calls initialise when the state is changed to.
 * Also acts as a parser for key presses and releases.
 * 
 * @author Jordan Barraclough
 *
 */
public class GameStateManager {
	// FIELDS
	private ArrayList<GameState> gameStates;
	private int currentState;
	private int previousState;

	Game game;

	//The different states of the game.
	public static final int MENUSTATE = 0;
	public static final int HIGHSCORESTATE = 1;
	public static final int PAUSESTATE = 2;
	public static final int GAMEOVERSTATE = 3;
	public static final int PLAYINGSTATE = 4;

	public Snake snake;

	// CONSTRUCTOR
	public GameStateManager(Game game) {

		gameStates = new ArrayList<GameState>();

		this.game = game;

		currentState = MENUSTATE;
		gameStates.add(new MenuState(this));
		gameStates.add(new HighScoreState(this));
		gameStates.add(new PauseState(this));
		gameStates.add(new GameOverState(this));
		gameStates.add(new PlayingState(this));

		snake = new Snake();
	}

	// FUNCTIONS
	public void setState(int state) {
		previousState = currentState;
		currentState = state;
		gameStates.get(currentState).initialise();
	}
	/**
	 * Reverts to the previous state.
	 */
	public void resume() {
		currentState = previousState;
	}

	public int getPreviousState() {
		return previousState;
	}

	public int getState() {
		return currentState;
	}

	public void update() {
		gameStates.get(currentState).update();
	}

	public void draw(Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}

	public void KeyPressed(int key) {
		gameStates.get(currentState).keyPressed(key);
	}

	public void KeyReleased(int key) {
		gameStates.get(currentState).keyReleased(key);
	}

}
