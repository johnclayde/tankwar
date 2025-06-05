package tankwar;

import java.awt.Graphics;


public class Tank {
	private static final int SPEED = 5;
	private int x;
	private int y;
	private Direction dir;
	private boolean moving;
	private TankFrame tf;

	
	public Tank(int x, int y, Direction dir, TankFrame tf) {
		this.x = x ;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
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
	
	public void fire() {
		int bx = this.x + Bullet.B_WIDTH;
		int by = this.y + Bullet.B_HEIGHT;
		tf.bullets.add(new Bullet(bx, by, this.dir));
	}
	
	public void paint(Graphics g) {
		//g.fillRect(x,y, 50,50);
		switch(dir) {
		case LEFT:
			g.drawImage(ResourceMgr.tankL,x,y,null);
			if(moving) this.x -= SPEED;
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR,x,y,null);
			if(moving) this.x += SPEED;
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU,x,y,null);
			if(moving) this.y -= SPEED;
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD,x,y,null);
			if(moving) this.y += SPEED;

			break;
		default:
				break;
		
		}

		//g.fillRect(x,y, 50,50);
	}
}