package Castlevenia;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import frameWork.ObjectId;

public class MouseInput implements MouseListener{    //abstraction


	JFrame framehelp = new JFrame();
	JLabel labelhelp = new JLabel();
	JLabel labelhelp1 = new JLabel();
	JLabel labelhelp2 = new JLabel();
	JLabel labelhelp3 = new JLabel();
	JLabel labelhelp4 = new JLabel();
	JLabel labelhelp5 = new JLabel();
	JLabel labelhelp6 = new JLabel();
	JLabel labelhelp7 = new JLabel();
	JLabel labelhelp8 = new JLabel();
	JLabel labelhelp9 = new JLabel();
	JLabel labelhelp10 = new JLabel();

	public void mousePressed(MouseEvent e) {

		int mx = e.getX();      //mx gets the value of x where the mouse is clicked
		int my = e.getY();      //my gets the value of y where the mouse is clicked


		/**  public Rectangle playButton = new Rectangle(Game.WIDTH/2 + 105, 250, 200, 50);
	     public Rectangle exitButton = new Rectangle(Game.WIDTH/2 + 105, 350, 200, 50);
	     public Rectangle helpButton = new Rectangle(Game.WIDTH/2 + 105, 450, 200, 50);
		 */


		/**
		 * when the mouse is clicked at mx >= Game.WIDTH/2 - 100 && mx <= Game.WIDTH/2 + 100
		 *    basically in the specified
		 *       width only then it will be executed
		 */
		if(mx >= Game.WIDTH/2 - 100 && mx <= Game.WIDTH/2 + 100) {
			//play game button clicked
			if(my >= 250 && my <= 300) {
				Game.setId(ObjectId.Game);
				Game.music.PlayMusic("Audio.wav");
			}
			//exit button clicked
			/**
			 * If the Y ranges of the exit button is clicked then it exits the  
			 */
			if(my >= 350 && my <= 400) {
				System.exit(1);
			}
			//help button clicked
			if(my >= 450 && my <= 500) {

				/**
				 * If the Help button is pressed than a new frame will open and will show
				 *    some instructions before starting the game.
				 *       labels set the text on the frame 
				 *          then the panel is added on the frame and the panel then labels
				 *             and after that the panel color is changed.
				 */

				framehelp.setVisible(true);
				framehelp.setSize(250,300);


				//text is setting for the labels.
				labelhelp.setText("Press right arrow to move forward  ");
				labelhelp1.setText("Press left arrow to move backward ");
				labelhelp2.setText("Press upper arrow to move jump ");
				labelhelp3.setText("Press A to make a chain move");
				labelhelp4.setText("If you want to escape from the game ");
				labelhelp5.setText("Press escape button");
				labelhelp6.setText("You will lose the game when ");
				labelhelp7.setText("you will have 1 life left ");
				labelhelp8.setText("Enemies will decrement the life by 2");
				labelhelp9.setText("Baskets and candles will increase ");
				labelhelp10.setText("health by 1");


				JPanel panel = new JPanel();
				framehelp.add(panel);

				/**
				 * panel is adding the labels
				 */
				panel.add(labelhelp);
				panel.add(labelhelp1);
				panel.add(labelhelp2);
				panel.add(labelhelp3);
				panel.add(labelhelp4);
				panel.add(labelhelp5);
				panel.add(labelhelp6);
				panel.add(labelhelp7);
				panel.add(labelhelp8);
				panel.add(labelhelp9);
				panel.add(labelhelp10);
				

				panel.setBackground(Color.cyan);		
				framehelp.setResizable(false);		
				framehelp.setLocationRelativeTo(null);
				framehelp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  //hide on close
			}
		}
	}


	public void mouseClicked(MouseEvent e) {	
	}

	public void mouseReleased(MouseEvent e) {		
	}

	public void mouseEntered(MouseEvent e) {		
	}

	public void mouseExited(MouseEvent e) {		
	}
}
