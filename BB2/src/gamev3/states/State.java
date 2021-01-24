package gamev3.states;

import java.awt.Graphics;

import gamev3.GameMain;

//this is an abstract class so that game can be at menu or gameplay etc.
public abstract class State {
	
	//state object that holds current state of the game, e.g. menu etc.
	private static State currentState = null;
	
	//allows us to store set and get the current game state, e.g. like a game state manager
	public static void setState(State state) {
		currentState = state;
	}
	
	//get current state of the game
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	protected GameMain game;
	
	public State(GameMain game) {
		this.game = game;
	}
	//every state has same things, tick and render method
	public abstract void tick();
	
	//we need graphics g so that state can draw to screen directly.
	public abstract void render(Graphics g);
	
}
