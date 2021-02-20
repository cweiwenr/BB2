package gamev3.states;

import java.awt.Graphics;
import java.util.ArrayList;
import gamev3.Handler;
import gamev3.entity.TimerDisplay;
import gamev3.entity.creature.Background;
import gamev3.entity.creature.Big_rock;
import gamev3.entity.creature.Fire_rock;
import gamev3.entity.creature.Player;
import gamev3.entity.creature.Rocks;
import gamev3.entity.creature.Smoll_rock;
//import gamev3.entity.creature.TimerDisplay;
import gamev3.entity.creature.medium_rock;
import gamev3.entity.creature.ice_rock;
import gamev3.entity.creature.boot_rock;
import gamev3.entity.creature.heart_rock;



//this is where the actual game is gg to be played at
public class GameState extends State{

	private Player player;
	private Player player2;
	private Background background;
	private TimerDisplay timerdisplay;
	//private EntityManager entityManager;
	//private Rocks rock;
	//lets try to experiment with arraylist for rock spawner
	
	final private int NUM_ROCK = 6;	//total rock on screen at one time
	private ArrayList<Rocks> smallRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> mediumRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> bigRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> fireRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> iceRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> bootRockSpawner = new ArrayList<Rocks>();
	private ArrayList<Rocks> heartRockSpawner = new ArrayList<Rocks>();
	

