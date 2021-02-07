package gamev3.entity.creature;

import java.awt.Color;
import java.awt.Graphics;

import gamev3.GameMain;
import gamev3.Handler;
import gamev3.entity.Entity;
import gamev3.gfx.Assets;

public class Background extends Entity{

	private Handler handler;
	private final static int BACKGROUND_WIDTH = 1024;
	private final static int BACKGROUND_HEIGHT = 512;
	
	public Background(Handler handler, float x, float y) {
		super(handler, x, y,BACKGROUND_WIDTH,BACKGROUND_HEIGHT);
		this.handler = handler;
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.background, 0, 0, null);
		// Draw out scoreboard banner
		g.setColor(new Color(0x5a535b));
		g.fillRect(0, 0, 1024, 45);
		
		// Set up polygon coordinate
		int polyX[] = {0, 576, 448, 0};
		int polyY[] = {0, 0, 45, 45};
		
		g.setColor(new Color(0x3f3c47));
		g.fillPolygon(polyX, polyY, 4);
	}//test

}
