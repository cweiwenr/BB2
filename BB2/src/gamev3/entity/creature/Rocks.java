package gamev3.entity.creature;

import java.awt.Graphics;
import java.awt.Rectangle;

import gamev3.Handler;
import gamev3.entity.Entity;

public abstract class Rocks extends Entity implements movement{

	public final static int ROCK_WIDTH = 10;
	public final static int ROCK_HEIGHT = 10;
	
	protected int damage;
	protected int rock_point;
	protected float rock_speed;
	protected float yMove;
	protected int rock_size;
	protected int effect;
	
	public Rocks(Handler handler, float x, float y) {
		super(handler, x, y, ROCK_WIDTH, ROCK_HEIGHT);
		this.handler = handler;
		
	}
	
	//check if rock has gone off screen
	public boolean isOffScreen() {
		if (y > 512) {
			return true;
		}else {
			return false;
		}
	}
	public void move() {
		y += rock_speed;
	}
	
	public int getSize() {
		return rock_size;
	}

	public Rectangle bound() {
		return (new Rectangle((int)(x + bounds.x),(int)(y+bounds.y),
			bounds.width,bounds.height));
	}
	public float getDamage() {
		return (float)damage;
	}
	public float getPoints() {
		return(float)rock_point;
	}
	public int getEffect() {
		return effect;
	}
	public float getRockSpped() {
		return (float)(Math.random() * (5 - 3 + 1) + 3);
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
