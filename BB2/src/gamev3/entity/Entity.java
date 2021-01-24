package gamev3.entity;

import java.awt.Graphics;

//this is the main class where we can define players obstacles etc.
public abstract class Entity {
	//every entity need tick render x and y values.
	//we choose float for coords so that it is smooth when the players move
	protected float x, y;
	
	public Entity (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
}
