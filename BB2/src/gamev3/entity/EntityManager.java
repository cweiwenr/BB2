package gamev3.entity;

import java.util.ArrayList;

import gamev3.Handler;
import gamev3.entity.creature.Background;
import gamev3.entity.creature.Player;
import gamev3.entity.creature.Rocks;

public class EntityManager {

	private Handler handler;
	private Player player;
	private Player player2;
	private Background background;
	final private int NUM_ROCK = 7;	//total rock on screen at one time
	private ArrayList<Rocks> smallRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> mediumRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> bigRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> fireRockSpawner = new ArrayList<Rocks>();
	
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler, Player player, Player player2,
			Background background, ArrayList<Rocks> smallList, ArrayList<Rocks> mediumList,
			ArrayList<Rocks> bigList, ArrayList<Rocks> fireList) {
		this.handler = handler;
		this.player = player;
		this.player2 = player2;
		this.background = background;
		
	}
	
	public void addEntity(Entity e) {
		
	}
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

	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public void tick() {
		
	}
	
	public void render() {
		
	}
}
