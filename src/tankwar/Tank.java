package tankwar;

import java.awt.Graphics;
import java.util.Random;


public class Tank {
	private static final int SPEED = 5;
	static final int WIDTH =50, HEIGHT = 50;
	private int x;
	private int y;
	private Direction dir = Direction.DOWN;
	private boolean moving = true;
	private TankFrame tf;
	private Group group;
	private boolean living =true;
	private Random random = new Random();

	public Tank(int x, int y, Direction dir, Group group, TankFrame tf) {
		this.x = x ;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
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
	
	public Group getGroup() {
		return this.group;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	public void fire() {
		int bx = this.x + Bullet.B_WIDTH;
		int by = this.y + Bullet.B_HEIGHT;
		tf.bullets.add(new Bullet(bx, by, this.dir, this.group, tf));
	}
	
	public void die() {
		this.living = false;
	}
	
	public void paint(Graphics g) {
		if(!this.living ) {
			this.tf.tanks.remove(this);
			return;
		}
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
		if(group == Group.BAD && random.nextInt(10) > 7) fire();
		if( group == Group.BAD) {
			if(x <=0 || y <=0 || x >= TankFrame.GAME_WIDTH || y >= TankFrame.GAME_HEIGHT) {
				tf.tanks.remove(this);
			}
		}
		//g.fillRect(x,y, 50,50);
	}
}