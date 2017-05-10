package gameState;
/**
 * Abstract method to extend the the game states from. 
 * 
 * @author Jordan Barraclough
 *
 */
public abstract class GameState {

	protected GameStateManager gsm;

	public abstract void initialise();

	public abstract void update();

	public abstract void draw(java.awt.Graphics2D g);

	public abstract void keyPressed(int key);

	public abstract void keyReleased(int key);


}
