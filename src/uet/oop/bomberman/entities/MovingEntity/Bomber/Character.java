package uet.oop.bomberman.entities.MovingEntity.Bomber;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.GraphicsRenderer.Animation.PingPong_Animation;
import uet.oop.bomberman.Scene.Game.Map.Map;
import uet.oop.bomberman.Scene.Game.Map.MapManager;
import uet.oop.bomberman.entities.Bomb.Bomb;
import uet.oop.bomberman.entities.Coordinate;
import uet.oop.bomberman.entities.MovingEntity.Bomber.GameController.GameController;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;

public class Character extends MovingEntity {

    private final GameController input;
    private final Bomber bomber;

    private boolean[] pressedDirection;

    private int bombCounter = 0;
    private int maxBombCounter = 7;
    private int explosionRange = 1;

    private boolean isKilled;
    private boolean death;

    private static final int offsetY = 23;

    private final PingPong_Animation entityMovingAnimation;
    private static final double animateStep = 1.0/5;




    public Character(GameController input, int x, int y, Bomber chosenBomber, MapManager mapManager) {
        super(x, y, mapManager);

        bomber = chosenBomber;
        this.input = input;

        entityGraphics = bomber.getMovingSprites(animateDirection).get(1).getImage();
        entityMovingAnimation = new PingPong_Animation(bomber.getMovingSprites(animateDirection), animateStep);

        isKilled = false;
        death = false;
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
            System.out.println("SPACE!");
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
    }

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
        System.out.println("Current location: " + "(" + this.getX() + ", " + this.getY() + ")");
        if(canMove(this.getX() + dx, this.getY() + dy)) {
            updateY(dy);
            updateX(dx);
            System.out.println("Update location: " + "(" + this.getX() + ", " + this.getY() + ")");
        } else {
            System.out.println("Update location: " + "(" + this.getX() + ", " + this.getY() + ")");
        }
//            System.out.println("Update location: " + "(" + this.getX() + ", " + this.getY() + ")");

