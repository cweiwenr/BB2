package gamev3;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import gamev3.display.WindowDisplay;
import gamev3.gfx.BackgroundLoader;

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
	
	private BufferedImage testImage;
	
	public GameMain(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;

	}
	
	private void init() {
		//this method will initialize all the graphics and get everything ready for our game
		//we want this display here just so that it is running on the new thread that has been created
		display = new WindowDisplay(title, width, height);
		testImage = BackgroundLoader.loadImage("/textures/background1.png");
	}
	
	private void tick() {
		
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
		g.drawImage(testImage, 0, 0, null);
		
		//end drawing
		bs.show();
		g.dispose();
	}
	public void run() {
		//we want to call init function
		init();
		//while loop to update game variables and update graphics
		while(running) {
			tick();
			render();
		}
		//just incase the loo doesnt stop
		stop();
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
