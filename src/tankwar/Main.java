package tankwar;

public class Main {

		public static void main(String args[]) throws InterruptedException  {
				TankFrame tf = new TankFrame();
				while(true) {
				Thread.sleep(30);
				tf.repaint();
				}
		}
}
