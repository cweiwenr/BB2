package gamev3.entity.creature;

import java.awt.Color;
import java.awt.Graphics;

import gamev3.Handler;
import gamev3.gfx.Assets;

public class Big_rock extends Rocks{
	
	public Big_rock(Handler handler, float x, float y) {
		super(handler, x, y);
		damage = 5;
		rock_point = -2;
		rock_speed = getRockSpeed();
		rock_size = 120;
		effect = 1;
		
		bounds.x = 13;
		bounds.y = 15;
		bounds.width = rock_size - bounds.x * 2;
		bounds.height = rock_size - bounds.y * 2;
	}


	public int getEffect() {
		return 1;
	}

	//In Big_rock class extends Rocks class
	public float getRockSpeed() {
		return (float)(Math.random() * (1 - 1 + 1) + 1);
	}
	

	
	@Override
	public void tick() {
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rocks, (int)x,(int)y,rock_size,rock_size,null);

	}



}
