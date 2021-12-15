package uet.oop.bomberman.entities.Bomb;

import uet.oop.bomberman.GraphicsRenderer.Animation.PingPong_Animation;
import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;
import uet.oop.bomberman.entities.Entity;

import java.util.ArrayList;

public class Bomb extends Entity {


    private PingPong_Animation entityAnimation;
    private static final double animateStep = 1.0/5;
    private boolean exploded;
    int countToExplode = 5;

    public Bomb(int x, int y) {
        super(x, y);
        ArrayList<GameSprite2> sprites = new ArrayList<>();
        sprites.add(GameSprite2.bomb_small);
        sprites.add(GameSprite2.bomb_medium);
        entityGraphics = GameSprite2.bomb_small.getImage();
        entityAnimation = new PingPong_Animation(sprites, animateStep);
    }

    @Override
    public void update() {
        entityGraphics = entityAnimation.animate();
        countToExplode--;
    }
}
