package gamev3.gfx;

import java.awt.image.BufferedImage;

//this class is any music image etc.
public class Assets {

	//some dimensions to represent width and height of each stickman in the spritesheet
	private static final int width = 20, height = 40;
	//all the image variables
	public static BufferedImage player, player2, background;
	//this init function is so that the game loads in everything once, instead of having
	//this in the GameMain loops as it is very inefficient
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stickman-anim.png"));
		player = sheet.crop(width, 3*height, width, height);
		player2 = sheet.crop(width,  3*height, width, height);
		background = ImageLoader.loadImage("/textures/background1.png");
		
	}
}
