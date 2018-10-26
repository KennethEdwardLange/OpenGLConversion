package tilegame.display;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Color;

import tilegame.glgfx.Graphics;

import static org.lwjgl.opengl.GL11.*;

public class EngineDisplay {
	
	private static final int FPS = 60;
	
	//Test Code:
	private Graphics g = new Graphics();
	
	public EngineDisplay(String title, int width, int height) {
		Display.setTitle(title);
		
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1); //1 and -1 make this a 2 dimensional view
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}
	
}
