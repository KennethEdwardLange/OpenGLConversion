# OpenGLConversion
This project is used to easily switch from Java.awt to opengl using LWJGL and Swift.

Feel free to use this code in any way you like, including but not limitted to modifying or cloning for personal use.

Usage:

For anyone new to using Slick utils, to bind a texture that you would load from a sprite sheet use the code given below in the init method.

		SpriteSheet Tiles = new SpriteSheet(ImageLoader.loadImage("/res/Tiles.png"));
		BufferedImage buf = Tiles.crop(0, 0, 64, 64);
		Texture tex = null;
		try {
			tex = BufferedImageUtil.getTexture("", buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
and put this in the render method

		g.drawImage(test2, 0, 0, 64, 64);
