package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import Castlevenia.Animation;
import Castlevenia.Camera;
import Castlevenia.Game;
import Castlevenia.Handler;
import frameWork.GameObject;
import frameWork.ObjectId;
import frameWork.Texture;

public class Player extends GameObject{            //inheritance

	//declaration and initialization of the fields
	private float width = 32 ,height = 64;
	private final float max_vel = 10;
	private Handler handler;
	Texture tex = Game.getInstance();   //texture's instance 
	private Animation PlayerWalk, Playerfight;
	private float gravity = 0.05f;
	Camera cam;
	public static int health = 10;

	//constructor
	public Player(float x, float y,Handler handler,Camera cam, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		this.cam = cam;
		PlayerWalk = new Animation(15, tex.Player[1], tex.Player[2], tex.Player[3], tex.Player[4], tex.Player[5], tex.Player[6]);
		Playerfight = new Animation(5, tex.player_fight[0], tex.player_fight[1], tex.player_fight[2], tex.player_fight[3], tex.player_fight[4], tex.player_fight[5]);

	}



	//the method will decide the x and y velocity of the player and will run the animation 
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;

		if(falling || jumping) {
			velY += gravity;

			if(velY > max_vel) {
				y = max_vel;
			}
		}

		CollisionBounds(object);
		PlayerWalk.RunAnimation();
		Playerfight.RunAnimation();
	}

	//collision bounding method
	private void CollisionBounds(LinkedList<GameObject> object) {
		for(int i = 0; i < handler.object.size();i++) {

			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Block) {
				//top bounds	
				if(getbounds_up().intersects(tempObject.getbounds())) {
					y = tempObject.getY() + height-20;
					velY = 0;   
				}
				//bottom collision for the blocks
				if(getbounds().intersects(tempObject.getbounds())) {
					y = tempObject.getY() - height;
					velY = 0;
					jumping = false;
					falling = false;
				}
				if(tempObject.getId() == ObjectId.Point) {
					handler.Switchlevel();
				}

			}else{
				falling = true;
			}

			//right collision for every object including enemies
			if(getbounds_right().intersects(tempObject.getbounds())) {
				if(tempObject.getId() == ObjectId.Enemy) {
					handler.removeObject(tempObject);
					health = health - 2;
				}
				if(tempObject.getId() == ObjectId.Basket) {  //removes the basket of it is found in the way or the player hits the basket
					handler.removeObject(tempObject);
					health++;
				}
				if(tempObject.getId() == ObjectId.candle) {  //removes the basket of it is found in the way or the player hits the basket
					handler.removeObject(tempObject);
					health++;
				}
				if(tempObject.getId() == ObjectId.Point) { //switch the level if the point is found
					handler.Switchlevel();
				} 
				if(tempObject.getId() == ObjectId.Skull) {  //removes the skull if it collides with the player
					handler.removeObject(tempObject);
					health = health - 2;
				}
				x = tempObject.getX() - width;
			}
			//left collision for every object including enemies 
			if(getbounds_left().intersects(tempObject.getbounds())) {
				x = tempObject.getX() + width ;
				if(tempObject.getId() == ObjectId.Basket) {
					handler.removeObject(tempObject);
					health++;
				}
			}
		}
	}

	//will draw the animation of the player on basis of the speed of the player
	public void render(Graphics g) {
		if(velX == 2 || velX == -2) {
			PlayerWalk.drawAnimation(g, (int)x, (int)y, 40, 70);
		}else if(velX == 0.5) {
			Playerfight.drawAnimation(g, (int)x, (int)y, 55, 70);
		}else 
			g.drawImage(tex.Player[0], (int)x, (int)y, 55, 70, null);   //second one decides the height of the image  // first one decides the width of the image	

	}
	//bottom rectangle for the collision bounding of the player
	public Rectangle getbounds() {
		return new Rectangle((int) ((int)x +(width/2)-((width/2)/2)), (int) ((int)y + (height/2)), (int)width/2, (int)height/2);
	}
	//upper rectangle for the collision bounding of the player
	public Rectangle getbounds_up() {		
		return new Rectangle((int) ((int)x +(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
	//right rectangle for the collision bounding of the player
	public Rectangle getbounds_right() {		
		return new Rectangle((int) ((int)x + width - 5), (int)y + 5, (int)5, (int)height - 10);
	}
	//left rectangle for the collision bounding of the player
	public Rectangle getbounds_left() {		
		return new Rectangle((int)x, (int)y + 5, (int)5, (int)height - 10);
	}
}