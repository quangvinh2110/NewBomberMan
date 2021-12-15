package uet.oop.bomberman.entities.MovingEntity;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.Scene.Game.Map;
import uet.oop.bomberman.entities.Coordinate;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Direction;
import uet.oop.bomberman.entities.Entity;

public abstract class MovingEntity extends Entity {


    protected int dx = 0;
    protected int dy = 0;
    protected final int id;
    protected int speed = 2;

    protected Direction animateDirection = Direction.DOWN;
    protected Direction newAnimateDirection;

    protected Map map;

    public MovingEntity(int x, int y, int id) {
        super(x, y);
        this.id = id;
    }

    public abstract void update();


    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    protected abstract void move();

    protected abstract boolean canMove(int nextX, int nextY);

    protected boolean collide(Coordinate top_left1, Coordinate bottom_right1, Coordinate top_left2, Coordinate bottom_right2) {
        if (top_left1 == null || bottom_right1 == null || top_left2 == null || bottom_right2 == null) {
            return false;
        }
        if (top_left1.getX() >= bottom_right2.getX() || top_left2.getX() >= bottom_right1.getX()) {
            return false;
        }
        return bottom_right1.getY() > top_left2.getY() && bottom_right2.getY() > top_left1.getY();
    };

    public void updateMap(Map map) {
        this.map = map;
    }
}
