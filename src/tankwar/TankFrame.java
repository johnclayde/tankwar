package tankwar;

import java.awt.Frame;

public class TankFrame  extends Frame {
	public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
	private Tank myTank;
	
	
	public TankFrame() {
		this.myTank = new Tank();
		
	}

}
