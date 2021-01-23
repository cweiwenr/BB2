package gamev2;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

	//init the values for the windows, so all class share same
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	//creating dimension
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int PLAYER_WIDTH = 25;
	static final int PLAYER_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Player player1;
	Player player2;
	
	//constructor
	public GamePanel() {
		//calls methods to draw/ materialize the objects on the panel
		newPlayer();
		//want this to be focusable so that it reads the keystrokes
		this.setFocusable(true);
		//add action listener so that it responds to the keystrokes
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		//starting the game thread
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	//methods
	//whenever call this method will make new ball
	public void newBall() {

	}
	//whenever call this method will make new player
	public void newPlayer() {
		player1 = new Player((GAME_WIDTH/4),GAME_HEIGHT, PLAYER_WIDTH,PLAYER_HEIGHT,1);
		player2 = new Player(3*(GAME_WIDTH/4),GAME_HEIGHT, PLAYER_WIDTH,PLAYER_HEIGHT,2);
	}
	//method for painting stuff on the screen
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		//0,0 is the top left of the window.
		g.drawImage(image, 0,0,this);
	}
	//draw method
	public void draw(Graphics g) {
		player1.draw(g);
		player2.draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	//movement method, move things after each generation of our game loop
	public void move() {
		player1.move();
		player2.move();
	}
	//check object collisions
	public void checkCollision() {

		if(player1.x<=0) {
			player1.x=0;
		}
		if(player1.y >= (GAME_HEIGHT-PLAYER_HEIGHT)) {
			player1.y = GAME_HEIGHT-PLAYER_HEIGHT;
		}
		if(player2.x<=0) {
			player2.x=0;
		}
		if(player2.y >= (GAME_HEIGHT-PLAYER_HEIGHT)) {
			player2.y = GAME_HEIGHT-PLAYER_HEIGHT;
		}


	}
	//run game
	public void run() {
		//basic game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;

			}
		}
	}
	//for registering keystrokes player class will have own keystroke functions
	public class AL extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			player1.keyPressed(e);
			player2.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			player1.keyReleased(e);
			player2.keyReleased(e);
		}
	}
}