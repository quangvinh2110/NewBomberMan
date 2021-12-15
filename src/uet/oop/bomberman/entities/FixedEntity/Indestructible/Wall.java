package uet.oop.bomberman.entities.FixedEntity.Indestructible;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;


public class Wall extends Entity {

    private final boolean flip;


    public Wall(int x, int y, Image image) {
        super(x, y, image);
        this.flip = false;
    }

    public Wall(int x, int y, Image image, boolean flip) {
        super(x, y, image);
        this.flip = flip;
    }

    public void render(GraphicsContext gc) {
        if (flip) {
            gc.drawImage(entityGraphics, 0, 0, entityGraphics.getWidth(), entityGraphics.getHeight(),
                    this.coordinate.getX(), this.coordinate.getY(), -entityGraphics.getWidth(), entityGraphics.getHeight());
        } else {
            gc.drawImage(entityGraphics, this.coordinate.getX(), this.coordinate.getY());
        }
    }

    @Override
    public void update() {

    }
}