        System.out.println();
    }

    @Override
    protected boolean canMove(int nextX, int nextY) {
        System.out.println("Width: " + this.getWidth() + ", Height: " + (this.getHeight() + offsetY));
        Coordinate bomber_top_left = new Coordinate(nextX, nextY + offsetY);
        Coordinate bomber_bottom_right = new Coordinate(nextX + this.getWidth(), nextY + offsetY + this.getHeight());


        int real_nextY = nextY + offsetY;

        int next_top_left_X_1 = nextX/ Map.TILE_SIZE;
        int next_top_left_Y_1 = real_nextY/ Map.TILE_SIZE;

        int next_top_left_X_2 = nextX/ Map.TILE_SIZE + 1;
        int next_top_left_Y_2 = real_nextY/ Map.TILE_SIZE;

        int next_top_left_X_3 = nextX/ Map.TILE_SIZE;
        int next_top_left_Y_3 = real_nextY/ Map.TILE_SIZE + 1;

        int next_top_left_X_4 = nextX/ Map.TILE_SIZE + 1;
        int next_top_left_Y_4 = real_nextY/ Map.TILE_SIZE + 1;

        System.out.println("(" + next_top_left_X_1 + ", " + next_top_left_Y_1 + ")");
        if (mapManager.haveFixedEntityAtGridLocation(next_top_left_X_1, next_top_left_Y_1)) {
            System.out.println("top left: " + false);
            return false;
        }
        if (mapManager.haveFixedEntityAtGridLocation(next_top_left_X_2, next_top_left_Y_2)) {
            boolean check = ! collide(new Coordinate(next_top_left_X_2* Map.TILE_SIZE, next_top_left_Y_2* Map.TILE_SIZE),
                                      new Coordinate((next_top_left_X_2 + 1)* Map.TILE_SIZE, (next_top_left_Y_2 + 1)* Map.TILE_SIZE),
                                      bomber_top_left, bomber_bottom_right);
            System.out.println("top right: " + check);
            if (!check) {
                return false;
            }
        }
        if (mapManager.haveFixedEntityAtGridLocation(next_top_left_X_3, next_top_left_Y_3)) {

            boolean check = ! collide(new Coordinate(next_top_left_X_3* Map.TILE_SIZE, next_top_left_Y_3* Map.TILE_SIZE),
                                      new Coordinate((next_top_left_X_3 + 1)* Map.TILE_SIZE, (next_top_left_Y_3 + 1)* Map.TILE_SIZE),
                                      bomber_top_left, bomber_bottom_right);
            System.out.println("bottom left: " + check);
            if (!check) {
                return false;
            }
        }
        if (mapManager.haveFixedEntityAtGridLocation(next_top_left_X_4, next_top_left_Y_4)) {
            boolean check = ! collide(new Coordinate(next_top_left_X_4* Map.TILE_SIZE, next_top_left_Y_4* Map.TILE_SIZE),
                                       new Coordinate((next_top_left_X_4 + 1)* Map.TILE_SIZE, (next_top_left_Y_4 + 1)* Map.TILE_SIZE),
                                       bomber_top_left, bomber_bottom_right);
            System.out.println("bottom right: " + check);
            return check;
        }
        return true;
    }

    private void createBomb() {
        if (!isKilled && (bombCounter < maxBombCounter)) {
            int id = this.bombCounter;
            int gridX = (int) (this.getX()*1.0/Map.TILE_SIZE);
            int gridY = (int) ((this.getY() + offsetY)*1.0/Map.TILE_SIZE);

            Coordinate top_left = new Coordinate(this.getX(), this.getY() + offsetY);
            Coordinate bottom_right = new Coordinate(this.getX() + this.getWidth(), this.getY() + offsetY + this.getHeight());

            if (bottom_right.getX() <= (gridX + 1)*Map.TILE_SIZE
                    && bottom_right.getY() <= (gridY + 1)*Map.TILE_SIZE) {
                Bomb bomb = new Bomb(gridX*Map.TILE_SIZE, gridY*Map.TILE_SIZE, this);
                mapManager.receiveBomb(bomb);
            }
            else if (bottom_right.getX() > (gridX + 1)*Map.TILE_SIZE
                    && bottom_right.getY() <= (gridY + 1)*Map.TILE_SIZE) {
                Bomb bomb;
                if (bottom_right.getX() - (gridX + 1)*Map.TILE_SIZE > (gridX + 1)*Map.TILE_SIZE - top_left.getX()
                        && mapManager.freeToPutBomb(gridX + 1, gridY)) {
                    bomb = new Bomb((gridX + 1) * Map.TILE_SIZE, gridY * Map.TILE_SIZE, this);
                } else {
                    bomb = new Bomb(gridX * Map.TILE_SIZE, gridY * Map.TILE_SIZE, this);
                }
                mapManager.receiveBomb(bomb);
            }
            else if (bottom_right.getX() <= (gridX + 1)*Map.TILE_SIZE
                    && bottom_right.getY() > (gridY + 1)*Map.TILE_SIZE) {
                Bomb bomb;
                if (bottom_right.getY() - (gridY + 1)*Map.TILE_SIZE > (gridY + 1)*Map.TILE_SIZE - top_left.getY()
                        && mapManager.freeToPutBomb(gridX, gridY + 1)) {
                    bomb = new Bomb(gridX * Map.TILE_SIZE, (gridY + 1) * Map.TILE_SIZE, this);
                } else {
                    bomb = new Bomb(gridX * Map.TILE_SIZE, gridY * Map.TILE_SIZE, this);
                }
                mapManager.receiveBomb(bomb);
            }
            else {
                Bomb bomb;
                int dx;
                int dy;
                if (bottom_right.getX() - (gridX + 1)*Map.TILE_SIZE > (gridX + 1)*Map.TILE_SIZE - top_left.getX()) {
                    dx = 1;
                } else {
                    dx = 0;
                }
                if (bottom_right.getY() - (gridY + 1)*Map.TILE_SIZE > (gridY + 1)*Map.TILE_SIZE - top_left.getY()) {
                    dy = 1;
                } else {
                    dy = 0;
                }
                if (mapManager.freeToPutBomb(gridX + dx, gridY + dy)) {
                    bomb = new Bomb(gridX + dx, gridY + dy, this);
                } else if (mapManager.freeToPutBomb(gridX + 1 - dx, gridY + dy)) {
                    bomb = new Bomb(gridX + 1 -dx, gridY + dy, this);
                } else if (mapManager.freeToPutBomb(gridX + dx, gridY + 1 - dy)) {
                    bomb = new Bomb(gridX + dx, gridY + 1 - dy, this);
                } else {
                    bomb = new Bomb(gridX + 1 - dx, gridY + 1 - dy, this);
                }
                mapManager.receiveBomb(bomb);
            }
            bombCounter++;
            System.out.println("Bomb counter: " + bombCounter);
        }
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
