package Castlevenia;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private int speed;
	private int frames;
	private int index = 0;
	private int count = 0;

	public BufferedImage currentImage;
	private BufferedImage [] images;


	/** In the below method is constructor of the class in which we will pass the speed and the BufferedImage...args 
	 *  which represents we can give as many arguments as we want of type bufferedImage 
	 * 
	 *  speed is initialized with the passed speed 
	 *  The for loop will run till args.length - 1 and in the images array the images will be loaded
	 */

	public Animation(int speed, BufferedImage...args) {
		this.speed = speed;
		images = new BufferedImage[args.length];
		for(int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;

	}

	/**
	 * This method will run the animation
	 * index is incremented
	 * if the index is greater than speed than the index is again zero and nextframe is called
	 */

	public void RunAnimation() {
		index++;                             
		if(index > speed) {                           
			index = 0;
			nextFrame();
		}
	}

	/**
	 *  In the below method we will be writing the nextframe in the animation. The loop will run from 0 till frames - 1
	 *     and when the count will be equal to i then the image at array images, index i, will be assigned to the currentImage
	 *        the count will be incremented so that the next image can be loaded.
	 *           if count goes up than frames then the count will be done zero.   
	 *  
	 */
	private void nextFrame() {                        //it gives the next frame
		for(int i = 0; i < frames; i++) {
			if(count == i) {
				currentImage = images[i];
			}
		}
		count++;
		if(count > frames) {
			count = 0;
		}
	}

	public void drawAnimation(Graphics g, int x, int y, int ScaleX, int ScaleY) {    //this method will also draw the animation but it will not disturb the animation
		g.drawImage(currentImage, x, y, ScaleX, ScaleY, null);
	}

}