package gamev3.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import gamev3.Handler;
import gamev3.entity.creature.Big_rock;
import gamev3.entity.creature.Fire_rock;
import gamev3.entity.creature.Player;
import gamev3.entity.creature.Rocks;
import gamev3.entity.creature.Smoll_rock;
import gamev3.entity.creature.medium_rock;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private Player player2;
	
	final private int NUM_ROCK = 7;	//total rock on screen at one time
	private ArrayList<Rocks> smallRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> mediumRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> bigRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> fireRockSpawner = new ArrayList<Rocks>();
	
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler) {
		this.handler = handler;
		this.player = new Player(handler, 256, 410, 1);
		this.player2 = new Player(handler, 768, 410, 2);;
		
		entities = new ArrayList<Entity>();
		addEntity(player);
		addEntity(player2);
		
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
	
	public void tick() {
		for (int i = 0; i < entities.size(); i ++) {
			Entity e = entities.get(i);
			e.tick();
		}
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
	}
	
	public void render (Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
		
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
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	//setter and getters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public ArrayList<Entity> getEntityManager() {
		return this.entities;
	}

	
}

