package frameWork;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Castlevenia.Handler;

public class KeyInput extends KeyAdapter implements KeyListener {      //abstraction


	Handler handler;
	public int Key;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}


	//below method will move the player when a certain key is pressed 
	public void keyPressed(KeyEvent e) {
		Key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++ ) {

			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ObjectId.Player) {

				if(Key == KeyEvent.VK_RIGHT) {            //if right arrow key is pressed the velocity of the player will be 2 and the player will move right
					tempObject.setVelX(2);
				}

				if(Key == KeyEvent.VK_LEFT) {                //if left arrow key is pressed the velocity of the player will be -2 and the player will move left
					tempObject.setVelX(-2);
				}

				if(Key == KeyEvent.VK_UP && !tempObject.isJumping())         //the method will make the player jump  
				{
					tempObject.setJumping(true);
					tempObject.setVelY(-5);
				}

			}
			if(Key == KeyEvent.VK_A) {
				tempObject.setVelX((float) 0.5);
			}

			if(Key == KeyEvent.VK_ESCAPE) {                              //if escape is pressed the window will exit
				System.exit(1); 
			}
		}
	}

	//the method will make the velocity of the player zero  
	public void keyReleased(KeyEvent e) {     
		int Key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++ ) {

			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ObjectId.Player) {

				if(Key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
				}
				if(Key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
				}
				if(Key == KeyEvent.VK_UP ) 
				{
					tempObject.setVelY(0);
				}
				if(Key == KeyEvent.VK_A) {
					tempObject.setVelX(0);
				}

			}
		}
	}
}

