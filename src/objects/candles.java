package objects;

import java.awt.Graphics;

import java.awt.Rectangle;
import java.util.LinkedList;
import Castlevenia.Game;
import frameWork.GameObject;
import frameWork.ObjectId;
import frameWork.Texture;

public class candles extends GameObject{    //inheritance

	//fields declaration and initialized 
	private float width = 32 ,height = 32;
	Texture tex = Game.getInstance();   //will return the instance of texture  
	//constructor
	public candles(float x, float y, ObjectId id) {
		super(x, y, id);
	}



	public void tick(LinkedList<GameObject> object) {
	}


	//will draw the image of the candles
	public void render(Graphics g) {
		g.drawImage(tex.candleimage[0], (int)x, (int)y, 32, 34, null);
	}

	//rectangle for the collision bounding of candles
	public Rectangle getbounds() {
		return new Rectangle((int)x, (int)y, (int)(width), (int)(height));
	}

}



