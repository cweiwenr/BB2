package gamev3.entity.creature;

import java.awt.Color;
import java.awt.Graphics;

import gamev3.Handler;
import gamev3.gfx.Assets;

public class Smoll_rock extends Rocks{
	
	public Smoll_rock(Handler handler, float x, float y) {
		super(handler, x, y);
		damage = 10;
		rock_point = 0;
		rock_speed = (float)(Math.random() * (3 - 3 + 1) + 3);
		rock_size = 30;
		effect = 1;
		
		bounds.x = 5;
		bounds.y = 7;
		bounds.width = rock_size - bounds.x * 2;
		bounds.height = rock_size - bounds.y * 2;
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
