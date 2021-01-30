package gamev3.entity.creature;

import java.awt.Graphics;

import gamev3.Handler;
import gamev3.entity.Entity;

public abstract class Rocks extends Entity{

	public final static int ROCK_WIDTH = 10;
	public final static int ROCK_HEIGHT = 10;
	
	protected int damage;
	protected float rock_speed;
	protected float yMove;
	protected int rock_size;
	
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
	
	public int getSize() {
		return rock_size;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
