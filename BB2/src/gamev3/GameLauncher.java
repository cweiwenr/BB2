package gamev3;

import gamev3.display.WindowDisplay;
public class GameLauncher {

	//this launcher class is responsible for starting up our game. 
	//this is the sole function of this class
	public static void main (String[] args) {
		GameMain game = new GameMain("Title!", 1024, 512);
		//start function from GameMaine class to initialize the thread and start the game
		game.start();
	}
}
