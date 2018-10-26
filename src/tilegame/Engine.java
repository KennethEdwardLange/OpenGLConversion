package tilegame;

import java.awt.Font;

import org.lwjgl.opengl.Display;

import tilegame.display.EngineDisplay;
import tilegame.glgfx.Graphics;

/**
 * Holds all of the base code for the game.
 * @author Kenneth Lange
 *
 */
public class Engine implements Runnable{ //Must implement Runnable in order for it to use a thread
	@SuppressWarnings("unused")
	private EngineDisplay display;
	private int width, height;
	public String title;
	
	private static final int FPS = 60;
	private Graphics g;
	

	public Engine(String title, int width){
		this.width = width;
		height = width / 16 * 9;
		this.title = title;
		
		g = new Graphics();
	}
	/**
	 * This method initializes the graphics for the game
	 */
	private void init(){
		display = new EngineDisplay(title, width, height);//creates new display
		//Inputs

		g.setFont(new Font("Times New Roman", Font.BOLD, 15)); //Sets the default font to "Times New Roman"
	}
	/**
	 * This method acts as an updater keeping track of objects' and window's new locations.
	 */
	private void update(){//updates positions etc.		

	}
	/**
	 * This method takes the updated locations and draws them to the screen.
	 */
	private void render(){//draws updated positions to the screen

	}
	/**
	 * This method runs the engine and sets a base for how often it can update and render.
	 */
	public void run() {
		
		init();		
		
		while (!Display.isCloseRequested()) {
			update();
			render();

			Display.update(); //updates
			Display.sync(FPS); //sets fps in sync mode
		}
		
		Display.destroy();
	}
}