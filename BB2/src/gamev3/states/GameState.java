package gamev3.states;

import java.awt.Graphics;
import java.util.ArrayList;

import gamev3.Handler;
import gamev3.entity.creature.Background;
import gamev3.entity.creature.Player;
import gamev3.entity.creature.Rocks;


//this is where the actual game is gg to be played at
public class GameState extends State{

	private Player player;
	private Player player2;
	private Background background;
	//private Rocks rock;
	//lets try to experiment with arraylist for rock spawner
	final private int NUM_ROCK = 30;	//total rock on screen at one time
	private ArrayList<Rocks> rockSpawner = new ArrayList<Rocks>();
	

	public GameState(Handler handler) {
		super(handler);
		//making all objects
		background = new Background(handler,0,0);
		player = new Player(handler, 256, 410, 1);
		player2 = new Player(handler, 768, 410, 2);
		//rock = new Rocks(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0);
		
		for (int i = 0; i < NUM_ROCK; i++) {
			rockSpawner.add(new Rocks(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
		}
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		player2.tick();
		//rock.tick();
		for (int i = 0; i < rockSpawner.size(); i++) {
			rockSpawner.get(i).tick();
			if (rockSpawner.get(i).isOffScreen()){
				rockSpawner.remove(i);
				rockSpawner.add(new Rocks(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
				rockSpawner.get(i).tick();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub	
		background.render(g);
		//rock.render(g);
		player.render(g);
		player2.render(g);
		for (int i = 0; i < rockSpawner.size(); i++) {
			rockSpawner.get(i).render(g);
		}
		
	}
	
}
