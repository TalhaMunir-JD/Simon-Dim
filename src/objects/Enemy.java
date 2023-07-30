package objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Castlevenia.Animation;
import Castlevenia.Game;
import Castlevenia.Handler;
import frameWork.GameObject;
import frameWork.ObjectId;
import frameWork.Texture;

public class Enemy extends GameObject{    //inheritance

	//fields declaration and initialized
	private float width = 32 ,height = 64;
	private Handler handler;
	private Animation enemy_coming;

	Texture tex_e = Game.getInstance(); //will return the instance of texture 

	//constructor
	public Enemy(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		enemy_coming = new Animation(30, tex_e.enemy[5], tex_e.enemy[4], tex_e.enemy[3], tex_e.enemy[2], tex_e.enemy[1], tex_e.enemy[0]);
	}



	//will move the enemy towards the player and collision bounding method is called 
	public void tick(LinkedList<GameObject> object) {

		if(walking == true) {     //if walking is true then move the enemy to the player
			x = (float) (x - 0.5);
		}
		CollisionBounds(object);
		enemy_coming.RunAnimation();
	}

	//collision bounding method
	private void CollisionBounds(LinkedList<GameObject> object) {
		for(int i = 0; i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			//bottom bound
			if(tempObject.getId() == ObjectId.Block) {  //if the block is found and it's getbounds intersects with any of the object's getbounds then 
				if(getbounds().intersects(tempObject.getbounds())) {
					y = tempObject.getY() - height;   //setting the correct position
					walking = true;
				}
			}

		}
	}	

	//will draw the animation of the enemy
	public void render(Graphics g) {
		enemy_coming.drawAnimation(g, (int)x, (int)y, 30, 64);    //second wala height hai first wala width hai
	}

	//rectangle for the collision bounding of the Enemy
	public Rectangle getbounds() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
}
