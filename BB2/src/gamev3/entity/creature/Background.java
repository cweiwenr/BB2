package gamev3.entity.creature;

import java.awt.Graphics;

import gamev3.GameMain;
import gamev3.entity.Entity;
import gamev3.gfx.Assets;

public class Background extends Entity{

	private GameMain game;
	private final static int BACKGROUND_WIDTH = 1024;
	private final static int BACKGROUND_HEIGHT = 512;
	
	public Background(GameMain game, float x, float y) {
		super(x, y,BACKGROUND_WIDTH,BACKGROUND_HEIGHT);
		this.game = game;
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.background, 0, 0, null);
	}

}
