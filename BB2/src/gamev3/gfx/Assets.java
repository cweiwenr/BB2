package gamev3.gfx;

import java.awt.image.BufferedImage;

//this class is any music image etc.
public class Assets {

	//some dimensions to represent width and height of each stickman in the spritesheet
	private static final int width = 20, height = 40, w=55;
	//all the image variables
	public static BufferedImage player, player2, background, rocks, fireRocks,iceRocks,bootRocks,heartRocks,menu;
	public static BufferedImage[] player_right, player_left, player_still,player2_left,player2_right,player2_still;
	public static BufferedImage[] button_start;
	
	//this init function is so that the game loads in everything once, instead of having
	//this in the GameMain loops as it is very inefficient
	public static void init() {
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stickman-anim.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/newChar.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/player2.png"));
		SpriteSheet rock = new SpriteSheet(ImageLoader.loadImage("/textures/rocks.png"));
		SpriteSheet start_button_icon = new SpriteSheet(ImageLoader.loadImage("/textures/start_button.png"));
		
		//trying to add button
		button_start = new BufferedImage[2];
		button_start[0] = sheet.crop(0, 40, width, height);
		button_start[1] = sheet.crop(20, 40, width, height);
		

		SpriteSheet fireRock = new SpriteSheet(ImageLoader.loadImage("/textures/fire.png"));
		SpriteSheet iceRock = new SpriteSheet(ImageLoader.loadImage("/textures/ice.png"));
		SpriteSheet bootRock = new SpriteSheet(ImageLoader.loadImage("/textures/boot.png"));
		SpriteSheet heartRock = new SpriteSheet(ImageLoader.loadImage("/textures/heart.png"));
		
		//animation sprite
		player_still = new BufferedImage[1];
		player_still[0] = sheet.crop(0, 0, w, 49);
		
		player_right = new BufferedImage[1];
		player_right[0] = sheet.crop(100,0 , w, 49);
		
		player_left = new BufferedImage[1];
		player_left[0] = sheet.crop(0, 0, w, 49);
		
		//animation sprite
		/*
		player2_right = new BufferedImage[8];
		player2_right[0] = sheet2.crop(0, 40, width, height);
		player2_right[1] = sheet2.crop(20, 40, width, height);
		player2_right[2] = sheet2.crop(40, 40, width, height);
		player2_right[3] = sheet2.crop(60, 40, width, height);
		player2_right[4] = sheet2.crop(80, 40, width, height);
		player2_right[5] = sheet2.crop(100, 40, width, height);
		player2_right[6] = sheet2.crop(120, 40, width, height);
		player2_right[7] = sheet2.crop(140, 40, width, height);
		
		player2_left = new BufferedImage[8];
		player2_left[0] = sheet2.crop(0, 0, width, height);
		player2_left[1] = sheet2.crop(20, 0, width, height);
		player2_left[2] = sheet2.crop(40, 0, width, height);
		player2_left[3] = sheet2.crop(60, 0, width, height);
		player2_left[4] = sheet2.crop(80, 0, width, height);
		player2_left[5] = sheet2.crop(100, 0, width, height);
		player2_left[6] = sheet2.crop(120, 0, width, height);
		player2_left[7] = sheet2.crop(140, 0, width, height);

		player2_still = new BufferedImage[8];
		player2_still[0] = sheet2.crop(0, 120, width, height);
		player2_still[1] = sheet2.crop(20, 120, width, height);
		player2_still[2] = sheet2.crop(40, 120, width, height);
		player2_still[3] = sheet2.crop(60, 120, width, height);
		player2_still[4] = sheet2.crop(80, 120, width, height);
		player2_still[5] = sheet2.crop(100, 120, width, height);
		player2_still[6] = sheet2.crop(120, 120, width, height);
		player2_still[7] = sheet2.crop(140, 120, width, height);
		
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
		
		*/
		
		//player = sheet.crop(width, 3*height, width, height);
		//player2 = sheet.crop(width,  3*height, width, height);
		background = ImageLoader.loadImage("/textures/bgtest2.jpg");
		menu = ImageLoader.loadImage("/textures/bgtest2.jpg");
		rocks = rock.crop(128, 0, 128, 128);
		fireRocks = fireRock.crop(0,  0, 128,  128);
		iceRocks = iceRock.crop(0,  0, 128,  128);
		bootRocks = bootRock.crop(0,  0, 128,  128);
		heartRocks = heartRock.crop(0,  0, 128,  128);
		
		
	}
}
