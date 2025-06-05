package tankwar;

import java.awt.Graphics;

public class Tank {
	private static final int SPEED = 10;
	private int x;
	private int y;
	private Direction dir;
	private boolean moving;
	private TankFrame tf;

	
	public Tank(int x, int y, Direction dir) {
		this.x = x ;
		this.y = y;
		this.dir = dir;
		this.moving = false;

	}
	
	public void setMove(boolean m) {
		this.moving = m;
	}
	
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	public Direction getDir() {
		return this.dir;
	}
	
	public void paint(Graphics g) {
		g.fillRect(x,y, 50,50);
		if( !this.moving) return;
		switch(dir) {
		case LEFT:
			this.x -= SPEED;
			break;
		case RIGHT:
			this.x += SPEED;
			break;
		case UP:
			this.y -= SPEED;
			break;
		case DOWN:
			this.y += SPEED;
			break;
		
		}
		//g.fillRect(x,y, 50,50);

	}
}