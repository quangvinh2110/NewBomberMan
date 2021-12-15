package uet.oop.bomberman.Scene.Game;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.Setup.BaseWindow;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Bomber;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Character;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;
import uet.oop.bomberman.entities.MovingEntity.Enemy.Enemy;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.FixedEntity.Fragile.FragileObject;
import uet.oop.bomberman.entities.MovingEntity.Bomber.GameController.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class MainGame {



    private Scene gameScene;
    private Group gameRoot;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private AnimationTimer gameTimer;


    private MovingEntity bomber;
    private Hashtable<Integer, Enemy> enemiesList;
    private Hashtable<Integer, FragileObject> fragileObjects;
    private ArrayList<Entity> unbreakableObjects;

    private Map map;
    private final int fixedMap = 1;
    private final int dynamicMap = 2;

    private static int gameState;
    private static final int readyGoState = 0;
    private static final int runningState = 1;
    private static final int hungryUpState = 2;
    private static final int finishState = 3;


    private static int id = 1;


    public MainGame(){
        Initialize();
    }

    private void Initialize() {
        gameState = readyGoState;

        canvas = new Canvas(BaseWindow.WIDTH, BaseWindow.HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();
        gameRoot = new Group();
        gameRoot.getChildren().add(canvas);
        gameScene = new Scene(gameRoot, BaseWindow.WIDTH, BaseWindow.HEIGHT);

        enemiesList = new Hashtable<>();
        fragileObjects = new Hashtable<>();
        unbreakableObjects = new ArrayList<>();
        map = new Map();

    }


    private void createReadyState() {

    }

    private void createRunningState() {

    }

    private void createHungryUpState() {

    }

    private void createFinishState() {

    }


    public void createNewGame(Bomber chosenBomber) {
//        createBaseMap();
        createBomber(chosenBomber);
        createEnemies();
        render();
        run();
    }

    private void createBomber(Bomber chosenBomber) {
        GameController gameController = new GameController(gameScene);
        gameController.addListeners();
        bomber = new Character(gameController, 80, 80, chosenBomber, id);
        bomber.updateMap(map);
        id++;
    }



    private void createEnemies() {

    }


    private void run() {
        gameState = runningState;
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
                updateMap();
            }
        };

        gameTimer.start();

    }



    private void update() {
        bomber.update();
        enemiesList.forEach((k, o)-> o.update());
        fragileObjects.forEach((k, o) -> o.update());
        map.getMap().forEach(Entity::update);
    }

    private void updateMap() {
        bomber.updateMap(map);
        enemiesList.forEach((k, o)-> o.updateMap(map));
    }

    private void render() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        unbreakableObjects.forEach(o -> o.render(graphicsContext));
        fragileObjects.forEach((k, o) -> o.render(graphicsContext));
        map.getMap().forEach(e -> e.render(graphicsContext));
        enemiesList.forEach((k, o) -> o.render(graphicsContext));
        bomber.render(graphicsContext);
    }

    public Group getGameRoot() {
        return gameRoot;
    }

    public Scene getGameScene() {
        return gameScene;
    }

}
