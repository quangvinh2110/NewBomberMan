package uet.oop.bomberman.entities.Bomb;

import uet.oop.bomberman.GraphicsRenderer.Animation.PingPong_Animation;
import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Character;

import java.util.ArrayList;

public class Bomb extends Entity {

    private Character bombOwner;
    private final PingPong_Animation entityAnimation;
    private static final double animateStep = 1.0/5;
    private boolean exploded;
    private int countToExplode = 500;
    private boolean exploding;


    public Bomb(int x, int y, Character bombOwner) {
        super(x, y);
        this.bombOwner = bombOwner;
        ArrayList<GameSprite2> sprites = new ArrayList<>();
        sprites.add(GameSprite2.bomb_small);
        sprites.add(GameSprite2.bomb_medium);
        sprites.add(GameSprite2.bomb_large);
        entityGraphics = GameSprite2.bomb_small.getImage();
        entityAnimation = new PingPong_Animation(sprites, animateStep);
    }

    @Override
    public void update() {
        entityGraphics = entityAnimation.animate();
        countToExplode--;
        if(countToExplode < 0) {
            bombOwner.removeBomb(this);
        }
    }
}
