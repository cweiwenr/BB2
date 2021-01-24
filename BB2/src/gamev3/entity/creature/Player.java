package gamev3.entity.creature;

import java.awt.Graphics;

import gamev3.GameMain;
import gamev3.gfx.Assets;

//now this is the class that we want the player to control
public class Player extends Creature{
	//this variable allows us to access gamemain properties
	private GameMain game;
	private int id;
	
	public Player(GameMain game, float x, float y, int id) {
		super(x, y, Creature.DEFAULT_CHARACTER_WIDTH, Creature.DEFAULT_CHARACTER_HEIGHT);
		this.game = game;
		this.id = id;
	}

	@Override
	public void tick() {
		//update any variables for the object
		if((game.getKeyManager().left) && this.id == 2)
			x -=3;
		if(game.getKeyManager().right && this.id == 2)
			x +=3;
		if(game.getKeyManager().left1 && this.id == 1)
			x +=3;
		if(game.getKeyManager().right1 && this.id == 1)
			x -=3;
	}

	@Override
	public void render(Graphics g) {
		//drawimage takes in an int thus need to tpe cast
		g.drawImage(Assets.player, (int)x, (int)y, null);
	}

}
