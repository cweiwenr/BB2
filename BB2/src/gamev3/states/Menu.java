package gamev3.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gamev3.Handler;
import gamev3.states.MenuTest;
import gamev3.display.PixelFont;
import gamev3.gfx.Assets;
import gamev3.ui.ClickListener;
import gamev3.ui.UIImageButton;
import gamev3.ui.UIManager;

//every state you have should extend state
public class Menu extends State {

	private UIManager uiManager;
	private MenuTest menu;
	
	public Menu(Handler handler) {
		super(handler);
		menu = new MenuTest(handler,0,0);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		// X, Y, Width, Height, Buffer Image
		uiManager.addObject(new UIImageButton(445, 200, 128, 64, Assets.button_start, new ClickListener() {

			// Just creating an instance of this click listener class on the flag?
			@Override
			public void onClick() {	
				State.setState(handler.getGame().gameState);
			}
		}));
		// from line 21 to here, it allows us to add new button to our game

	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		menu.render(g);
		uiManager.render(g);
		g.setColor(new Color(255,255,255,128));
		g.fillRect(320, 300, 410, 130);
		g.setFont(new Font("pixel", Font.PLAIN, 14));
		g.setColor(Color.black);
		g.drawString("P1 (Left player) moves with 'A' and 'D' key",340,320);
		g.drawString("P2 (Right player) moves with 'Left' and 'Right' arrow key",340,340);
		g.drawString("Avoid the grey rocks which deducts your HP and points.",340,360);
		g.drawString("Collect the other rocks for points and unknown boosts!",340,380);
		g.drawString("Player with the highest points wins!",340,400);
		g.drawString("Game ends when 1 player dies, so strategize well!",340,420);	
	}

}
