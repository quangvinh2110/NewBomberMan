package uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet1;

import javafx.scene.image.*;

import java.util.Arrays;

/**
 * Lưu trữ thông tin các pixel của 1 sprite (hình ảnh game)
 */
public class GameSprite1 {
	
	public static final int DEFAULT_SIZE = 16;
	public static final int SCALE_FACTOR = 2;
	public static final int SCALED_SIZE = DEFAULT_SIZE * SCALE_FACTOR;
    private static final int TRANSPARENT_COLOR = 0xffff00ff;
	private final int SIZE_WIDTH;
	private final int SIZE_HEIGHT;
	private int _x, _y;
	public int[] _pixels;
	protected int _realWidth;
	protected int _realHeight;
	private GameSpriteSheet1 _sheet;
	public Image _image;

	/*
	|--------------------------------------------------------------------------
	| Board sprites
	|--------------------------------------------------------------------------
	 */
	public static GameSprite1 grass = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 6, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 brick = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 7, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 wall = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 5, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 portal = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 4, 0, GameSpriteSheet1.tiles, 14, 14);
	
	/*
	|--------------------------------------------------------------------------
	| Bomber Sprites
	|--------------------------------------------------------------------------
	 */
	public static GameSprite1 player_up = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 0, GameSpriteSheet1.tiles, 12, 16);
	public static GameSprite1 player_down = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 0, GameSpriteSheet1.tiles, 12, 15);
	public static GameSprite1 player_left = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 3, 0, GameSpriteSheet1.tiles, 10, 15);
	public static GameSprite1 player_right = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 0, GameSpriteSheet1.tiles, 10, 16);
	
	public static GameSprite1 player_up_1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 1, GameSpriteSheet1.tiles, 12, 16);
	public static GameSprite1 player_up_2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 2, GameSpriteSheet1.tiles, 12, 15);
	
	public static GameSprite1 player_down_1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 1, GameSpriteSheet1.tiles, 12, 15);
	public static GameSprite1 player_down_2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 2, GameSpriteSheet1.tiles, 12, 16);
	
	public static GameSprite1 player_left_1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 3, 1, GameSpriteSheet1.tiles, 11, 16);
	public static GameSprite1 player_left_2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 3, 2, GameSpriteSheet1.tiles, 12 ,16);
	
	public static GameSprite1 player_right_1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 1, GameSpriteSheet1.tiles, 11, 16);
	public static GameSprite1 player_right_2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 2, GameSpriteSheet1.tiles, 12, 16);
	
	public static GameSprite1 player_dead1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 4, 2, GameSpriteSheet1.tiles, 14, 16);
	public static GameSprite1 player_dead2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 5, 2, GameSpriteSheet1.tiles, 13, 15);
	public static GameSprite1 player_dead3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 6, 2, GameSpriteSheet1.tiles, 16, 16);
	
	/*
	|--------------------------------------------------------------------------
	| Character
	|--------------------------------------------------------------------------
	 */
	//BALLOON
	public static GameSprite1 balloon_left1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 9, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 balloon_left2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 9, 1, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 balloon_left3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 9, 2, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 balloon_right1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 10, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 balloon_right2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 10, 1, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 balloon_right3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 10, 2, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 balloon_dead = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 9, 3, GameSpriteSheet1.tiles, 16, 16);
	
	//ONEAL
	public static GameSprite1 oneal_left1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 11, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 oneal_left2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 11, 1, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 oneal_left3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 11, 2, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 oneal_right1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 12, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 oneal_right2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 12, 1, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 oneal_right3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 12, 2, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 oneal_dead = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 11, 3, GameSpriteSheet1.tiles, 16, 16);
	
	//Doll
	public static GameSprite1 doll_left1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 13, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 doll_left2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 13, 1, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 doll_left3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 13, 2, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 doll_right1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 14, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 doll_right2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 14, 1, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 doll_right3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 14, 2, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 doll_dead = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 13, 3, GameSpriteSheet1.tiles, 16, 16);
	
	//Minvo
	public static GameSprite1 minvo_left1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 8, 5, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 minvo_left2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 8, 6, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 minvo_left3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 8, 7, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 minvo_right1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 9, 5, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 minvo_right2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 9, 6, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 minvo_right3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 9, 7, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 minvo_dead = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 8, 8, GameSpriteSheet1.tiles, 16, 16);
	
	//Kondoria
	public static GameSprite1 kondoria_left1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 10, 5, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 kondoria_left2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 10, 6, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 kondoria_left3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 10, 7, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 kondoria_right1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 11, 5, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 kondoria_right2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 11, 6, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 kondoria_right3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 11, 7, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 kondoria_dead = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 10, 8, GameSpriteSheet1.tiles, 16, 16);
	
	//ALL
	public static GameSprite1 mob_dead1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 15, 0, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 mob_dead2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 15, 1, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 mob_dead3 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 15, 2, GameSpriteSheet1.tiles, 16, 16);
	
	/*
	|--------------------------------------------------------------------------
	| Bomb Sprites
	|--------------------------------------------------------------------------
	 */
	public static GameSprite1 bomb = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 3, GameSpriteSheet1.tiles, 15, 15);
	public static GameSprite1 bomb_1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 3, GameSpriteSheet1.tiles, 13, 15);
	public static GameSprite1 bomb_2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 3, GameSpriteSheet1.tiles, 12, 14);
	
	/*
	|--------------------------------------------------------------------------
	| FlameSegment Sprites
	|--------------------------------------------------------------------------
	 */
	public static GameSprite1 bomb_exploded = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 4, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 bomb_exploded1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 5, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 bomb_exploded2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 6, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 explosion_vertical = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 5, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_vertical1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 5, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_vertical2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 3, 5, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 explosion_horizontal = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 7, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_horizontal1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 8, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_horizontal2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 9, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 explosion_horizontal_left_last = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 7, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_horizontal_left_last1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 8, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_horizontal_left_last2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 9, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 explosion_horizontal_right_last = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 7, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_horizontal_right_last1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 8, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_horizontal_right_last2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 9, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 explosion_vertical_top_last = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 4, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_vertical_top_last1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 4, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_vertical_top_last2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 3, 4, GameSpriteSheet1.tiles, 16, 16);
	
	public static GameSprite1 explosion_vertical_down_last = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 6, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_vertical_down_last1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 6, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 explosion_vertical_down_last2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 3, 6, GameSpriteSheet1.tiles, 16, 16);
	
	/*
	|--------------------------------------------------------------------------
	| Brick FlameSegment
	|--------------------------------------------------------------------------
	 */
	public static GameSprite1 brick_exploded = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 7, 1, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 brick_exploded1 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 7, 2, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 brick_exploded2 = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 7, 3, GameSpriteSheet1.tiles, 16, 16);
	
	/*
	|--------------------------------------------------------------------------
	| Powerups
	|--------------------------------------------------------------------------
	 */
	public static GameSprite1 powerup_bombs = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 0, 10, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 powerup_flames = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 1, 10, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 powerup_speed = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 2, 10, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 powerup_wallpass = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 3, 10, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 powerup_detonator = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 4, 10, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 powerup_bombpass = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 5, 10, GameSpriteSheet1.tiles, 16, 16);
	public static GameSprite1 powerup_flamepass = new GameSprite1(DEFAULT_SIZE, DEFAULT_SIZE, 6, 10, GameSpriteSheet1.tiles, 16, 16);




	
	public GameSprite1(int width, int height, int x, int y, GameSpriteSheet1 sheet, int rw, int rh) {
		SIZE_WIDTH = width;
		SIZE_HEIGHT = height;
		_pixels = new int[SIZE_HEIGHT * SIZE_WIDTH];
		_x = x * SIZE_WIDTH;
		_y = y * SIZE_HEIGHT;
		_sheet = sheet;
		_realWidth = rw;
		_realHeight = rh;
		load();
	}
	
	public GameSprite1(int width, int height, int color) {
		SIZE_HEIGHT = height;
		SIZE_WIDTH = width;
		_pixels = new int[SIZE_HEIGHT * SIZE_WIDTH];
		setColor(color);
	}
	
	private void setColor(int color) {
		Arrays.fill(_pixels, color);
	}

	private void load() {
		for (int y = 0; y < SIZE_HEIGHT; y++) {
			for (int x = 0; x < SIZE_WIDTH; x++) {
				_pixels[x + y * SIZE_WIDTH] = _sheet._pixels[(x + _x) + (y + _y) * _sheet.SIZE_WIDTH];
			}
		}
	}
	
	public static GameSprite1 movingSprite(GameSprite1 normal, GameSprite1 x1, GameSprite1 x2, int animate, int time) {
		int calc = animate % time;
		int diff = time / 3;
		
		if(calc < diff) {
			return normal;
		}
			
		if(calc < diff * 2) {
			return x1;
		}
			
		return x2;
	}
	
	public static GameSprite1 movingSprite(GameSprite1 x1, GameSprite1 x2, int animate, int time) {
		int diff = time / 2;
		return (animate % time > diff) ? x1 : x2; 
	}

	public Image getFxImage() {
        WritableImage wr = new WritableImage(SIZE_WIDTH, SIZE_HEIGHT);
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < SIZE_WIDTH; x++) {
            for (int y = 0; y < SIZE_HEIGHT; y++) {
                if ( _pixels[x + y * SIZE_WIDTH] == TRANSPARENT_COLOR) {
                    pw.setArgb(x, y, 0);
                }
                else {
                    pw.setArgb(x, y, _pixels[x + y * SIZE_WIDTH]);
                }
            }
        }
        return resample(wr);
    }

	private Image resample(Image input) {
		final int W = (int) input.getWidth();
		final int H = (int) input.getHeight();
		final int S = GameSprite1.SCALE_FACTOR;

		WritableImage output = new WritableImage(
				W * S,
				H * S
		);

		PixelReader reader = input.getPixelReader();
		PixelWriter writer = output.getPixelWriter();

		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				final int argb = reader.getArgb(x, y);
				for (int dy = 0; dy < S; dy++) {
					for (int dx = 0; dx < S; dx++) {
						writer.setArgb(x * S + dx, y * S + dy, argb);
					}
				}
			}
		}

		return output;
	}
}
