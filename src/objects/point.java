package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;


import frameWork.GameObject;
import frameWork.ObjectId;

public class point extends GameObject {      //inheritance

	//constructor
	public point(float x, float y, ObjectId id) {
		super(x, y, id);
	}


	public void tick(LinkedList<GameObject> object) {		
	}


	//this will draw a rectangle and set its color to green
	public void render(Graphics g) {	
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 32, 32);
	}


	//rectangle for the collision bounding of the point
	public Rectangle getbounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}


}
