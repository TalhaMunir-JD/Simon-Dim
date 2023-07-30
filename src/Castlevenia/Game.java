package Castlevenia;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import frameWork.KeyInput;
import frameWork.ObjectId;
import frameWork.Texture;

public class Game extends Canvas implements Runnable {          


	private static final long serialVersionUID = 1L;
	public boolean running = false;
	public Thread thread;       
	public static int HEIGHT,WIDTH;

	public BufferedImage level = null;

	//objects
	Handler handler;
	Camera cam;
	static Texture tex;
	public Menu menu;

	static Music music;

	public static int level_complete = 1;
	private static ObjectId id = ObjectId.Menu; 

	private void init() {      //initializing is done here
		WIDTH = getWidth();      
		HEIGHT = getHeight();


		tex = new Texture();     //this will return the instance of texture

		BufferedImageLoader loader = new BufferedImageLoader();         //object of the class BufferImage Loader


		level = loader.loadImage("/level.png");                          //loads the image of level 1

		cam = new Camera(0,0);       //starting coordinates of the camera will be (0,0)

		handler = new Handler(cam);    // Handler's object 

		menu = new Menu();

		handler.LoadImageLevel(level);    //this will load the first level 

		music = new Music();


		this.addKeyListener(new KeyInput(handler));       //keyboard input
		this.addMouseListener(new MouseInput());          //mouse input

	}


	public synchronized void start() {      //threading 
		if(running)         
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}


	public void run() {

		init();       //initialization method
		this.requestFocus();
		//the below code is running the amount of tick per second is 60
		long lastTime = System.nanoTime();             //gets the System Time
		double amountOfTicks = 60.0;                   //specifies the seconds there are in a minute 
		double ns = 1000000000 / amountOfTicks;        //Set definition of how many ticks per 1000000000 ns or 1 sec

		double delta = 0;                             
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();               //update the time
			delta += (now - lastTime) / ns;              //calculating change in time since last time known 
			lastTime = now;                              //update last known time
			while(delta >= 1){                          //continue if delta is greater than 1
				tick();                                 //calls tick method
				updates++;   
				delta--;                                //decrements delta
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	public static Texture getInstance() {  //returns the object for texture
		return tex;
	}

	private void tick() {
		if(getId() == ObjectId.Game) {
			handler.tick();      //handler is object of class Handler
			for(int i = 0; i< handler.object.size(); i++) {              //looping through the entire thing 
				if(handler.object.get(i).getId() == ObjectId.Player) {   //when an object(player) is found the camera will tick the player with the proper object
					cam.tick(handler.object.get(i));	
				}		
			}

		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();     //buffer strategy for the game 
		if(bs == null) {   //if the buffer is null then create buffer 3
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();          //Creates a graphics context for the drawing buffer.


		g.setColor(Color.decode("#006082"));     //background color
		Graphics2D g2d = (Graphics2D)g;             //casting graphics g into graphics 2d
		g.fillRect(0, 0, getWidth(), getHeight());   // it will fill the whole rectangle with the color whose hex number is #006082 

		if(getId() == ObjectId.Game) {	  

			//the game will start if the state will be game other wise it will be menu
			g2d.translate(cam.getX(), cam.getY());     //begin of cam


			handler.render(g);


			g2d.translate(-cam.getX(), -cam.getY());    //end of cam


		}else if(getId() == ObjectId.Menu) {          //the menu of the game 
			g.drawImage(tex.game_background[0], (int)getX(), (int)getY(), 800, 700, null);   //this will put the background image of the menu
			g.setFont(new Font("arial",Font.BOLD , 40));      
			menu.render(g);                  
		}
		bs.show();     //buffer show
		g.dispose();   //we have to dispose the graphics
	}



	//main function
	public static void main(String[] args) {
		new Window(800 ,700,"Simon Dim",new Game());
	}


	//getters and setters for ObjectId
	public static ObjectId getId() {
		return id;
	}

	public static void setId(ObjectId id) {
		Game.id = id;
	}

}