package frameWork;

import java.awt.image.BufferedImage;

import Castlevenia.BufferedImageLoader;

public class Texture {

	SpriteSheet ps;    //player sheet
	SpriteSheet es;    //enemy sheet
	SpriteSheet pjs;   //player fight sheet
	SpriteSheet bs;    //block sheet

	SpriteSheet basket;   //basket sheet
	SpriteSheet background;  //background sheet
	SpriteSheet sk;      //skull sheet
	SpriteSheet t_end;     //the end spritesheet

	SpriteSheet bat;     //bat sheet
	SpriteSheet candles;  // candle sheet


	//arrays in which different images will be stored
	public BufferedImage [] Player= new BufferedImage[10];
	public BufferedImage [] enemy = new BufferedImage[10];
	public BufferedImage [] player_fight = new BufferedImage[10];
	public BufferedImage [] Block = new BufferedImage[1];

	public BufferedImage [] Basket = new BufferedImage[2];
	public BufferedImage [] game_background = new BufferedImage[1];
	public BufferedImage [] Skull = new BufferedImage[2];

	public BufferedImage [] theend = new BufferedImage[1];
	public BufferedImage [] Bat = new BufferedImage[3];
	public BufferedImage [] candleimage = new BufferedImage[10]; 


	private BufferedImage player_sheet = null, enemy_sheet = null, Playerfight = null, block = null, game_basket = null
			, gamebackground = null, thend = null, bat_enemy = null, skull = null, can = null;


	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			player_sheet = loader.loadImage("/Simon walk.png");
			enemy_sheet = loader.loadImage("/enemy china.png");
			Playerfight = loader.loadImage("/Simon fight.png");
			block = loader.loadImage("/block.png");

			game_basket = loader.loadImage("/basket.png");
			gamebackground = loader.loadImage("/background help.jpg");
			skull = loader.loadImage("/skull.png");
			thend = loader.loadImage("/The end.png");

			bat_enemy = loader.loadImage("/Bat.png");
			can = loader.loadImage("/candles1.png");

		}catch(Exception e) {
			e.printStackTrace();
		}

		ps = new SpriteSheet(player_sheet);
		es = new SpriteSheet(enemy_sheet);
		pjs = new SpriteSheet(Playerfight);
		bs = new SpriteSheet(block);

		basket = new SpriteSheet(game_basket);
		background = new SpriteSheet(gamebackground);
		sk = new SpriteSheet(skull);
		t_end = new SpriteSheet(thend);

		bat = new SpriteSheet(bat_enemy);
		candles = new SpriteSheet(can);


		getTextures();

	}
	public void getTextures(){
		//walking animation of the player
		Player[0] = ps.grabImage(1, 1, 60, 40);      //col,row,height,width
		Player[1] = ps.grabImage(2, 1, 60, 34);
		Player[2] = ps.grabImage(3, 1, 60, 32);
		Player[3] = ps.grabImage(4, 1, 60, 33);
		Player[4] = ps.grabImage(5, 1, 60, 34);
		Player[5] = ps.grabImage(6, 1, 60, 34);
		Player[6] = ps.grabImage(7, 1, 60, 34);


		//enemy coming towards the object
		enemy[0] = es.grabImage(1, 1, 38, 22);
		enemy[1] = es.grabImage(2, 1, 38, 23);
		enemy[2] = es.grabImage(3, 1, 38, 24);
		enemy[3] = es.grabImage(4, 1, 38, 24);
		enemy[4] = es.grabImage(5, 1, 38, 24);
		enemy[5] = es.grabImage(6, 1, 38, 24);


		//player fight
		player_fight[0] = pjs.grabImage(1, 1, 40, 35);
		player_fight[1] = pjs.grabImage(2, 1, 41, 34);
		player_fight[2] = pjs.grabImage(3, 1, 44, 36);
		player_fight[3] = pjs.grabImage(4, 1, 44, 38);
		player_fight[4] = pjs.grabImage(1, 2, 44, 40);
		player_fight[5] = pjs.grabImage(1, 3, 44, 60);


		//block image
		Block[0] = bs.grabImage(1, 1, 32, 32);
		//col,row,height,width

		//basket image
		Basket[0] = basket.grabImage(1, 1, 30, 20);

		//skull enemy in an image
		Skull[0] = sk.grabImage(1, 1, 67, 60);
		Skull[1] = sk.grabImage(2, 1, 79, 75);

		//the end
		theend[0] = t_end.grabImage(1, 1, 35, 112);


		//bat images in an array
		Bat[0] = bat.grabImage(6, 1, 25, 20);
		Bat[1] = bat.grabImage(7, 1, 19, 21);
		Bat[2] = bat.grabImage(8, 1, 24, 22);

		//menu background
		game_background[0] = background.grabImage(1, 1, 640, 640);      //Starting menu sheet

		//candles stand image
		candleimage[0] = candles.grabImage(1, 1, 55, 30);


	}
}