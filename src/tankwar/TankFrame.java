package tankwar;

import java.awt.Color;
import java.awt.Frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TankFrame extends Frame {
	static final int GAME_WIDTH=800, GAME_HEIGHT=600;
	private Tank myTank;
	List<Bullet> bullets = new ArrayList<Bullet>();
	List<Tank> tanks = new ArrayList<Tank>();

	Image  offScreenImage = null;
	
	public TankFrame() {
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("TANK WAR");
		
		myTank = new Tank(200,200, Direction.DOWN, Group.GOOD, this);
		myTank.setMove(false);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(new myKeyListener());
		}
	

	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
			
		}
		 Graphics gOffScreen = offScreenImage.getGraphics();
		 Color c = gOffScreen.getColor();
		 gOffScreen.setColor(Color.BLACK);
		 gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		 gOffScreen.setColor(c);
		 paint(gOffScreen);
		 g.drawImage(offScreenImage, 0, 0, null);
		 
	}
	@Override
	public void paint(Graphics g) {
		myTank.paint(g);
		
		for( int i = 0; i < bullets.size(); i++) {
				bullets.get(i).paint(g);}	
		
		for(int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);
		}
		for(int i =0;i < bullets.size(); i++) {
			for(int j = 0; j < tanks.size(); j++) {
				bullets.get(i).collidwith(tanks.get(j));
			}
		}
		displayInfo(g);

	}
	
	private void displayInfo(Graphics g) {

		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.drawString("bullets count:"+bullets.size(), 50,50);
		g.drawString("enmy count:"+tanks.size(), 50,70);
		g.setColor(c);
	}
	// internal class for TankFrame
	class myKeyListener extends KeyAdapter {
	
		private boolean bu = false, bd = false;
		private boolean bl = false, br = false;
			
		private void setDirection() {
				if( !bl && !br && !bd && !bu ) {
					myTank.setMove(false); 
				} else {
					myTank.setMove(true); 
					if( bl) myTank.setDir(Direction.LEFT);
					if( br) myTank.setDir(Direction.RIGHT);
					if( bu) myTank.setDir(Direction.UP);
					if( bd) myTank.setDir(Direction.DOWN);
				}
				

		}
			
		@Override
		public void keyPressed(KeyEvent e) {
			
				int key = e.getKeyCode();
				switch (key) {
				case KeyEvent.VK_LEFT:
					bl = true;
					break;
				case KeyEvent.VK_RIGHT:
					br = true;
					break;
				case KeyEvent.VK_UP:
					bu = true;
					break;
				case KeyEvent.VK_DOWN:
					bd = true;
					break;
				default:
					break;
				}
				setDirection();
			}
			
		@Override
		public void keyReleased(KeyEvent e) {

				int key = e.getKeyCode();
				switch (key) {
				case KeyEvent.VK_LEFT:
					bl = false;
					break;
				case KeyEvent.VK_RIGHT:
					br = false;
					break;
				case KeyEvent.VK_UP:
					bu = false;
					break;
				case KeyEvent.VK_DOWN:
					bd = false;
					break;
					
				case KeyEvent.VK_CONTROL:
					myTank.fire();
					break;
					
				default:
					break;
				}
				
				setDirection();
			}
		}
	
}