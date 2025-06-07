package tankwar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	
	static final int B_WIDTH = 10, B_HEIGHT=10;
	static final int B_SPEED = 10;
	
	private int x, y;
	private Direction dir;
	private boolean living ;
	private TankFrame tf;
	private Group group;
	
	public Bullet(int x , int y, Direction dir,Group group, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir  = dir;
		this.tf = tf;
		this.group = group;
		this.living = true;
		
	}
	
	public void setDir(Direction dir) {
		if(living) this.dir = dir;
	}
	
	public boolean isLiving() {
		return this.living;
	}
	
	public void paint(Graphics g) {
		if( !this.living) {
			tf.bullets.remove(this);
			return;
		}
		
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
	
	public void collidwith(Tank tank) {   
		if(this.group == tank.getGroup()) return;
		
		Rectangle rect1 = new Rectangle(this.x, this.y, B_WIDTH, B_HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
		
		if(rect1.intersects(rect2)) {
			tank.die();
			this.living = false;
		}
	}

}
