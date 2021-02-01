package gamev3.states;

import java.awt.Graphics;
import java.util.ArrayList;

import gamev3.Handler;
import gamev3.entity.EntityManager;
import gamev3.entity.creature.Background;
import gamev3.entity.creature.Big_rock;
import gamev3.entity.creature.Fire_rock;
import gamev3.entity.creature.Player;
import gamev3.entity.creature.Rocks;
import gamev3.entity.creature.Smoll_rock;
import gamev3.entity.creature.medium_rock;


//this is where the actual game is gg to be played at
public class GameState extends State{

	private Player player;
	private Player player2;
	private Background background;
	//private EntityManager entityManager;
	//private Rocks rock;
	//lets try to experiment with arraylist for rock spawner
	
	final private int NUM_ROCK = 1;	//total rock on screen at one time
	private ArrayList<Rocks> smallRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> mediumRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> bigRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> fireRockSpawner = new ArrayList<Rocks>();
	
	

	public GameState(Handler handler) {
		super(handler);
		//making all objects
		background = new Background(handler,0,0);
		player = new Player(handler, 256, 410, 1);
		player2 = new Player(handler, 768, 410, 2);
		//rock = new Rocks(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0);
		//entityManager = new EntityManager(handler);
		
		for (int i = 0; i < NUM_ROCK; i++) {
			smallRockSpawner.add(new Smoll_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
		}
		
		for (int i = 0; i < NUM_ROCK; i++) {
			mediumRockSpawner.add(new medium_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
		}
		
		for (int i = 0; i < NUM_ROCK; i++) {
			bigRockSpawner.add(new medium_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
		}
		
		for (int i = 0; i < NUM_ROCK; i++) {
			fireRockSpawner.add(new Fire_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
		}
	
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		player2.tick();
		//entityManager.tick();
		//rock.tick();
		
		for (int i = 0; i < smallRockSpawner.size(); i++) {
			smallRockSpawner.get(i).tick();
			if (smallRockSpawner.get(i).isOffScreen()){
				smallRockSpawner.remove(i);
				smallRockSpawner.add(new Smoll_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
				smallRockSpawner.get(i).tick();
			} 
		}
	
		for (int i = 0; i < mediumRockSpawner.size(); i++) {
			mediumRockSpawner.get(i).tick();
			if (mediumRockSpawner.get(i).isOffScreen() && i < 10){
				mediumRockSpawner.remove(i);
				mediumRockSpawner.add(new medium_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
				mediumRockSpawner.get(i).tick();
			} 
		}
		
		for (int i = 0; i < bigRockSpawner.size(); i++) {
			bigRockSpawner.get(i).tick();
			if (bigRockSpawner.get(i).isOffScreen()){
				bigRockSpawner.remove(i);
				bigRockSpawner.add(new Big_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
				bigRockSpawner.get(i).tick();
			} 
		}
		
		for (int i = 0; i < fireRockSpawner.size(); i++) {
			fireRockSpawner.get(i).tick();
			if (fireRockSpawner.get(i).isOffScreen()){
				fireRockSpawner.remove(i);
				fireRockSpawner.add(new Fire_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0));
				fireRockSpawner.get(i).tick();
			} 
		}
		checkHit();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub	
		
		background.render(g);
		//entityManager.render(g);
		player.render(g);
		player2.render(g);
		
		for (int i = 0; i < smallRockSpawner.size(); i++) {
			smallRockSpawner.get(i).render(g);
		}
		
		for (int i = 0; i < mediumRockSpawner.size(); i++) {
			mediumRockSpawner.get(i).render(g);
		}
		
		for (int i = 0; i < bigRockSpawner.size(); i++) {
			bigRockSpawner.get(i).render(g);
		}
		
		for (int i = 0; i < fireRockSpawner.size(); i++) {
			fireRockSpawner.get(i).render(g);
		}
		
	}
	
	public void checkHit() {
	//use this function to call player's rectangle and rock's rectangle.
		//check if the lower x of the rock's rectangle is equal to the top of player's height
		//if so, then minus health by 1
		//else if player left bound == rock right bound
		//minus 1
		//else if player right bound == rock left bound
		//minus 1
		//this ensures that if rock touches players top left or right, the health will minus 1.
		for (int i = 0; i < smallRockSpawner.size(); i++) {
			int topLeftx = smallRockSpawner.get(i).getRectx();
			int topLefty = smallRockSpawner.get(i).getRecty();
			int topRightx = topLeftx + smallRockSpawner.get(i).getRectrightx();
			int hitheight = topLefty + smallRockSpawner.get(i).getRectHeight();
			
			System.out.println(topLefty);
			
			
		}
	}
	
}
