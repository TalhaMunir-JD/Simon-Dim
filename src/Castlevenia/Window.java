package Castlevenia;
import java.awt.Dimension;
import javax.swing.*;

public class Window {

	//constructor

	public Window(int width, int height, String title,Game game) {

		game.setPreferredSize(new Dimension(width,height));
		game.setMaximumSize(new Dimension(width,height));
		game.setMinimumSize(new Dimension(width,height));
		JFrame frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);            
		frame.setLocationRelativeTo(null);  //this places the window in the center of the screen 
		frame.setVisible(true);  //show the screen

		game.start();
	}
}

