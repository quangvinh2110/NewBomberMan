package uet.oop.bomberman.entities.MovingEntity;

import uet.oop.bomberman.Scene.Game.Map.MapManager;
import uet.oop.bomberman.entities.Coordinate;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Direction;
import uet.oop.bomberman.entities.Entity;

public abstract class MovingEntity extends Entity {


    protected int dx = 0;
    protected int dy = 0;
    protected int speed = 2;

    protected Direction animateDirection = Direction.DOWN;
    protected Direction newAnimateDirection;

    protected MapManager mapManager;

    public MovingEntity(int x, int y, MapManager mapManager) {
        super(x, y);
        this.mapManager = mapManager;
    }

    public abstract void update();


    public int getSpeed() {
        return speed;
    }

    protected abstract void move();

    protected abstract boolean canMove(int nextX, int nextY);

    protected boolean collide(Coordinate top_left1, Coordinate bottom_right1, Coordinate top_left2, Coordinate bottom_right2) {
        if (top_left1 == null || bottom_right1 == null || top_left2 == null || bottom_right2 == null) {
            return false;
        }
        System.out.println("Top left 1: (" + top_left1.getX() + ", " + top_left1.getY() + ")");
        System.out.println("Bottom right 1: (" + bottom_right1.getX() + ", " + bottom_right1.getY() + ")");
        System.out.println("Top left 2: (" + top_left2.getX() + ", " + top_left2.getY() + ")");
        System.out.println("Bottom right 2: (" + bottom_right2.getX() + ", " + bottom_right2.getY() + ")");
        if (top_left1.getX() >= bottom_right2.getX() || top_left2.getX() >= bottom_right1.getX()) {
            return false;
        }
        return bottom_right1.getY() > top_left2.getY() && bottom_right2.getY() > top_left1.getY();
    };

    public MapManager getMapManager() {
        return this.mapManager;
    }

}
