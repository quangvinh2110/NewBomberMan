package uet.oop.bomberman.entities.Bomb;

import uet.oop.bomberman.entities.Entity;

public class Explosion extends Entity {

    public static final int explodingTime = 100;
    private int explodingTimeElapsed = 0;
    private int edgeLength;

    public Explosion(int centerX, int centerY, int power) {
        super(centerX, centerY);
        this.edgeLength = power;
    }

    @Override
    public void update() {

    }
}
