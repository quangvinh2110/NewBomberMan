package uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2;

import javafx.scene.image.Image;
import uet.oop.bomberman.GraphicsRenderer.RenderGraphics;
import uet.oop.bomberman.Setup.FilePath;
import uet.oop.bomberman.Setup.ResourceLoader;

import java.util.Objects;


public class GameSprite2 {

    public static final int ORIGIN_TILE_SIZE = 16;
    public static final int RESIZE_TILE_SIZE = 20;
    public static final int ORIGIN_BOMBER_HEIGHT = 27;
    public static final int BOMBER_WIDTH = 17;
    public static final int SCALE_FACTOR = 2;

    private final int ORIGIN_WIDTH;
    private final int ORIGIN_HEIGHT;

    private final Image originImage;
    private final Image image;


    /*
	|--------------------------------------------------------------------------
	| Bomberman character sprites
	|--------------------------------------------------------------------------
	 */
    // front
    public static final GameSprite2 bomberman_front_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 124, 0, 17,26);
    public static final GameSprite2 bomberman_front_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 141, 0, 17, 26);
    public static final GameSprite2 bomberman_front_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 158, 0, 17, 26);
    // back
    public static final GameSprite2 bomberman_back_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 14, 0, 17, 26);
    public static final GameSprite2 bomberman_back_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 31, 0, 17, 26);
    public static final GameSprite2 bomberman_back_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 48, 0, 17, 26);
    // left
    public static final GameSprite2 bomberman_left_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 179, 0, 17, 26);
    public static final GameSprite2 bomberman_left_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 198, 0, 17, 26);
    public static final GameSprite2 bomberman_left_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 216, 0, 17, 26);
    // right
    public static final GameSprite2 bomberman_right_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 69, 0, 17, 26);
    public static final GameSprite2 bomberman_right_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 86, 0, 17, 26);
    public static final GameSprite2 bomberman_right_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 103, 0, 17, 26);
    // death
    public static final GameSprite2 bomberman_death1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 151, 175, 19, 26);
    public static final GameSprite2 bomberman_death2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 171, 175, 19, 26);
    public static final GameSprite2 bomberman_death3 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 192, 175, 23, 26);
    public static final GameSprite2 bomberman_death4 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Bomberman, 217, 175, 28, 26);

    /*
	|--------------------------------------------------------------------------
	| Pretty Bomber character sprites
	|--------------------------------------------------------------------------
	 */
    // front
    public static final GameSprite2 bomberGreat_front_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16,24);
    public static final GameSprite2 bomberGreat_front_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_front_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    // back
    public static final GameSprite2 bomberGreat_back_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_back_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_back_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    // left
    public static final GameSprite2 bomberGreat_left_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_left_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_left_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    // right
    public static final GameSprite2 bomberGreat_right_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_right_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_right_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    // death
    public static final GameSprite2 bomberGreat_death1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_death2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_death3 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);
    public static final GameSprite2 bomberGreat_death4 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberGreat, 0, 0, 16, 24);

    /*
	|--------------------------------------------------------------------------
	| Bomber the Kid character sprites
	|--------------------------------------------------------------------------
	 */
    // front
    public static final GameSprite2 bomberLady_front_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16,24);
    public static final GameSprite2 bomberLady_front_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_front_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    // back
    public static final GameSprite2 bomberLady_back_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_back_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_back_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    // left
    public static final GameSprite2 bomberLady_left_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_left_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_left_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    // right
    public static final GameSprite2 bomberLady_right_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_right_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_right_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    // death
    public static final GameSprite2 bomberLady_death1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_death2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_death3 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);
    public static final GameSprite2 bomberLady_death4 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberLady, 0, 0, 16, 24);

    /*
	|--------------------------------------------------------------------------
	| Punk Bomber character sprites
	|--------------------------------------------------------------------------
	 */
    // front
    public static final GameSprite2 bomberHammer_front_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 17,25);
    public static final GameSprite2 bomberHammer_front_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_front_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    // back
    public static final GameSprite2 bomberHammer_back_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_back_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_back_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    // left
    public static final GameSprite2 bomberHammer_left_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_left_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_left_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    // right
    public static final GameSprite2 bomberHammer_right_standing = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_right_moving1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_right_moving2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    // death
    public static final GameSprite2 bomberHammer_death1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_death2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_death3 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);
    public static final GameSprite2 bomberHammer_death4 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.BomberHammer, 0, 0, 16, 24);

    /*
	|--------------------------------------------------------------------------
	| Location: Green Village
	|--------------------------------------------------------------------------
	 */
    public static final GameSprite2 bomb1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 bomb2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 bomb3 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 flame_center = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 flame_edge1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 flame_edge2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);


    /*
	|--------------------------------------------------------------------------
	| Location: Green Village
	|--------------------------------------------------------------------------
	 */
    // Surrounding wall
    //top corner
    public static final GameSprite2 top_corner_wall1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 407, 15, ORIGIN_TILE_SIZE);
    public static final GameSprite2 side_wall2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 407, 32, ORIGIN_TILE_SIZE);
    public static final GameSprite2 top_corner_wall2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 424, 15, ORIGIN_TILE_SIZE);
    public static final GameSprite2 top_corner_wall3 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 424, 32, ORIGIN_TILE_SIZE);
    // bottom corner
    public static final GameSprite2 bottom_corner_wall1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 407, 66, ORIGIN_TILE_SIZE);
    public static final GameSprite2 bottom_corner_wall2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 407, 83, ORIGIN_TILE_SIZE);
    public static final GameSprite2 bottom_corner_wall3 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 424, 66, ORIGIN_TILE_SIZE);
    public static final GameSprite2 bottom_corner_wall4 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 424, 83, ORIGIN_TILE_SIZE);
    // side edge
    public static final GameSprite2 side_wall1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 424, 49, ORIGIN_TILE_SIZE);
    // top edge
    public static final GameSprite2 top_edge_wall = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 441, 15, ORIGIN_TILE_SIZE);
    // bottom edge
    public static final GameSprite2 bottom_edge_wall = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 441, 83, ORIGIN_TILE_SIZE);
    // Home
    public static final GameSprite2 home = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 475, 32, ORIGIN_TILE_SIZE);
    public static final GameSprite2 grassBelowHome = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 475, 49, ORIGIN_TILE_SIZE);
    // Grass
    public static final GameSprite2 grass = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 475, 15, ORIGIN_TILE_SIZE);
    // Tree root
    public static final GameSprite2 treeRoot = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 458, 32, ORIGIN_TILE_SIZE);
    public static final GameSprite2 grassBelowTreeRoot = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 458, 49, ORIGIN_TILE_SIZE);
    public static final GameSprite2 treeRootFire1 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 treeRootFire2 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 treeRootFire3 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 treeRootFire4 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 treeRootFire5 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);
    public static final GameSprite2 treeRootFire6 = new GameSprite2(FilePath.GraphicsFilePath.GameSpriteSheet.Background, 0, 0, ORIGIN_TILE_SIZE);







    public GameSprite2(String spriteSheetURL, int x, int y, int width, int height) {
        this.ORIGIN_HEIGHT = height;
        this.ORIGIN_WIDTH = width;
        originImage = RenderGraphics.cropImage(Objects.requireNonNull(ResourceLoader.loadImage(spriteSheetURL)),
                x, y, width, height);
//        image = RenderGraphics.scaleImage(RenderGraphics.resizeImage(originImage, 19, 26), SCALE_FACTOR);
        image = RenderGraphics.scaleImage(originImage, SCALE_FACTOR);
    }

    public GameSprite2(String spriteSheetURL, int x, int y, int origin_size) {
        this.ORIGIN_HEIGHT = origin_size;
        this.ORIGIN_WIDTH = origin_size;
        originImage = RenderGraphics.cropImage(Objects.requireNonNull(ResourceLoader.loadImage(spriteSheetURL)),
                x, y, origin_size, origin_size);
        image = RenderGraphics.scaleImage(RenderGraphics.resizeImage(originImage, RESIZE_TILE_SIZE, RESIZE_TILE_SIZE), SCALE_FACTOR);
    }

    public int getORIGIN_HEIGHT() {
        return ORIGIN_HEIGHT;
    }

    public int getORIGIN_WIDTH() {
        return ORIGIN_WIDTH;
    }

    public int getSCALE_HEIGHT() { return ORIGIN_HEIGHT*SCALE_FACTOR;}

    public int getSCALE_WIDTH() {
        return ORIGIN_WIDTH*SCALE_FACTOR;
    }

    public Image getImage() {return image;}

    public Image getOriginImage() {
        return originImage;
    }
}
