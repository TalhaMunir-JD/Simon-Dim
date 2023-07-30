package Castlevenia;

import frameWork.GameObject;

public class Camera {

	private float x,y;

	public Camera(float x, float y) {       //constructor of the class
		this.x = x;
		this.y = y;
	}

	public void tick(GameObject player) {
		x = - player.getX() + Game.WIDTH/2;    //this will start the game from right point 
	}


	//getter and setters for the fields
	public float getX() {
		return  x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}

}
