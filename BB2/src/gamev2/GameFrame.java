package gamev2;
import java.awt.*;
import javax.swing.*;

//this class houses the panel that draws the game.
public class GameFrame extends JFrame{
	
	//creating instance of gamepanel
	GamePanel panel;
	//constructor
	public GameFrame() {
		this.panel = new GamePanel();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this causes the window to be sized to fit the preferred size and layout of the components
		this.pack(); // ensures that this accommodates the size of the panel
		this.setVisible(true);
		this.setLocationRelativeTo(null);	//when game starts then appear in middle of the screen
	}
}
