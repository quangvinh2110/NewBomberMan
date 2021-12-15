package uet.oop.bomberman.entities.MovingEntity.Bomber;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.GraphicsRenderer.Animation.PingPong_Animation;
import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;
import uet.oop.bomberman.Scene.Game.Map;
import uet.oop.bomberman.entities.Coordinate;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.FixedEntity.Unbreakable.Grass;
import uet.oop.bomberman.entities.MovingEntity.Bomber.GameController.GameController;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;

public class Character extends MovingEntity {

    private final GameController input;
    private final Bomber bomber;

    private boolean[] pressedDirection;

    private int bombCounter = 0;
    private int maxBombCounter = 1;

    private boolean isKilled;

    private static final int offsetY = 22;

    private final PingPong_Animation entityMovingAnimation;
    private static final double animateStep = 1.0/5;


    public Character(GameController input, int x, int y, Bomber chosenBomber, int id) {
        super(x, y, id);

        bomber = chosenBomber;
        this.input = input;

        entityGraphics = bomber.getMovingSprites(animateDirection).get(1).getImage();
        entityMovingAnimation = new PingPong_Animation(bomber.getMovingSprites(animateDirection), animateStep);

        isKilled = false;

    }

    private void processInput() {
        pressedDirection = new boolean[]{false, false, false, false};
        newAnimateDirection = null;
        if(input.isMoveUp()) {
            newAnimateDirection = Direction.UP;
            pressedDirection[Direction.UP.ordinal()] = true;
        } else if(input.isMoveDown()) {
            newAnimateDirection = Direction.DOWN;
            pressedDirection[Direction.DOWN.ordinal()] = true;
        }
        if(input.isMoveLeft()) {
            newAnimateDirection = Direction.LEFT;
            pressedDirection[Direction.LEFT.ordinal()] = true;
        } else if(input.isMoveRight()) {
            newAnimateDirection = Direction.RIGHT;
            pressedDirection[Direction.RIGHT.ordinal()] = true;
        }
        if(input.isFireKey()) {
            createBomb();
            decreaseBombCounter();
        }
    }


    @Override
    public void update() {
        processInput();
        // update animation and location
        move();

    }

    public void render(GraphicsContext gc) {
        if(gc == null || this.entityGraphics == null) {
            return;
        }
        gc.drawImage(this.entityGraphics, this.coordinate.getX(), this.coordinate.getY());
        gc.strokeRect(this.coordinate.getX(), this.coordinate.getY() + offsetY, this.getWidth(), this.getHeight());
    };

    @Override
    protected void move() {
        if (newAnimateDirection == null || isKilled) return;

        // update animation
        if (this.animateDirection != newAnimateDirection) {
            entityMovingAnimation.setSprites(bomber.getMovingSprites(newAnimateDirection));
            entityMovingAnimation.resetAnimation();
            this.animateDirection = newAnimateDirection;
        }
        entityGraphics = entityMovingAnimation.animate();

        // update location
        this.update_Dx_Dy(speed);
//        System.out.println("Current location: " + "(" + this.getX() + ", " + this.getY() + ")");
        if(canMove(this.getX() + dx, this.getY() + dy)) {
            updateY(dy);
            updateX(dx);
//            System.out.println("Update location: " + "(" + this.getX() + ", " + this.getY() + ")");
        }
//            System.out.println("Update location: " + "(" + this.getX() + ", " + this.getY() + ")");

//        System.out.println();
    }

