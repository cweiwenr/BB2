package gamev3.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//this class manages the input/ player controls
public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean left1, right1, left, right;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		//assigning variables to key inputs
		left1 = keys[KeyEvent.VK_A];
		right1 = keys[KeyEvent.VK_D];
		right = keys[KeyEvent.VK_RIGHT];
		left = keys[KeyEvent.VK_LEFT];
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//key is pressed, then true
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//key not being pressed, then false
		keys[e.getKeyCode()] = false;
	}

}
