package gamev3.entity.creature;

import java.awt.Color;
import java.awt.Graphics;

import gamev3.Handler;
import gamev3.gfx.Assets;

public class Fire_rock extends Rocks{
	
	public Fire_rock(Handler handler, float x, float y) {
		super(handler, x, y);
		damage = 0;
		rock_point = 10;
		rock_speed = getRockSpeed();
		rock_size = 50;
		effect = 1;
		
		bounds.x = 10;
		bounds.y = 12;
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
		g.drawImage(Assets.fireRocks, (int)x,(int)y,rock_size,rock_size,null);
	}
}
