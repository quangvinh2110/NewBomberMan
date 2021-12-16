package uet.oop.bomberman.entities.MovingEntity;

import uet.oop.bomberman.Scene.Game.Map.MapManager;
import uet.oop.bomberman.entities.BoundaryBox;
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

    protected boolean collide(BoundaryBox boundaryBox1, BoundaryBox boundaryBox2) {
        if (boundaryBox1 == null || boundaryBox2 == null) {
            return true;
        }
        System.out.println("Top left 1: (" + boundaryBox1.getTop_left().getX() + ", " + boundaryBox1.getTop_left().getY() + ")");
        System.out.println("Bottom right 1: (" + boundaryBox1.getBottom_right().getX() + ", " +boundaryBox1.getBottom_right().getY() + ")");
        System.out.println("Top left 2: (" + boundaryBox2.getTop_left().getX() + ", " + boundaryBox2.getTop_left().getY() + ")");
        System.out.println("Bottom right 2: (" + boundaryBox2.getBottom_right().getX() + ", " + boundaryBox2.getBottom_right().getY() + ")");
        if (boundaryBox1.getTop_left().getX() >= boundaryBox2.getBottom_right().getX()
                || boundaryBox2.getTop_left().getX() >= boundaryBox1.getBottom_right().getX()) {
            return true;
        }
        return boundaryBox1.getBottom_right().getY() <= boundaryBox2.getTop_left().getY()
                || boundaryBox2.getBottom_right().getY() <= boundaryBox1.getTop_left().getY();
    };

}
