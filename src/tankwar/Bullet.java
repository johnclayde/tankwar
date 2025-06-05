package tankwar;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	static final int B_WIDTH = 20, B_HEIGHT=20;
	static final int B_SPEED = 10;
	
	private int x, y;
	private Direction dir;
	private boolean living ;
	
	public Bullet(int x , int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir  = dir;
		this.living = true;
	}
	
	public void setDir(Direction dir) {
		if(living) this.dir = dir;
	}
	
	public boolean isLiving() {
		return this.living;
	}
	
	public void paint(Graphics g) {
		if( !this.living) return;

		//Color c = g.getColor();
		//g.setColor(Color.RED);
		//g.fillOval(x, y, B_WIDTH, B_HEIGHT);
		//g.setColor(c);
		
		switch(this.dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL,x,y,null);
			x -= B_SPEED;
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR,x,y,null);
			x += B_SPEED;
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU,x,y,null);
			y -= B_SPEED;
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD,x,y,null);
			y += B_SPEED;
			break;
		default:
			break;
		}
		
		if(x <=0 || y <=0 || x >= TankFrame.GAME_WIDTH || y >= TankFrame.GAME_HEIGHT) {
			living = false;
		}
	}

}
