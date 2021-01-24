package gamev3.entity.creature;

import gamev3.entity.Entity;

public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CHARACTER_WIDTH = 20,
			DEFAULT_CHARACTER_HEIGHT = 40;
	
	protected int life;
	protected float speed;
	
	public Creature(float x, float y, int width, int height) {
		//super method leads to entity class constructor
		super(x, y, width, height);	//with this every creature/ player has a position on the screen
		// TODO Auto-generated constructor stub
		life = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		
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
