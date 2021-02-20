package gamev3.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamev3.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager() { // similar to KeyManager
		
	}
	// Simple variable storing in mouse manager
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	// Getters
	public boolean isLeftPressed() {
		return leftPressed;
	}
	
	public boolean isRightPressed() {
		return rightPressed;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	
	// Implemented Methods

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			if(e.getButton() == MouseEvent.BUTTON1)
				leftPressed = false;
			else if (e.getButton() == MouseEvent.BUTTON3)
				rightPressed = false;
		}catch (RuntimeException a){
			System.out.println("Mouse pressed error");
		}
		
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		
		if(uiManager != null)
			uiManager.onMouseRelease(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) { //Whenever mouse move in game window
		mouseX = e.getX();
		mouseY = e.getY();	
		
		if(uiManager != null)
			uiManager.OnMouseMove(e);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

		
	
}
