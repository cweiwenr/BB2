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
		x += xMove;
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
