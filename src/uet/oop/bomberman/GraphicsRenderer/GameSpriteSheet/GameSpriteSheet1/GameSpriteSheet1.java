package uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet1;

import uet.oop.bomberman.Setup.FilePath;
import uet.oop.bomberman.Setup.ResourceLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Tất cả sprite (hình ảnh game) được lưu trữ vào một ảnh duy nhất
 * Class này giúp lấy ra các sprite riêng từ 1 ảnh chung duy nhất đó
 */
public class GameSpriteSheet1 {

	private final String _path;
	public final int SIZE_WIDTH;
	public final int SIZE_HEIGHT;
	public final int[] _pixels;
	private BufferedImage image;

	public static GameSpriteSheet1 tiles = new GameSpriteSheet1(FilePath.GraphicsFilePath.GameSpriteSheet.SpriteSheet1, 256, 256);
	
	public GameSpriteSheet1(String path, int width, int height) {
		this._path = path;
		this.SIZE_WIDTH = width;
		this.SIZE_HEIGHT = height;
		_pixels = new int[SIZE_HEIGHT * SIZE_WIDTH];
		load();
	}
	
	private void load() {
		try {
			image = ResourceLoader.loadBufferedImage(_path);
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, _pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public int getSIZE_HEIGHT() {
		return SIZE_HEIGHT;
	}

	public int getSIZE_WIDTH() {
		return SIZE_WIDTH;
	}

	public BufferedImage getImage() {
		return image;
	}
}
