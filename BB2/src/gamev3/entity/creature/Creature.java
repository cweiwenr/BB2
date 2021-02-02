package gamev3.entity.creature;

import java.awt.Graphics;
import java.awt.Rectangle;

import gamev3.Handler;
import gamev3.entity.Entity;

public abstract class Creature extends Entity{

	public static final float DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CHARACTER_WIDTH = 20,
			DEFAULT_CHARACTER_HEIGHT = 40;
	
	protected float life;
	protected float speed;
	protected float xMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		//super method leads to entity class constructor
		super(handler, x, y, width, height);	//with this every creature/ player has a position on the screen
		life = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
	}
	
	public void move() {
		moveX();
	}
	
	public void moveX() {
		//if upper right collision box reaches right limit of display box, 
		//do not change x coordinate, thus not allowed to move
		//we add bounds.width because we are checking the upper right pixel of
		// the collision box
		if(xMove > 0) {	//moving right
			int temp_x= (int)(x + xMove + bounds.x + bounds.width);
			//check if player has reached right border
			if(temp_x < 1024) {
				x += xMove;
			}
			//reset player position to make sure collision box lines
			//with the border of the display
			else {
				x = 1024 - bounds.x - bounds.width;
			}
		}
		//now we do the same for the left side, we did not add bounds.width
		//because we are checking for the upper left pixel of the collision box
		else if(xMove < 0) {	//moving left
			int temp_x= (int)(x + xMove + bounds.x );
			//check if player has reached left border
			if(temp_x > 0) {
				x += xMove;
			}
			else {
				x = 0 - bounds.x;
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

	public float getLife() {
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
	
	public int getHitx() {
		return (int)(x+bounds.x);
	}
	public int getHity() {
		return (int)(y+bounds.y);
	}
	public int getHitWidth() {
		return (int)(x+bounds.x+bounds.width);
	}
	public int getHitHeight() {
		return (int)(y+bounds.y+bounds.height);
	}
	public Rectangle bound() {
		return (new Rectangle((int)(x + bounds.x),(int)(y+bounds.y),
				bounds.width,bounds.height));
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
