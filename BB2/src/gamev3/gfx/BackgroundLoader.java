package gamev3.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//this image class simply loads images for us
public class BackgroundLoader {
	//images are stored in buffered image objects
	//the parameter is the location/ file path of the image
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(BackgroundLoader.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//no image then dun load game
			System.exit(1);
		}
		return null;
	}
}
