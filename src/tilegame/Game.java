package tilegame;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import tilegame.display.EngineDisplay;
import tilegame.glgfx.Graphics;

/**
 * Holds all of the base code for the game.
 * @author Kenneth Lange
 *
 */
public class Game implements Runnable{ //Must implement Runnable in order for it to use a thread
	private EngineDisplay display;
	private int width, height;
	public String title;
	
	private static final int FPS = 60;
	private Graphics g;
	

	public Game(String title, int width){
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

	}
	/**
	 * This method acts as an updater keeping track of objects' and window's new locations/
	 */
	private void update(){//updates positions etc.		

	}
	/**
	 * This method takes the updated locations and draws them to the screen.
	 */
	private void render(){//draws updated positions to the screen

	}
	/**
	 * This method runs the game and sets a base for how often it can update and render.
	 */
	public void run() {
		
		init();
		
		Texture t = g.QuickLoad("Tiles");
		
		while (!Display.isCloseRequested()) {
			update();
			render();
			
			g.drawImage(t, 0, 0, 64, 64);

			Display.update(); //updates
			Display.sync(FPS); //sets fps in sync mode
		}
		
		Display.destroy();
	}
}