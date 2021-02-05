package gamev3;

import gamev3.input.KeyManager;
import gamev3.input.MouseManager;

//allows us to pass objects to handle variables.
public class Handler {
	
	private GameMain game;
	
	public Handler (GameMain game) {
		this.game = game;
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	public GameMain getGame() {
		return game;
	}

	public void setGame(GameMain game) {
		this.game = game;
	}
	
}
