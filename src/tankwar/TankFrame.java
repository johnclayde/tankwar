package tankwar;

import java.awt.Frame;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	public static final int GAME_WIDTH=800, GAME_HEIGHT=600;
	private Tank myTank;
	
	
	public TankFrame() {
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("TANK WAR");
		
		myTank = new Tank(200,200, Direction.DOWN);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(new myKeyListener());
		}
	

	@Override
	public void paint(Graphics g) {
		myTank.paint(g);

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
		
				default:
					break;
				}
				setDirection();
			}
		}
	
}