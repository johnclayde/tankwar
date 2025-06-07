package tankwar;

public class Main {

		public static void main(String args[]) throws InterruptedException  {
				TankFrame tf = new TankFrame();
				
				for(int i = 0; i < 5; i++) {
					tf.tanks.add(new Tank(50 +i*50, 100,Direction.DOWN, Group.BAD,tf));
				}
				
				while(true) {
				Thread.sleep(30);
				tf.repaint();
				}
		}
}
