package gamev3.entity.creature;

import gamev3.entity.Entity;

public abstract class Creature extends Entity{

	protected int life;
	
	public Creature(float x, float y) {
		//super method leads to entity class constructor
		super(x, y);	//with this every creature/ player has a position on the screen
		// TODO Auto-generated constructor stub
		life = 10;
		
	}

}