	public GameState(Handler handler) {
		super(handler);
		//making all objects
		timerdisplay = new TimerDisplay(handler,0,0);
		background = new Background(handler,0,0);
		player = new Player(handler, 256, 410, 1);
		player2 = new Player(handler, 768, 410, 2);
		//rock = new Rocks(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),0);
		//entityManager = new EntityManager(handler);
		timerdisplay.start();
		for (int i = 0; i < NUM_ROCK; i++) {
			smallRockSpawner.add(new Smoll_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
		}
		
		for (int i = 0; i < NUM_ROCK; i++) {
			mediumRockSpawner.add(new medium_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
		}
		
		for (int i = 0; i < NUM_ROCK; i++) {
			bigRockSpawner.add(new medium_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
		}
		
		for (int i = 0; i < NUM_ROCK; i++) {
			fireRockSpawner.add(new Fire_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
		}
		
		for (int i = 0; i < NUM_ROCK; i++) {
			iceRockSpawner.add(new ice_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
		}
		
		for (int i = 0; i < 2; i++) {
			bootRockSpawner.add(new boot_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
		}
		
		for (int i = 0; i < 2; i++) {
			heartRockSpawner.add(new heart_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
		}
	
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		player2.tick();
		
		for (int i = 0; i < smallRockSpawner.size(); i++) {
			smallRockSpawner.get(i).tick();
			try {
				if (smallRockSpawner.get(i).isOffScreen()){
					smallRockSpawner.remove(i);
					smallRockSpawner.add(new Smoll_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
					smallRockSpawner.get(i).tick();	
				} 
			}catch (IndexOutOfBoundsException e){
				System.out.println("Exception: " + e.getMessage());
			}
			
		}
		for (int i = 0; i < mediumRockSpawner.size(); i++) {
			mediumRockSpawner.get(i).tick();
			try {
				if (mediumRockSpawner.get(i).isOffScreen()){
					mediumRockSpawner.remove(i);
					mediumRockSpawner.add(new medium_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
					mediumRockSpawner.get(i).tick();	
				} 
			}catch (IndexOutOfBoundsException e){
				System.out.println("Exception: " + e.getMessage());
			}
			
		}
		for (int i = 0; i < bigRockSpawner.size(); i++) {
			bigRockSpawner.get(i).tick();
			try {
				if (bigRockSpawner.get(i).isOffScreen()){
					bigRockSpawner.remove(i);
					bigRockSpawner.add(new Big_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
					bigRockSpawner.get(i).tick();	
				} 
			}catch (IndexOutOfBoundsException e){
				System.out.println("Exception: " + e.getMessage());
			}
			
		}
		for (int i = 0; i < fireRockSpawner.size(); i++) {
			fireRockSpawner.get(i).tick();
			try {
				if (fireRockSpawner.get(i).isOffScreen()){
					fireRockSpawner.remove(i);
					fireRockSpawner.add(new Fire_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
					fireRockSpawner.get(i).tick();	
				} 
			}catch (IndexOutOfBoundsException e){
				System.out.println("Exception: " + e.getMessage());
			}
			
		}
		for (int i = 0; i < iceRockSpawner.size(); i++) {
			iceRockSpawner.get(i).tick();
			try {
				if (iceRockSpawner.get(i).isOffScreen()){
					iceRockSpawner.remove(i);
					iceRockSpawner.add(new ice_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
					iceRockSpawner.get(i).tick();	
				} 
			}catch (IndexOutOfBoundsException e){
				System.out.println("Exception: " + e.getMessage());
			}
			
		}
		for (int i = 0; i < bootRockSpawner.size(); i++) {
			bootRockSpawner.get(i).tick();
			try {
				if (bootRockSpawner.get(i).isOffScreen()){
					bootRockSpawner.remove(i);
					bootRockSpawner.add(new boot_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
					bootRockSpawner.get(i).tick();	
				} 
			}catch (IndexOutOfBoundsException e){
				System.out.println("Exception: " + e.getMessage());
			}
			
		}
		for (int i = 0; i < heartRockSpawner.size(); i++) {
			heartRockSpawner.get(i).tick();
			try {
				if (heartRockSpawner.get(i).isOffScreen()){
					heartRockSpawner.remove(i);
					heartRockSpawner.add(new heart_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
					heartRockSpawner.get(i).tick();	
				} 
			}catch (IndexOutOfBoundsException e){
				System.out.println("Exception: " + e.getMessage());
			}
			
		}

		checkHit(player);
		checkHit(player2);

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		background.render(g);
		//entityManager.render(g);
		player.render(g);
		player2.render(g);
		timerdisplay.render(g);
		
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
		
		for (int i = 0; i < iceRockSpawner.size(); i++) {
			iceRockSpawner.get(i).render(g);
		}
		
		for (int i = 0; i < bootRockSpawner.size(); i++) {
			bootRockSpawner.get(i).render(g);
		}
		
		for (int i = 0; i < heartRockSpawner.size(); i++) {
			heartRockSpawner.get(i).render(g);
		}
		
	}

	public void checking(ArrayList<Rocks> list,Player player) {

		for (int i = 0; i < list.size(); i++) {
			if (player.bound().intersects(list.get(i).bound())) {
				list.remove(i);
				list.add(new Smoll_rock(handler, (float)(Math.random() * (1024 - 0 + 1)+ 0),45));
				list.get(i).tick();
				//commented out the minus health logic, now is increase score for each rock
				try {
					if(list.get(i).getEffect()==0) {
						if(player.getSpeed()>1) {
							player.setSpeed((float)(player.getSpeed()*0.5));
						}
					}
					else if(list.get(i).getEffect()==2) {
						if(player.getSpeed()<7) {
							player.setSpeed((float)(player.getSpeed()*2));
						}
					}
				}
				catch(Exception e) {
					System.out.println("debuff failure");
				}
				player.setLife(player.getLife()-list.get(i).getDamage());
				player.setPoints(player.getPoints()+list.get(i).getPoints());
			}
		}
	}
	public void checkHit(Player player) {
		checking(smallRockSpawner, player);
		checking(mediumRockSpawner, player);
		checking(bigRockSpawner, player);
		checking(smallRockSpawner, player);
		checking(fireRockSpawner, player);
		checking(bootRockSpawner, player);
		checking(iceRockSpawner, player);
		checking(heartRockSpawner, player);


	}
	
}
