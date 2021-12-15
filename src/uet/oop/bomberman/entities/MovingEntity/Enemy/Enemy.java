package uet.oop.bomberman.entities.MovingEntity.Enemy;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.Coordinate;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Direction;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;

public class Enemy extends MovingEntity {


    public Enemy(int x, int y, int id) {
        super(x, y, id);
    }


    @Override
    public void update() {

    }

    @Override
    protected void move() {

    }

    @Override
    protected boolean canMove(int nextX, int nextY) {
        return false;
    }

}
