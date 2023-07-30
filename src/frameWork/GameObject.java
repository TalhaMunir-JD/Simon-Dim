package frameWork;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {   //abstract class

	/**
	 * All the fields are declared
	 */
	protected float velX = 0,velY = 0;
	protected ObjectId id;
	protected float x = 0;
	protected float y = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	protected boolean walking = true;

	public abstract void tick(LinkedList<GameObject>object);
	public abstract void render (Graphics g);
	public abstract Rectangle getbounds();

	public GameObject(float x, float y,ObjectId id) {            //constructor
		this.x = x;
		this.y = y;
		this.id = id;
	}
	//getter setters of all the variables

	public boolean isWalking() {
		return walking;
	}

	public void setWalking(boolean walking) {
		this.walking = walking;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}	
	public  float getVelX() {
		return velX; 
	}

	public  void setVelX(float velX) {
		this.velX = velX;
	}

	public  float getVelY() {
		return velY;
	}

	public  void setVelY(float velY) {
		this.velY = velY;
	}

	public  float getX() {
		return x;
	}

	public  void setX(float x) {
		this.x = x;
	}

	public  float getY() {
		return y;
	}

	public  void setY(float y) {
		this.y = y;
	}

	public  ObjectId getId() {
		return id;
	}
}
