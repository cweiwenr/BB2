package gamev3.entity.creature;

import java.awt.Graphics;

import gamev3.GameMain;
import gamev3.Handler;
import gamev3.entity.Entity;
import gamev3.gfx.Assets;

public class Rocks extends Entity{

	private Handler handler;
	public final static int ROCK_WIDTH = 10;
	public final static int ROCK_HEIGHT = 10;
	//random rock size woooo
	private int rock_size = (int)(Math.random() * (50 - 10 + 1)+ 10);
	
	public Rocks(Handler handler, float x, float y) {
		super(handler, x, y, ROCK_WIDTH, ROCK_HEIGHT);
		this.handler = handler;
		// TODO Auto-generated constructor stub
	}
	
	//check if rock has gone off screen
	public boolean isOffScreen() {
		if (y > 512) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void tick() {
		//random speed per rock
		y += Math.random() * (8 - 2 + 1) + 2;
	}

	@Override
	public void render(Graphics g) {
		//render out graphics for each rock with random sizes
		g.drawImage(Assets.rocks, (int)x,(int)y,rock_size,rock_size,null);
	}

}
