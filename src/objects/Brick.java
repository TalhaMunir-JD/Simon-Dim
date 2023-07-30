package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Castlevenia.Game;
import frameWork.GameObject;
import frameWork.ObjectId;
import frameWork.Texture;

public class Brick extends GameObject{   //inheritance

	Texture tex = Game.getInstance();  //will give the instance of the Texture  

	//constructor
	public Brick(int x, int y, ObjectId id) {
		super(x, y, id);	
	}	 


	public void tick(LinkedList<GameObject> object) {
	}

	//will draw the image of the block 
	public void render(Graphics g){
		g.drawImage(tex.Block[0], (int)x, (int)y, null );
	}


	//rectangle for the collision bounding of the block
	public Rectangle getbounds() {		
		return new Rectangle((int)x,(int)y,32,32);
	}
}

