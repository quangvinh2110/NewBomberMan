package uet.oop.bomberman.entities.MovingEntity.Bomber;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.GraphicsRenderer.Animation.PingPong_Animation;
import uet.oop.bomberman.Scene.Game.Map.Map;
import uet.oop.bomberman.entities.Bomb.Bomb;
import uet.oop.bomberman.entities.BoundaryBox;
import uet.oop.bomberman.entities.Coordinate;
import uet.oop.bomberman.entities.MovingEntity.Bomber.GameController.GameController;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;

public class Character extends MovingEntity {

    private final GameController input;
    private final Bomber bomber;

    private boolean[] pressedDirection;

    private final int createBombTime = 7;
    private int createBombTimeElapsed = 0;
    private int bombCounter = 0;
    private int maxBombCounter = 1;
    private int bombPower = 1;

    public boolean isKilled = false;
    public boolean death = false;

    private static final int offsetY = 23;

    private final PingPong_Animation entityMovingAnimation;
    private static final double animateStep = 1.0/5;




    public Character(GameController input, int x, int y, Bomber chosenBomber) {
        super(x, y);

        bomber = chosenBomber;
        this.input = input;

        entityGraphics = bomber.getMovingSprites(animateDirection).get(1).getImage();
        entityMovingAnimation = new PingPong_Animation(bomber.getMovingSprites(animateDirection), animateStep);

        this.boundaryBox = new BoundaryBox(new Coordinate(this.getX(), this.getY() + offsetY), this.getImageWidth(),
                this.getImageHeight() - offsetY);
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
            System.out.println("CreateBombTimeElapsed: " + createBombTimeElapsed);
            if (createBombTimeElapsed == 0) {
                createBomb();
                createBombTimeElapsed++;
            } else if (createBombTimeElapsed == createBombTime) {
                createBombTimeElapsed = 0;
            } else {
                createBombTimeElapsed++;
            }
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
        gc.strokeRect(this.boundaryBox.getTop_left().getX(), this.boundaryBox.getTop_left().getY(),
                this.boundaryBox.getBoundaryBoxWidth(), this.boundaryBox.getBoundaryBoxHeight());
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
            this.updateCoordinate(dx, dy);
            System.out.println("Update location: " + "(" + this.getX() + ", " + this.getY() + ")");
        } else {
            System.out.println("Update location: " + "(" + this.getX() + ", " + this.getY() + ")");
        }

        System.out.println();
    }

    @Override
    protected boolean canMove(int nextX, int nextY) {
        System.out.println("Width: " + this.getImageWidth() + ", Height: " + (this.getImageHeight() + offsetY));
        BoundaryBox newBoundaryBox = new BoundaryBox(new Coordinate(nextX, nextY + offsetY),
                this.boundaryBox.getBoundaryBoxWidth(), this.boundaryBox.getBoundaryBoxHeight());


        int real_nextY = nextY + offsetY;

        int top_left_X_1 = nextX/ Map.TILE_SIZE;
        int top_left_Y_1 = real_nextY/ Map.TILE_SIZE;

        int top_left_X_2 = nextX/ Map.TILE_SIZE + 1;
        int top_left_Y_2 = real_nextY/ Map.TILE_SIZE;

        int top_left_X_3 = nextX/ Map.TILE_SIZE;
        int top_left_Y_3 = real_nextY/ Map.TILE_SIZE + 1;

        int top_left_X_4 = nextX/ Map.TILE_SIZE + 1;
        int top_left_Y_4 = real_nextY/ Map.TILE_SIZE + 1;

        System.out.println("(" + top_left_X_1 + ", " + top_left_Y_1 + ")");
        if (BombermanGame.baseWindow.mainGame.mapManager.haveFixedEntityAtGridLocation(top_left_X_1, top_left_Y_1)) {
            System.out.println("top left: " + false);
            return false;
        }
        if (BombermanGame.baseWindow.mainGame.mapManager.haveFixedEntityAtGridLocation(top_left_X_2, top_left_Y_2)) {
            Coordinate top_left = new Coordinate(top_left_X_2*Map.TILE_SIZE, top_left_Y_2*Map.TILE_SIZE);
            boolean check = collide(newBoundaryBox, new BoundaryBox(top_left, Map.TILE_SIZE, Map.TILE_SIZE));
            System.out.println("top right: " + check);
            if (!check) {
                return false;
            }
        }
        if (BombermanGame.baseWindow.mainGame.mapManager.haveFixedEntityAtGridLocation(top_left_X_3, top_left_Y_3)) {
            Coordinate top_left = new Coordinate(top_left_X_3*Map.TILE_SIZE, top_left_Y_3*Map.TILE_SIZE);
            boolean check = collide(newBoundaryBox, new BoundaryBox(top_left, Map.TILE_SIZE, Map.TILE_SIZE));
            System.out.println("bottom left: " + check);
            if (!check) {
                return false;
            }
        }
        if (BombermanGame.baseWindow.mainGame.mapManager.haveFixedEntityAtGridLocation(top_left_X_4, top_left_Y_4)) {
            Coordinate top_left = new Coordinate(top_left_X_4*Map.TILE_SIZE, top_left_Y_4*Map.TILE_SIZE);
            boolean check = collide(newBoundaryBox, new BoundaryBox(top_left, Map.TILE_SIZE, Map.TILE_SIZE));
            System.out.println("bottom right: " + check);
            return check;
        }
        return true;
    }

    private void createBomb() {
        if (!isKilled && (bombCounter < maxBombCounter)) {
            int gridX = (int) (this.getX()*1.0/Map.TILE_SIZE);
            int gridY = (int) ((this.getY() + offsetY)*1.0/Map.TILE_SIZE);
            Bomb bomb = new Bomb(gridX*Map.TILE_SIZE, gridY*Map.TILE_SIZE, this, bombPower);
            boolean receiveSuccess = BombermanGame.baseWindow.mainGame.mapManager.receiveBomb(bomb);
            System.out.println("Previous bomb counter: " + bombCounter);
            if (receiveSuccess) {
                this.bombCounter++;
            }
            System.out.println("Receive Bomb Success: " + receiveSuccess);
            System.out.println("Update bomb counter: " + bombCounter);
        }
    }

    public void decreaseBombCounter() {
        this.bombCounter--;
        System.out.println("Update bomb counter: " + this.bombCounter);
    }

    private void updateCoordinate(int dx, int dy) {
        this.coordinate.updateCoordinate(dx, dy);
        this.boundaryBox.updateBoundaryBox(dx, dy);
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
