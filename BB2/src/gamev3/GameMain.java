package gamev3;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import gamev3.display.WindowDisplay;
import gamev3.gfx.Assets;
import gamev3.input.KeyManager;
import gamev3.states.GameState;
import gamev3.states.Menu;
import gamev3.states.State;

//allow game class to run on a thread, by implementing runnable
public class GameMain implements Runnable{

	private WindowDisplay display;
	public int width,height;
	public String title;
	
	//making thread, roughly, when you start the game, it creates a big program for all the code to run
	//but we want our gamemain class to run on a mini program. 
	//so when we run this gamemain, it will run separately from the rest of the classes.
	private boolean running = false;
	private Thread thread;
	
	//variables to render graphics
	//a buffer is a hidden computer screen in your computer
	// its just memory that holds the data, so we can draw everything on the buffer first
	//then can transfer to actual screen so that players can see it
	//this is to prevent flickering in the game
	private BufferStrategy bs;
	private Graphics g;
	
	//States, we declare every state we have here, so menu etc.
	private State gameState;
	private State menu;

	//declaring variables to listen for key inputs
	private KeyManager keyManager;
	
	private Handler handler;
	
	public GameMain(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() {
		//this method will initialize all the graphics and get everything ready for our game
		//we want this display here just so that it is running on the new thread 
		display = new WindowDisplay(title, width, height);
		//this adds key listeners so that we can listen for inputs, allowing us to access the keyboard
		display.getFrame().addKeyListener(keyManager);
		Assets.init();	//have to call this init so that all the resources gets 'loaded'
				
		handler = new Handler(this);
		
		//initialize your game states here, we want them to init when we init this game main
		gameState = new GameState(handler);
		menu = new Menu(handler);
		State.setState(gameState);
	}

	private void tick() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	//everytime this render method is runned, we need to set bufferstrategy to
	//the display canvas
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		//if buffer object has not been created, create it first.
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		//drawing onto the buffer
		g = bs.getDrawGraphics();
		//before drawing anything, we have to clear the screen for every loop
		g.clearRect(0, 0, width, height);//this clears the entire screen
		//graphics object allows us to draw things onto the buffer,
		//Draw here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		/*
		g.drawImage(Assets.background, 0, 0, null);
		g.drawImage(Assets.player, 256, 410, null);
		g.drawImage(Assets.player2, 768, 410, null);*/

		//end drawing
		bs.show();
		g.dispose();
	}
	public void run() {
		//we want to call init function
		init();
		
		int fps = 60;	//how much fps you want
		double timePerTick = 1000000000/ fps;	//how many times tick and render method run per second
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		//while loop to update game variables and update graphics
		while(running) {
			
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			//condition to know when to run tick and render method
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		//just incase the loop doesnt stop
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	//method for starting new thread
	public synchronized void start() {
		//we have to check if game is already running, if so then do not start the whole thing again
		// if not then proceed with the synch function
		if(running)
			return;
		else {
		//thread constructor takes in what class u want to run
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	//method for stopping the thread
	public synchronized void stop() {
		//same thing, check if game already stop
		if (!running)
			return;
		else {
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
