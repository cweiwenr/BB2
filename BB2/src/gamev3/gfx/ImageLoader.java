	package gamev3.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//this image class simply loads images for us
public class ImageLoader {
	//images are stored in buffered image objects
	//the parameter is the location/ file path of the image
	public static BufferedImage loadImage(String path) {
		try {
			//if you are facing input == null error, right click project
			//build path and add bb2/resources to classpath
			// make sure it is under class path
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//no image then dun load game
			System.exit(1);
		}
		return null;
	}
}
