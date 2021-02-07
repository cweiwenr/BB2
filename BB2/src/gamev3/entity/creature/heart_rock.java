package gamev3.entity.creature;

import java.awt.Color;
import java.awt.Graphics;

import gamev3.Handler;
import gamev3.gfx.Assets;

public class heart_rock extends Rocks{
	
	
	public heart_rock(Handler handler, float x, float y) {
		super(handler, x, y);
		damage = 0;
		rock_point = 20;
		rock_speed = (float)(Math.random() * (3 - 3 + 1)+3);
		rock_size = 50;
		effect = 3;
		
		bounds.x = 10;
		bounds.y = 12;
		bounds.width = rock_size - bounds.x * 2;
		bounds.height = rock_size - bounds.y * 2;
	}

	
	@Override
	public void tick() {
		//random speed per rock
		y += rock_speed;
	}

	@Override
	public void render(Graphics g) {
		//render out graphics for each rock with random sizes
		g.drawImage(Assets.heartRocks, (int)x,(int)y,rock_size,rock_size,null);
		/*
		g.setColor(Color.RED);
		g.fillRect((int)(x + bounds.x),(int)(y+bounds.y),
				bounds.width,bounds.height);*/
	}
}
