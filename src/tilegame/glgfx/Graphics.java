package tilegame.glgfx;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
/**
 * This class is a custom made LWJGL and slack version of the Java.awt.Graphics class.
 * It has many of the same features, with the same names, that do the same things as Java.awt.Graphics' class.
 * It is designed for an easy and swift conversion from java.awt to LWJGL.
 * 
 * @author Kenneth Lange
 *
 */
public class Graphics {
	
	/**
	 * Sets this graphics context's current color to the specified color.
	 * All subsequent graphics operations using this graphics context use this specified color.
	 * @param c
	 */
	public void setColor(Color c) {
		glColor4d(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	/**
	 * Sets this graphics context's current color to the specified readable color.
	 * All subsequent graphics operations using this graphics context use this specified color.
	 * @param c
	 */
	public void setColor(ReadableColor c) {
		glColor4d(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	/**
	 * Draws a line, using the current color, between the points (x1, y1) and (x2, y2) in this graphics context's coordinate system.
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		glBegin(GL_LINES);
		glVertex2f(x1, y1);
		glVertex2f(x2, y2);			
		glEnd();
	}
	/**
	 * Draws the outline of the specified rectangle. The left and right edges of the rectangle are at x and x + width.
	 * The top and bottom edges are at y and y + height. The rectangle is drawn using the graphics context's current color.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawRect(int x, int y, int width, int height) {
		glBegin(GL_LINES);
		//Start to End
		glVertex2f(x, y);
		glVertex2f(x+width, y);
		//Start to End
		glVertex2f(x+width, y);
		glVertex2f(x+width, y+height);
		//Start to End
		glVertex2f(x+width, y+height);
		glVertex2f(x, y+height);
		//Start to End
		glVertex2f(x, y+height);
		glVertex2f(x, y);
		//Start to End
		glEnd();
	}
	/**
	 * Fills the specified rectangle. The left and right edges of the rectangle are at x and x + width. The top and bottom edges are at y and y + height.
	 * The resulting rectangle covers an area width pixels wide by height pixels tall. The rectangle is filled using the graphics context's current color.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void fillRect(int x, int y, int width, int height) {
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x+width, y);
		glVertex2f(x+width, y+height);
		glVertex2f(x, y+height);
		glEnd();
	}
	/**
	 * Fills the specified rectangle with the given texture. The left and right edges of the rectangle are at x and x + width. The top and bottom edges are at y and y + height.
	 * The resulting rectangle covers an area width pixels wide by height pixels tall. The rectangle is filled using the graphics context's current color.
	 * @param texture
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawImage(Texture texture, int x, int y, int width, int height) {
		texture.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
	}
	
	//Still trying to fix
	//---------------------------------------------------------------------------------------------------------------
	public Texture loadImage(String path, String fileType){
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("unable to load image");
		}
		System.out.println("loadImage() finished");
		return tex;
	}
	
	public Texture QuickLoad(String name) {
		Texture tex = null;
		tex = loadImage("res/"+name+".png", "PNG");
		return tex;
	}	
	//---------------------------------------------------------------------------------------------------------------
}
