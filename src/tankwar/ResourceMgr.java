package tankwar;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {

	public static  BufferedImage tankL, tankR, tankU, tankD;
	public static BufferedImage bulletL, bulletR, bulletU, bulletD;
	
	static {

		try {
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankwar/images/tankR.gif"));
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankwar/images/tankL.gif"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankwar/images/tankU.gif"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankwar/images/tankD.gif"));
			
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankwar/images/bulletR.gif"));
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankwar/images/bulletL.gif"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankwar/images/bulletU.gif"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankwar/images/bulletD.gif"));
			
		} catch (IOException e) {e.printStackTrace();}
	}
}
