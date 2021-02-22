package gamev3.display;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class PixelFont {
	
	public static Font pixel;
	public static Font pixellarge;
	
	public PixelFont() throws FontFormatException, IOException
	{
		pixel = Font.createFont(Font.TRUETYPE_FONT, new File("/textures/PixelMplus10-Regular.ttf"));
		GraphicsEnvironment addFont = GraphicsEnvironment.getLocalGraphicsEnvironment();
		addFont.registerFont(pixel);
		pixellarge = pixel.deriveFont(100f);
	}
	
}