    @Override
    protected boolean canMove(int nextX, int nextY) {
        Coordinate bomber_top_left = new Coordinate(nextX, nextY + offsetY);
        Coordinate bomber_bottom_right = new Coordinate(nextX + this.getWidth(), nextY + offsetY + this.getHeight());

        int real_nextY = nextY + offsetY;

        int next_top_left_X_1 = nextX/Map.TILE_SIZE;
        int next_top_left_Y_1 = real_nextY/Map.TILE_SIZE;

        int next_top_left_X_2 = nextX/Map.TILE_SIZE + 1;
        int next_top_left_Y_2 = real_nextY/Map.TILE_SIZE;

        int next_top_left_X_3 = nextX/Map.TILE_SIZE;
        int next_top_left_Y_3 = real_nextY/Map.TILE_SIZE + 1;

        int next_top_left_X_4 = nextX/Map.TILE_SIZE + 1;
        int next_top_left_Y_4 = real_nextY/Map.TILE_SIZE + 1;

//        System.out.println("(" + next_top_left_X_1 + ", " + next_top_left_Y_1 + ")");
        if (map.haveEntityAtGridLocation(next_top_left_X_1, next_top_left_Y_1)) {
//            System.out.println("top left: " + false);
            return false;
        }
        if (map.haveEntityAtGridLocation(next_top_left_X_2, next_top_left_Y_2)) {
            //            System.out.println("top right: " + check);
            return ! collide(new Coordinate(next_top_left_X_2*Map.TILE_SIZE, next_top_left_Y_2*Map.TILE_SIZE),
                                      new Coordinate((next_top_left_X_2 + 1)*Map.TILE_SIZE, (next_top_left_Y_2 + 1)*Map.TILE_SIZE),
                                      bomber_top_left, bomber_bottom_right);
        }
        if (map.haveEntityAtGridLocation(next_top_left_X_3, next_top_left_Y_3)) {
            //            System.out.println("bottom left: " + check);
            return ! collide(new Coordinate(next_top_left_X_3*Map.TILE_SIZE, next_top_left_Y_3*Map.TILE_SIZE),
                                      new Coordinate((next_top_left_X_3 + 1)*Map.TILE_SIZE, (next_top_left_Y_3 + 1)*Map.TILE_SIZE),
                                      bomber_top_left, bomber_bottom_right);
        }
        if (map.haveEntityAtGridLocation(next_top_left_X_4, next_top_left_Y_4)) {
            //            System.out.println("bottom right: " + check);
            return ! collide(new Coordinate(next_top_left_X_4*Map.TILE_SIZE, next_top_left_Y_4*Map.TILE_SIZE),
                                       new Coordinate((next_top_left_X_4 + 1)*Map.TILE_SIZE, (next_top_left_Y_4 + 1)*Map.TILE_SIZE),
                                       bomber_top_left, bomber_bottom_right);
        }
        return true;
    }


//    @Override
//    protected boolean collide(Coordinate top_left1, Coordinate bottom_right1, Coordinate top_left2, Coordinate bottom_right2) {
////        System.out.println("Top left 1: (" + top_left1.getX() + ", " + top_left1.getY() + ")");
////        System.out.println("Bottom right 1: (" + bottom_right1.getX() + ", " + bottom_right1.getY() + ")");
////        System.out.println("Top left 2: (" + top_left2.getX() + ", " + top_left2.getY() + ")");
////        System.out.println("Bottom right 2: (" + bottom_right2.getX() + ", " + bottom_right2.getY() + ")");
//        if (top_left1.getX() >= bottom_right2.getX() || top_left2.getX() >= bottom_right1.getX()) {
//            return false;
//        }
//        return bottom_right1.getY() > top_left2.getY() && bottom_right2.getY() > top_left1.getY();
//    }


    private void createBomb() {
        if (!isKilled && bombCounter < maxBombCounter) {

            bombCounter++;
        }
    }

    private void decreaseBombCounter() {
        bombCounter--;
    }

    public boolean isKilled() {
        return isKilled;
    }


    public int getHeight() {

        return (int) this.entityGraphics.getHeight() - offsetY;
    }

    private void updateX(int dx) {
        this.coordinate.updateX(dx);
    }

    private void updateY(int dy) {
        this.coordinate.updateY(dy);
    }

    private void update_Dx_Dy(int speed) {
        if (newAnimateDirection == null || speed == 0) {
            return;
        }
        if (pressedDirection[Direction.UP.ordinal()]) {
            dy = -speed;
        } else if (pressedDirection[Direction.DOWN.ordinal()]) {
            dy = speed;
        } else {
            dy = 0;
        }
        if (pressedDirection[Direction.LEFT.ordinal()]) {
            dx = -speed;
        } else if (pressedDirection[Direction.RIGHT.ordinal()]) {
            dx = speed;
        } else {
            dx = 0;
        }
    }


}
