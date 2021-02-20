package gamev3.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import gamev3.Handler;
import gamev3.entity.creature.Background;
import gamev3.entity.creature.Player;
import gamev3.gfx.Assets;
import gamev3.ui.ClickListener;
import gamev3.ui.UIImageButton;
import gamev3.ui.UIManager;
import gamev3.GameMain;
import gamev3.states.*;
//every state you have should extend state
public class EndMenuP1 extends State {

	private UIManager uiManager;
	private MenuTest endmenu1;
	private State newgame;
	
	public EndMenuP1(Handler handler) {
		super(handler);
		endmenu1 = new MenuTest(handler,0,0);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		// X, Y, Width, Height, Buffer Image
		uiManager.addObject(new UIImageButton(445, 400, 128, 64, Assets.button_start, new ClickListener() {

			// Just creating an instance of this click listener class on the flag?
			@Override
			public void onClick() {
				Assets.init();
				newgame = new GameState(handler);
				State.setState(newgame);
				//State.setState(handler.getGame().gameState);
			}
		}));
		// from line 21 to here, it allows us to add new button to our game
	}
	
	public static class PixelFont {
		
		static Font pixel;
		static Font pixellarge;
		
		public PixelFont() throws FontFormatException, IOException
		{
			pixel = Font.createFont(Font.TRUETYPE_FONT, new File("/textures/PixelMplus10-Regular.ttf"));
			pixellarge = pixel.deriveFont(100f);
		}
		
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		endmenu1.render(g);
		//g.drawRect(340, 250, 400, 50);
		g.setColor(new Color(255,255,255,128));
		//g.setColor(Color.green.darker());
		g.fillRect(320, 200, 400, 100);
		g.setColor(new Color(34,139,34));
		g.setFont(PixelFont.pixellarge);
		g.drawString("Game Over. Player 1 wins!",340,250);
		
		g.drawString("Press Start to play again",370,280);
		uiManager.render(g);
	}
}

