package gamev2;
import java.awt.*;
import java.awt.event.*;

//this will be our player class
public class Player extends Rectangle{

	
	int id;	//either 1 or 2, for player 1 or 2
	int yVelocity;	//for setting the coords of the moved object
	int xVelocity;	//for setting the coords of the moved object
	int speed = 10;	//speed of how fast the PLAYER moves
	
	
	//constructor, parameters will be where you want the PLAYERs to be
	//(X POSITION, Y POSITION, WIDTH, HEIGHT, ID)
	public Player(int x, int y, int PLAYER_WIDTH, int PLAYER_HEIGHT, int id) {
		//since this class is a subclass of a rectangle
		super(x,y,PLAYER_WIDTH,PLAYER_HEIGHT);
		this.id = id;
	}
	

	//for registering keystroke, for jpanel's inner class
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_A) {
				setXDirection(-speed);
			}
			if(e.getKeyCode() == KeyEvent.VK_D) {
				setXDirection(speed);
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				setXDirection(-speed);
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setXDirection(speed);
			}
			break;
		}

	}
	
	
	public void keyReleased(KeyEvent e) {
		//changing all the parameter to 0 so that PLAYERs stop moving
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_A) {
				setXDirection(0);
			}
			if(e.getKeyCode() == KeyEvent.VK_D) {
				setXDirection(0);
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				setXDirection(0);
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setXDirection(0);
			}
			break;
		}
	}
	//function to call when key pressed
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	
	public void setXDirection(int xDirection) {
		xVelocity = xDirection;
	}
	
	public void move() {
		y= y + yVelocity;
		x= x + xVelocity;
	}
	
	public void draw(Graphics g) {
		if(id==1) {
			g.setColor(Color.BLUE);
		}
		else {
			g.setColor(Color.red);
		}
		g.fillRect(x, y, width, height);
	}
	
}
