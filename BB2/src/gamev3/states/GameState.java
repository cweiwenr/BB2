package gamev3.states;

import java.awt.Graphics;

import gamev3.GameMain;
import gamev3.entity.creature.Player;

//this is where the actual game is gg to be played at
public class GameState extends State{

	private Player player;
	
	public GameState(GameMain game) {
		super(game);
		player = new Player(game, 256, 410);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		player.render(g);
	}

	
}
