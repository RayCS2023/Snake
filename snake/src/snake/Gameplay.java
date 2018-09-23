package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements ActionListener, KeyListener{
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	private int delay = 100;
	private int snakelength = 3;
	private int move = 0;
	private Timer timer;
	private int[] foodx = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] foody = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,450,475,500,525,550,575,600,625};
	
	private Random random = new Random();
	private int x = random.nextInt(34);
	private int y = random.nextInt(25);
	
	
	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		
		if (move == 0) {
			snakexlength[2] = 50;
			snakexlength[1] = 75;
			snakexlength[0] = 100;
			
			snakeylength[2] = 100;
			snakeylength[1] = 100;
			snakeylength[0] = 100;
		}
		
		g.setColor(Color.WHITE);
		g.drawRect(10, 10, 881, 651);
		
		g.setColor(Color.BLACK);
		g.fillRect(11, 11, 880, 650);
		
		ImageIcon rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		for(int a=0; a<snakelength;a++) {
			if(a==0 && right) {
				ImageIcon rightmouth1 = new ImageIcon("rightmouth.png");
				rightmouth1.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a==0 && left) {
				ImageIcon leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a==0 && up) {
				ImageIcon upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a==0 && down) {
				ImageIcon  downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a!=0) {
				ImageIcon  snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
		}
		ImageIcon food = new ImageIcon("enemy.png");
		food.paintIcon(this, g, foodx[x], foody[y]);
		
		if (snakexlength[0] == foodx[x] && snakeylength[0] == foody[y]) {
			snakelength++;
			x = random.nextInt(34);
			y = random.nextInt(25);
			
		}
		

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			move = 1;
			right = true;
			if(left!=true) {
				right = true;
			}
			
			else {
				left = true;
				right = false;
			}
			up = false;
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			move = 1;
			down = true;
			if(up!=true) {
				down = true;
			}
			else {
				up = true;
				down = false;
			}
			
			left = false;
			right = false;
		}	
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			move = 1;
			left = true;
			if(right!=true) {
				left = true;
			}
			else {
				right = true;
				left = false;
			}
			
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			move = 1;
			up = true;
			if(down!=true) {
				up = true;
			}
			else {
				down = true;
				up = false;
			}
			left = false;
			right = false;
		}	
			
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();

		if(right == true) {
			for (int r = snakelength - 1; r>=0; r--) {
				snakeylength[r+1] = snakeylength[r];
			}
			for (int r = snakelength; r>= 0; r--) {
				if (r==0) {
					snakexlength[r] += 25;
				}
				else {
					snakexlength[r] = snakexlength[r-1];
				}
				if (snakexlength[r] > 850) {
					snakexlength[r] = 25;
				}
			}
		repaint();	
		}
		if(down == true) {
			for (int r = snakelength - 1; r>=0; r--) {
				snakexlength[r+1] = snakexlength[r];
			}
			for (int r = snakelength; r>= 0; r--) {
				if (r==0) {
					snakeylength[r] += 25;
				}
				else {
					snakeylength[r] = snakeylength[r-1];
				}
				if (snakeylength[r] > 625) {
					snakeylength[r] = 25;
				}
			}
		repaint();	
		}
		if(left == true) {
			for (int r = snakelength - 1; r>=0; r--) {
				snakeylength[r+1] = snakeylength[r];
			}
			for (int r = snakelength; r>= 0; r--) {
				if (r==0) {
					snakexlength[r] -= 25;
				}
				else {
					snakexlength[r] = snakexlength[r-1];
				}
				if (snakexlength[r] < 25) {
					snakexlength[r] = 850;
				}
			}
		repaint();	
		}
		if(up == true) {
			for (int r = snakelength - 1; r>=0; r--) {
				snakexlength[r+1] = snakexlength[r];
			}
			for (int r = snakelength; r>= 0; r--) {
				if (r==0) {
					snakeylength[r] -= 25;
				}
				else {
					snakeylength[r] = snakeylength[r-1];
				}
				if (snakeylength[r] < 25) {
					snakeylength[r] = 625;
				}
			}
		repaint();	
		}
	}

}
