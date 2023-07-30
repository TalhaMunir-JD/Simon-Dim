package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Castlevenia.Game;
import Castlevenia.Handler;
import frameWork.GameObject;
import frameWork.ObjectId;
import frameWork.Texture;

public class Basket extends GameObject{    //inheritance

	//fields declaration and initialization
	private Handler handler;
	private float height;
	private float width;
	Texture tex = Game.getInstance();   //will give the instance of the Texture

	//constructor
	public Basket(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}


	//the tick method is used for the collision bounding of the basket 
	public void tick(LinkedList<GameObject> object) {
		CollisionBounds(object);
	}


	//collision bounding method
	private void CollisionBounds(LinkedList<GameObject> object) {
		//looping through the game 
		for(int i = 0; i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(getbounds().intersects(tempObject.getbounds())){
				//and when it's rectangle is intersected with any of the rectangle
				if(tempObject.getId() == ObjectId.Block){  // if the objectId is block
					y = tempObject.getY() - height;   //this will make the position correct for the basket    
				}
			}
		}
	}

	//this will draw the image
	public void render(Graphics g) {
		g.drawImage(tex.Basket[0], (int)x, (int)y, 23, 30,null);
	}


	//this will make the rectangle for the basket 
	public Rectangle getbounds() {
		return new Rectangle((int)x, (int)y,(int)width +24,(int)width +30);
	}


}
