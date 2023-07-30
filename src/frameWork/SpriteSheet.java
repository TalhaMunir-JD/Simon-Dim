package frameWork;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;

	public SpriteSheet(BufferedImage image) {       //constructor
		this.image = image;
	}


	//this method will fetch the image from the sheet by providing the parameters
	public BufferedImage grabImage(int col, int row, int height, int width) {
		BufferedImage img = image.getSubimage(( col * width) - width, (row * height) - height, width, height);
		return img;		
	}

}