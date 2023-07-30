package Castlevenia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Menu {

	//it will create rectangle for start game, quit game, and help button
	public Rectangle playButton = new Rectangle(Game.WIDTH/2 - 100, 250, 200, 50);
	public Rectangle exitButton = new Rectangle(Game.WIDTH/2 - 100, 350, 200, 50);
	public Rectangle helpButton = new Rectangle(Game.WIDTH/2 - 100, 450, 200, 50);


	public void render(Graphics g) {
		Graphics2D g2d =  (Graphics2D)g;

		//below code will draw the text simon dim
		Font f0 = new Font("Dialog" , Font.BOLD, 50);
		g.setFont(f0);
		g.setColor(Color.decode("#392440"));
		g.drawString("Simon Dim", Game.WIDTH/2 - 220, 150);


		//below code will draw the text start game 
		Font f1 = new Font("arial",Font.BOLD,30);
		g.setFont(f1);
		g.setColor(Color.decode("#4f018a"));
		g.drawString("Start Game", playButton.x + 20, playButton.y + 30);
		g2d.setColor(Color.black);


		//below code will draw the text Quit game
		g.setFont(f1);
		g.setColor(Color.decode("#4f018a"));
		g.drawString("Quit Game", exitButton.x + 20, exitButton.y + 30);
		g2d.setColor(Color.black);


		//below code will draw the text help
		g.setFont(f1);
		g.setColor(Color.decode("#4f018a"));
		g.drawString("Help", helpButton.x + 70, helpButton.y + 30);
		g2d.setColor(Color.black);


		//this will draw the rectangles
		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(exitButton);


	}
}
