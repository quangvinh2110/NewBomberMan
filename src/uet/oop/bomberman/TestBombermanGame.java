package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet1.GameSprite1;
import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.FixedEntity.Indestructible.Grass;

import java.util.ArrayList;
import java.util.List;

public class TestBombermanGame extends Application {
    
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
    
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();


    public static void main(String[] args) {
        Application.launch(TestBombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(GameSprite1.SCALED_SIZE * WIDTH, GameSprite1.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

//        createMap();
        Entity Grass3 = new Grass(40, 0, GameSprite2.grass.getImage());
        Entity Grass1 = new Grass(40, 40, GameSprite2.home.getImage());
        Entity Grass2 = new Grass(40, 80, GameSprite2.grassBelowHome.getImage());
        Entity Grass4 = new Grass(0, 40, GameSprite2.treeRoot.getImage());
        Entity Grass5 = new Grass(0, 80, GameSprite2.grassBelowTreeRoot.getImage());
        Entity Grass6 = new Grass(40, 60, GameSprite2.bomberman_back_standing.getImage());
        stillObjects.add(Grass1);
        stillObjects.add(Grass2);
        stillObjects.add(Grass3);
        stillObjects.add(Grass4);
        stillObjects.add(Grass5);
        entities.add(Grass6);


    }

//    public void createMap() {
//        for (int i = 0; i < WIDTH; i++) {
//            for (int j = 0; j < HEIGHT; j++) {
//                Entity object;
//                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
//                    object = new Wall(i, j);
//                }
//                else {
//                    object = new Grass(i, j);
//                }
//                stillObjects.add(object);
//            }
//        }
//    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
