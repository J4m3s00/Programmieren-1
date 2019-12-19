package schimkat.myway;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DirtyPainter2 extends Canvas implements Runnable {
	private final int SCREEN_INIT_WIDTH = 400;
	private final int SCREEN_INIT_HEIGHT = 400;
	private Thread fLoopThread;

	private boolean fIsRunning;

	private JFrame fFrame;
	
	private ArrayList<Drawable2> fDrawables = new ArrayList<Drawable2>();

	public DirtyPainter2() {
		super();	//Create a canvas on which we can draw to
		fFrame = new JFrame("Dirty Painter 2 (Luca)"); //Create the window
		
		fFrame.setSize(SCREEN_INIT_WIDTH, SCREEN_INIT_HEIGHT); // Set screen size
		fFrame.setLocationRelativeTo(null); // Center it on the screen
		fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the app when window gets closed
		fFrame.setVisible(true); // Show the window

		setSize(SCREEN_INIT_WIDTH, SCREEN_INIT_HEIGHT); // Set the size of the canvas

		fFrame.add(this);	//Add the canvas to the screen
		fFrame.pack();		//Calculate proper width for the window

		requestFocusInWindow(); //Get the input events from the canvas. We get little bug when we dont do this
		
		fIsRunning = init();	//Init the painter
	}
	
	public void show() {
		///In this part we basically call the run method of our class. 
				//We use the thread class to do this for us asynchronously. 
				//So the rest of the program does not wait for the loop to finish. So it just runs all the time in the background. 
				fLoopThread = new Thread(this, "loopThread");	//Create the draw loop. 
				fLoopThread.start();	//Starts the drawloop
	}

	private boolean init() {
		return true;
	}

	public void add(Drawable2 drawable)
	{
		fDrawables.add(drawable);
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long now = 0;
		double delta = 0;
		double timer = 0.0;
		int frames = 0;
		int fps = 0;
		
		while (fIsRunning) {
			now = System.nanoTime();
			delta = (now  - lastTime) / 1000000000.0d;
			lastTime = now;
			timer += delta;
			if (timer >= 1.0) {
				fps = frames;
				frames = 0;
				timer -= 1.0;
			}
			
			BufferStrategy bs = getBufferStrategy();
			if (bs == null)
			{
				createBufferStrategy(2);
				continue;
			}
			
			Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
			g2d.setColor(Color.white);
			g2d.fillRect(0, 0, getWidth(), getHeight());
			
			for (Drawable2 d : fDrawables) {
				d.draw(g2d, delta);
			}
			

			g2d.setColor(Color.black);
			g2d.drawString("Fps: " + fps, 24, 24);
			g2d.drawString("Calculated FPS: " + 1.0 / delta, 24, 54);
			
			g2d.dispose();
			bs.show();
			frames++;
		}
	}

}
