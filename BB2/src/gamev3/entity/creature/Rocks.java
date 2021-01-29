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
	
	public Rocks(Handler handler, float x, float y) {
		super(handler, x, y, ROCK_WIDTH, ROCK_HEIGHT);
		this.handler = handler;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		y += 4;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.rocks, (int)x,(int)y,10,10,null);
	}

}
