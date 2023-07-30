package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Castlevenia.Animation;
import Castlevenia.Game;
import frameWork.GameObject;
import frameWork.ObjectId;
import frameWork.Texture;

public class Bat extends GameObject{    //inheritance

	//fields declaration and initialization
	private float width = 32 ,height = 16;
	private Animation enemy_bat;
	Texture tex_e = Game.getInstance();

	//constructor
	public Bat(float x, float y, ObjectId id) {
		super(x, y, id);
		enemy_bat = new Animation(15, tex_e.Bat[0], tex_e.Bat[1], tex_e.Bat[2]);
	}

	public void tick(LinkedList<GameObject> object) {  //this will make the bat move towards the player 
		x = (float) (x - 0.5) ;
		enemy_bat.RunAnimation();
	}


	//the method will draw the animation of the bat
	public void render(Graphics g) {
		enemy_bat.drawAnimation(g, (int)x, (int)y, 32, 32);    //second wala height hai first wala width hai
	}

	//the method will draw the rectangle for the collision bounding
	public Rectangle getbounds() {
		return new Rectangle((int)x, (int)y, (int)(width - width), (int)(height - height));
	}
}
