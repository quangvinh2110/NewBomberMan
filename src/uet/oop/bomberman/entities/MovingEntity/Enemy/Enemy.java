package uet.oop.bomberman.entities.MovingEntity.Enemy;

import uet.oop.bomberman.entities.MovingEntity.MovingEntity;

public class Enemy extends MovingEntity {


    public Enemy(int x, int y) {
        super(x, y);
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
