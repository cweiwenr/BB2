package gamev3.entity.creature;

import gamev3.Handler;
import gamev3.entity.Entity;

public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CHARACTER_WIDTH = 20,
			DEFAULT_CHARACTER_HEIGHT = 40;
	
	protected int life;
	protected float speed;
	protected float xMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		//super method leads to entity class constructor
		super(handler, x, y, width, height);	//with this every creature/ player has a position on the screen
		// TODO Auto-generated constructor stub
		life = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
	}
	
	public void move() {
		moveX();

	}
	/*
	protected boolean collistionWithEntity(int x, int y) {
		
	}*/
	
	public void moveX() {
		//if upper right collision box reaches right limit of display box, 
		//do not change x coordinate, thus not allowed to move
		//we add bounds.width because we are checking the upper right pixel of
		// the collision box
		if(xMove > 0) {	//moving right
			int temp_x= (int)(x + xMove + bounds.x + bounds.width);
			if(temp_x < 1024) {
				x += xMove;
			}
		}
		//now we do the same for the left side, we did not add bounds.width
		//because we are checking for the upper left pixel of the collision box
		else if(xMove < 0) {	//moving left
			int temp_x= (int)(x + xMove + bounds.x );
			if(temp_x > 0) {
				x += xMove;
			}
		}
	}
	
	//getters and setters
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
