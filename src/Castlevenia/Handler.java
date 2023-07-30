package Castlevenia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import frameWork.GameObject;
import frameWork.ObjectId;
import frameWork.Texture;
import objects.Basket;
import objects.Bat;
import objects.Brick;
import objects.Enemy;
import objects.Player;
import objects.Skull;
import objects.candles;
import objects.point;


public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private GameObject tempObject;
	Texture tex = new Texture();

	BufferedImage level2 = null;
	private Camera cam;


	//constructor of handler
	public Handler(Camera cam) {
		this.cam = cam;
		BufferedImageLoader loader = new BufferedImageLoader();
		level2 = loader.loadImage("/level2.png");
	}

	public void tick() {
		for(int i = 0; i < object.size(); i++) {   //This basically takes the size of object because we don't know how much large object is 
			tempObject = object.get(i);            //assign the Object to tempObject at that particular point 
			tempObject.tick(object);              //call the tick method of that object
		}
	}


	//the render method will loop through the game and when an object is found t6hre render method of that object will be called
	public void render(Graphics g) {

		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);

		}


		Font f0 = new Font("arial" , Font.BOLD, 30);
		g.setFont(f0);
		g.setColor(Color.RED);
		g.drawString("Starting Health  = 10", Game.WIDTH/2 - 250, 200); 

		if(Game.level_complete == 3) {                             //when 2nd level gets complete it will display a the end picture
			clearlevel();   
			g.setColor(Color.black);
			g.fillRect(-310, 0, Game.WIDTH + 1000, Game.HEIGHT+100);
			g.drawImage(tex.theend[0], 100, 0, 410, 635, null);
		}


		if(Player.health < 1) {                        //when health of the player is less than 1 or it would be zero than the game is turned black
			clearlevel();
			g.setColor(Color.black);
			g.fillRect(-310, 0, Game.WIDTH + 3000, Game.HEIGHT+100);
			g.drawImage(tex.theend[0], 100, 0, 239, 156, null);
		}
	}



	//the method will make the level for us and will add different objects
	public void LoadImageLevel(BufferedImage image) {
		int w ,h;
		w = image.getWidth();
		h = image.getHeight();
		System.out.println("Height"+h+"Width"+w);

		for(int xx = 0 ; xx < h ; xx++) {
			for(int yy = 0; yy < w ; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff; 
				int blue = (pixel) & 0xff;

				if(red == 255 && green == 255 & blue == 255) {
					addObject(new Brick(xx*32,yy*32,ObjectId.Block));
				}
				if(red == 0 && green == 0 & blue == 255) {
					addObject(new Player(xx*32, yy*32, this, cam, ObjectId.Player));
				}
				if(red == 255 && green == 0 & blue == 0) {
					addObject(new Enemy(xx*32, yy*32, this, ObjectId.Enemy));     
				}
				if(red == 255 && green == 216 & blue == 0) {
					addObject(new Basket(xx*32, yy*32, this, ObjectId.Basket));      
				}
				if(red == 76 && green == 255 & blue == 0) {
					addObject(new point(xx*32, yy*32, ObjectId.Point));
				}
				if(red == 255 && green == 0 & blue == 220) {
					addObject(new Bat(xx*32, yy*32, ObjectId.Bat));
				}
				if(red == 255 && green == 38 & blue == 49) {
					addObject(new Skull(xx*32, yy*32, this, ObjectId.Skull));
				}
				if(red == 255 && green == 107 & blue == 151) {
					addObject(new candles(xx*32, yy*32, ObjectId.candle));
				}
			}
		}
	}

	//the below method will switch the levels

	public void Switchlevel() {
		clearlevel();
		cam.setX(0);

		switch(Game.level_complete) {
		case 1:
			LoadImageLevel(level2);
			break;
		}

		Game.level_complete++;

	}

	//the method will clear the level
	public void clearlevel() {
		object.clear();
	}


	public void addObject(GameObject object) {   //adds object to the level
		this.object.add(object);
	}

	public void removeObject(GameObject object) {  //removes the object
		this.object.remove(object);
	}
}
