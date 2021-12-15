package uet.oop.bomberman.entities.FixedEntity.Fragile;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;


public abstract class FragileObject extends Entity {


    public FragileObject(int x, int y, Image image) {
        super(x, y);
    }

    @Override
    public abstract void update();
}
