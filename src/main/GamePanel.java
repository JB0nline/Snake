package main;

import javax.swing.JFrame;

/**
 * Contains the main method - runs the JFrame.
 * 
 * @author Jordan Barraclough
 *
 */
public class GamePanel {
	public static void main(String[] args){
		JFrame window = new JFrame("Snake");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setContentPane(new Game());
		window.setResizable(false);
		
		window.pack();
		window.setVisible(true);
	}
}
