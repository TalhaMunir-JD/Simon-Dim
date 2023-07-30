package Castlevenia;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	private BufferedImage image;

	public BufferedImage loadImage(String path) {    //the method will load the image
		try {
			image = ImageIO.read(getClass().getResource(path));      //this will read the path of the image 
		} catch (IOException e) {                   //if the path is not right it will throw the error
			e.printStackTrace();
		}
		return image;    //return the image
	}
}
