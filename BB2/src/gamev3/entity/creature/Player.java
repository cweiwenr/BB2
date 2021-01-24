package gamev3.entity.creature;

import java.awt.Graphics;

import gamev3.GameMain;
import gamev3.Handler;
import gamev3.gfx.Assets;

//now this is the class that we want the player to control
public class Player extends Creature{
	//this variable allows us to access gamemain properties
	private Handler handler;
	private int id;
	
	public Player(Handler handler, float x, float y, int id) {
		super(handler, x, y, Creature.DEFAULT_CHARACTER_WIDTH, Creature.DEFAULT_CHARACTER_HEIGHT);
		this.handler = handler;
		this.id = id;
	}

	@Override
	public void tick() {
		//update any variables for the object
		getInput();
		move();

	}
	//managing and handling what input does
	private void getInput() {
		xMove = 0;
		
		if(handler.getKeyManager().right1 && this.id == 1)
				xMove = +speed;
		if(handler.getKeyManager().left1 && this.id == 1)
			xMove = -speed;
		if(handler.getKeyManager().right && this.id == 2)
			xMove = +speed;
		if(handler.getKeyManager().left && this.id == 2)
			xMove = -speed;
	}
	@Override
	public void render(Graphics g) {
		//drawimage takes in an int thus need to tpe cast
		g.drawImage(Assets.player, (int)x, (int)y, null);
	}

}
