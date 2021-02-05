package gamev3.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import gamev3.Handler;

//this is the main class where we can define players obstacles etc.
public abstract class Entity {
	//every entity need tick render x and y values.
	//we choose float for coords so that it is smooth when the players move
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	//collision checker variable
	protected Rectangle bounds;	

	
	public Entity (Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0,0,width,height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	/*
	//returns a new rectangle
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x+bounds.x +xOffset), (int)(y+bounds.y + yOffset),
				bounds.width, bounds.height);
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : entityManager.getEntityManager()) {
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f,  0f).intersects(getCollisionBounds(xOffset,yOffset)))
				return true;
		}
		return false;
	}*/
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
