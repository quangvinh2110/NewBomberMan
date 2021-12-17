package uet.oop.bomberman.entities.Bomb;

import uet.oop.bomberman.GraphicsRenderer.Animation.PingPong_Animation;
import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Character;

import java.util.ArrayList;

public class Bomb extends Entity {

    private final Character bombOwner;
    private final int power;
    private final PingPong_Animation entityAnimation;
    private static final double animateStep = 1.0/5;
    public static final int timeToExplode = 300;
    private int timeToExplodeElapsed = 0;


    public boolean exploding;
    public boolean explosionEnded;


    public Bomb(int x, int y, Character bombOwner, int power) {
        super(x, y);
        this.bombOwner = bombOwner;
        this.power = power;
        ArrayList<GameSprite2> sprites = new ArrayList<>();
        sprites.add(GameSprite2.bomb_small);
        sprites.add(GameSprite2.bomb_medium);
        sprites.add(GameSprite2.bomb_large);
        entityGraphics = GameSprite2.bomb_small.getImage();
        entityAnimation = new PingPong_Animation(sprites, animateStep);

        exploding = false;
        explosionEnded = false;
    }

    @Override
    public void update() {
        entityGraphics = entityAnimation.animate();
        if(timeToExplodeElapsed >= timeToExplode) {
            exploding = true;
            bombOwner.decreaseBombCounter();
            createExplosion();
        }
        if(!exploding) {
            timeToExplodeElapsed++;
        }
    }

    private void createExplosion(){
        Explosion explosion = new Explosion(this.getX(), this.getY(), power);
    }

}
