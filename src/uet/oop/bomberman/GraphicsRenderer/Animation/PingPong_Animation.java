package uet.oop.bomberman.GraphicsRenderer.Animation;

import javafx.scene.image.Image;
import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;

import java.util.ArrayList;

/**
 * This class helps to generate ping-pong sequence (0, 1, 2, 1, 0, 1, ...) which can be used in animation.
 */
public class PingPong_Animation {
    private int animateValue = 0;    // range [0.0, upperLimit]
    private double animateStep = 1;     // range (-upperLimit, +upperLimit) or, 0 if upperLimit = 0
    private final ArrayList<Integer> animateSequence;
    private int upperLimit;
    private ArrayList<GameSprite2> sprites;

    public PingPong_Animation(ArrayList<GameSprite2> sprites, double realAnimationStep) {
        this.sprites = sprites;
        this.upperLimit = sprites.size()*((int) (1/realAnimationStep)) - 1;
        animateSequence = new ArrayList<>();
        for (int i = 0; i < sprites.size(); i++) {
            int loop = (int) (1/realAnimationStep);
            for (int j = 0; j < loop; j++) {
                animateSequence.add(i);
            }
        }
    }

    public Image animate() {
        animateValue += animateStep;
        if (animateValue > upperLimit) {
            animateValue = upperLimit;
            animateStep *= -1;
        } else if (animateValue < 0) {
            animateValue = 0;
            animateStep *= -1;
        }
        return sprites.get(animateSequence.get(animateValue)).getImage();
    }

    public void setSprites(ArrayList<GameSprite2> sprites) {
        this.sprites = sprites;
    }

    public void setAnimateStep(double realAnimationStep) {
        animateSequence.clear();
        for (int i = 0; i <= sprites.size(); i++) {
            int loop = (int) (1/realAnimationStep);
            for (int j = 0; j < loop; j++) {
                animateSequence.add(i);
            }
        }
    }

    public ArrayList<Integer> getAnimateSequence() {
        return animateSequence;
    }


    public void resetAnimation() {
        animateValue = animateSequence.get(animateSequence.size()/2);
        if (animateStep < 0) animateStep *= -1;
    }


}
