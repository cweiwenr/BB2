package gamev3.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class WindowDisplay {

	//a window gives the gave the x minimize maximize buttons
	private JFrame frame;
	private Canvas canvas;	//for painting onto the window/ e.g. drawing graphics
	//so you paint first on the canvas, then once drawn, put into the frame so that it dispalys on the window
	//in this case, we draw on the canvas then put onto frame
	
	//the window needs a title and width and a height
	private String title;
	private int width, height;	//these int are in terms of pixels.
	
	//initializing everything in the constructor of our window display class
	public WindowDisplay(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		//call the method to initialize the JFrame/ windowdisplay
		createDisplay();
	}
	
	//making a method to initialize the JFrame
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//need this so that game closes properly
		frame.setResizable(false);	//do not allow users to resize the window
		frame.setLocationRelativeTo(null);	//when game starts, window opens at center of the screen
		frame.setVisible(true);	//so that the display is visible to user
			
		//initializing the canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		//adding the canvas onto the frame
		frame.add(canvas);
		frame.pack();
	}
	
	//so that we can access canvas properly and easily
	//this is important because canvas allows us to draw things on the screen
	public Canvas getCanvas() {
		return canvas;
	}
}
