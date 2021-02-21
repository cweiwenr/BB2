package gamev3.entity.creature;

import java.awt.Color;
import java.awt.Graphics;

import gamev3.Handler;
import gamev3.gfx.Assets;

public class medium_rock extends Rocks{
	
	public medium_rock(Handler handler, float x, float y) {
		super(handler, x, y);
		damage = 4;
		rock_point = -2;
		rock_speed = getRockSpeed();
		rock_size = 60;
		effect = 1;
		
		bounds.x = 10;
		bounds.y = 12;
		bounds.width = rock_size - bounds.x * 2;
		bounds.height = rock_size - bounds.y * 2;
	}
	
	public float getRockSpeed() {
		return (float)(Math.random() * (2 - 2 + 1) + 2);
	}

	public int getEffect() {
		return 1;
	}
	@Override
	public void tick() {
		//random speed per rock
		move();
	}

	@Override
	public void render(Graphics g) {
		//render out graphics for each rock with random sizes
		g.drawImage(Assets.rocks, (int)x,(int)y,rock_size,rock_size,null);
		/*
		g.setColor(Color.RED);
		g.fillRect((int)(x + bounds.x),(int)(y+bounds.y),
				bounds.width,bounds.height);*/
	}
}
