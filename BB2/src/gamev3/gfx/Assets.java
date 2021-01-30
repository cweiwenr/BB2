package gamev3.gfx;

import java.awt.image.BufferedImage;

//this class is any music image etc.
public class Assets {

	//some dimensions to represent width and height of each stickman in the spritesheet
	private static final int width = 20, height = 40;
	//all the image variables
	public static BufferedImage player, player2, background, rocks, fireRocks;
	public static BufferedImage[] player_right, player_left, player_still;
	
	//this init function is so that the game loads in everything once, instead of having
	//this in the GameMain loops as it is very inefficient
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stickman-anim.png"));
		SpriteSheet rock = new SpriteSheet(ImageLoader.loadImage("/textures/rocks.png"));
		SpriteSheet fireRock = new SpriteSheet(ImageLoader.loadImage("/textures/fire.png"));
		
		//animation sprite
		player_right = new BufferedImage[8];
		player_right[0] = sheet.crop(0, 40, width, height);
		player_right[1] = sheet.crop(20, 40, width, height);
		player_right[2] = sheet.crop(40, 40, width, height);
		player_right[3] = sheet.crop(60, 40, width, height);
		player_right[4] = sheet.crop(80, 40, width, height);
		player_right[5] = sheet.crop(100, 40, width, height);
		player_right[6] = sheet.crop(120, 40, width, height);
		player_right[7] = sheet.crop(140, 40, width, height);
		
		player_left = new BufferedImage[8];
		player_left[0] = sheet.crop(0, 0, width, height);
		player_left[1] = sheet.crop(20, 0, width, height);
		player_left[2] = sheet.crop(40, 0, width, height);
		player_left[3] = sheet.crop(60, 0, width, height);
		player_left[4] = sheet.crop(80, 0, width, height);
		player_left[5] = sheet.crop(100, 0, width, height);
		player_left[6] = sheet.crop(120, 0, width, height);
		player_left[7] = sheet.crop(140, 0, width, height);

		player_still = new BufferedImage[8];
		player_still[0] = sheet.crop(0, 120, width, height);
		player_still[1] = sheet.crop(20, 120, width, height);
		player_still[2] = sheet.crop(40, 120, width, height);
		player_still[3] = sheet.crop(60, 120, width, height);
		player_still[4] = sheet.crop(80, 120, width, height);
		player_still[5] = sheet.crop(100, 120, width, height);
		player_still[6] = sheet.crop(120, 120, width, height);
		player_still[7] = sheet.crop(140, 120, width, height);
		
		//player = sheet.crop(width, 3*height, width, height);
		//player2 = sheet.crop(width,  3*height, width, height);
		background = ImageLoader.loadImage("/textures/background1.png");
		rocks = rock.crop(128, 0, 128, 128);
		fireRocks = fireRock.crop(0,  0, 128,  128);
		
	}
}
