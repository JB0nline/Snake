package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import gameState.GameStateManager;

public class Game extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;

	// FIELDS
	// holds the height and width of the window
	public static int HEIGHT = 600;
	public static int WIDTH = 800;

	// These fields run the game
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

	// These fields allow for double buffering
	private BufferedImage image;
	private Graphics2D g;

	// Game state manager
	private GameStateManager gsm;

	/**
	 * Creates the game window. Acts as a parser to the game state manager
	 */
	// CONSTRUCTOR
	public Game() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	// FIELDS
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}

	private void initialise() {

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		running = true;

		gsm = new GameStateManager(this);

		// this part adds the antialiasing
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

	}

	public void run() {

		initialise();

		long startTime;
		long URDTimeMillis;
		long waitTime;

		// GAME LOOP
		while (running) {

			startTime = System.nanoTime();

			update();
			render();
			draw();

			URDTimeMillis = (System.nanoTime() - startTime) / 1000000;

			waitTime = Math.abs(targetTime - URDTimeMillis);

			try {
				Thread.sleep(waitTime);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void update() {
		gsm.update();
	}

	private void render() {
		gsm.draw(g);
	}

	private void draw() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}

	public void keyTyped(KeyEvent key) {
	}

	public void keyPressed(KeyEvent key) {
		gsm.KeyPressed(key.getKeyCode());
	}

	public void keyReleased(KeyEvent key) {
		gsm.KeyReleased(key.getKeyCode());
	}
}
