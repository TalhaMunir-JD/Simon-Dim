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

public class Skull extends GameObject{    //inheritance

	//fields initialized and declared
	private float width = 32 ,height = 32;
	private Handler handler;
	private Animation anim;
	Texture tex_e = Game.getInstance();   //will return the instance of texture
	public Skull(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		anim = new Animation(30, tex_e.Skull[1], tex_e.Skull[0]);
	}



	//will move the skull towards the player and collision bounding method is called
	public void tick(LinkedList<GameObject> object) {

		if(walking == true) {
			x = (float) (x - 0.5);
		}
		CollisionBounds(object);
		anim.RunAnimation();
	}

	//collision bounding method
	private void CollisionBounds(LinkedList<GameObject> object) {
		for(int i = 0; i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			//bottom bound
			if(getbounds().intersects(tempObject.getbounds())) {
				if(tempObject.getId() == ObjectId.Block) { //if the block is found and it's getbounds intersects with any of the object's getbounds then
					y = tempObject.getY() - height;    //correct position of the skull is recognized
				}
			}
		}
	}	

	//the method will draw the animation of the skull
	public void render(Graphics g) {
		anim.drawAnimation(g, (int)x,(int) y, 32, 32);   				   
	}

	//rectangle for the collision bounding of the skull
	public Rectangle getbounds() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
}
