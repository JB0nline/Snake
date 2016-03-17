package gameState;

public abstract class GameState {

	protected GameStateManager gsm;

	public abstract void initialise();

	public abstract void update();

	public abstract void draw(java.awt.Graphics2D g);

	public abstract void keyPressed(int key);

	public abstract void keyReleased(int key);

	public abstract void mousePressed(int button);

	public abstract void mouseReleased(int button);

}
