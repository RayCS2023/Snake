package snake;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame("Snake");
		Gameplay game = new Gameplay();
		obj.setBounds(10,10,905,700);
		obj.setResizable(false);
		obj.setBackground(Color.DARK_GRAY);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setVisible(true);
		obj.add(game);
		

	}

}
