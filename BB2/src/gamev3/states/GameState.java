package gamev3.states;

import java.awt.Graphics;

import gamev3.Handler;
import gamev3.entity.creature.Background;
import gamev3.entity.creature.Player;
import gamev3.entity.creature.Rocks;

//this is where the actual game is gg to be played at
public class GameState extends State{

	private Player player;
	private Player player2;
	private Background background;
	private Rocks rock;
	
	public GameState(Handler handler) {
		super(handler);
		background = new Background(handler,0,0);
		player = new Player(handler, 256, 410, 1);
		player2 = new Player(handler, 768, 410, 2);
		rock = new Rocks(handler, 128,0);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		player2.tick();
		rock.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub	
		background.render(g);
		rock.render(g);
		player.render(g);
		player2.render(g);
		rock.render(g);
		
	}

	
}
