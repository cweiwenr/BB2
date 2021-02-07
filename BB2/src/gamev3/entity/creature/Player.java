package gamev3.entity.creature;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gamev3.Handler;
import gamev3.gfx.Animation;
import gamev3.gfx.Assets;

//now this is the class that we want the player to control
public class Player extends Creature{
	
	//Animations
	private Animation animRight, animStill, animLeft;
	
	//this variable allows us to access gamemain properties
	private Handler handler;
	private int id;
	
	public Player(Handler handler, float x, float y, int id) {
		super(handler, x, y, Creature.DEFAULT_CHARACTER_WIDTH, Creature.DEFAULT_CHARACTER_HEIGHT);
		this.handler = handler;
		this.id = id;
		
		//collision box how many pixels left of the player
		bounds.x = 5;
		//collision box how many pixels down of the player
		bounds.y = 4;
		//size of collision box
		bounds.width = 10;
		bounds.height = 30;
		
		if (this.id == 1) {
			animRight = new Animation(30, Assets.player_right);
			animStill = new Animation(150,Assets.player_still);
			animLeft = new Animation(30,Assets.player_left);
		}else {
			animRight = new Animation(30, Assets.player2_right);
			animStill = new Animation(150,Assets.player2_still);
			animLeft = new Animation(30,Assets.player2_left);
		}

	}

	@Override
	public void tick() {
		//Animation
		animRight.tick();
		animStill.tick();
		animLeft.tick();
		//update any variables for the object
		getInput();
		move();
		
		//to check life depletion
		//System.out.println(getLife());

	}
	//managing and handling what input does
	private void getInput() {
		xMove = 0;

		if(handler.getKeyManager().right1 && this.id == 1)
			xMove = +speed;
		if(handler.getKeyManager().left1 && this.id == 1)
			xMove = -speed;
		if(handler.getKeyManager().right && this.id == 2)
			xMove = +speed;
		if(handler.getKeyManager().left && this.id == 2)
			xMove = -speed;
	}
	@Override
	public void render(Graphics g) {
		//drawimage takes in an int thus need to type cast
		g.drawImage(getCurrentAnimationFrame(), (int)x, (int)y, null);
			
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		if (this.id == 1) {
			g.drawString(("Player 1 health: "+Float.toString(this.life)), 15, 18);
			g.drawString(("Player 1 points: " + Float.toString(this.points)), 15, 35);
		}else {
			g.setColor(Color.ORANGE);
			g.drawString(("Player 2 health: "+Float.toString(this.life)), 900, 18);
			g.drawString(("Player 2 points: "+Float.toString(this.points)), 900, 35);
		}
		
		//check collision box around player
		//remove this code after finishing collision
		/*
		g.setColor(Color.red);
		g.fillRect((int)(x + bounds.x),(int)(y+bounds.y),
				bounds.width,bounds.height);*/
	}

	private String toString(float life) {
		// TODO Auto-generated method stub
		return null;
	}

	private BufferedImage getCurrentAnimationFrame() {
		if(xMove<0) {
			return animLeft.getCurrentFrame();
		}else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}else {
			return animStill.getCurrentFrame();
		}
	}
}
