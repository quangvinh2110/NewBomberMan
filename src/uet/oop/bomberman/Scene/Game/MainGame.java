package uet.oop.bomberman.Scene.Game;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.Scene.Game.Map.MapManager;
import uet.oop.bomberman.Setup.BaseWindow;
import uet.oop.bomberman.entities.Bomb.Bomb;
import uet.oop.bomberman.entities.FixedEntity.Fragile.TreeRoot;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Bomber;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Character;
import uet.oop.bomberman.entities.MovingEntity.MovingEntity;
import uet.oop.bomberman.entities.MovingEntity.Enemy.Enemy;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.MovingEntity.Bomber.GameController.*;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class MainGame {



    private Scene gameScene;
    private Group gameRoot;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private AnimationTimer gameTimer;


    private Character bomber;
    private ArrayList<Enemy> enemiesList;


    private MapManager mapManager;


    public MainGame(){
        Initialize();
    }

    private void Initialize() {
        canvas = new Canvas(BaseWindow.WIDTH, BaseWindow.HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();
        gameRoot = new Group();
        gameRoot.getChildren().add(canvas);
        gameScene = new Scene(gameRoot, BaseWindow.WIDTH, BaseWindow.HEIGHT);

        enemiesList = new ArrayList<>();
        mapManager = new MapManager();

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
        bomber = new Character(gameController, 80, 80, chosenBomber, mapManager);
    }



    private void createEnemies() {

    }


    private void run() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };

        gameTimer.start();

    }



    private void update() {
        bomber.update();
        enemiesList.forEach(Enemy::update);
        mapManager.getDynamicEntityInMap().forEach(Entity::update);
        mapManager.getDynamicEntityInMap().forEach(Entity::update);

    }

    private void render() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (mapManager.getFixedEntityInMap().size() > 0) {
            mapManager.getFixedEntityInMap().forEach(e -> e.render(graphicsContext));
        }
        if (mapManager.getDynamicEntityInMap().size() > 0) {
            mapManager.getDynamicEntityInMap().forEach(o -> o.render(graphicsContext));
        }
        if (enemiesList.size() > 0) {
            enemiesList.forEach( o -> o.render(graphicsContext));
        }
        bomber.render(graphicsContext);
    }

    public Scene getGameScene() {
        return gameScene;
    }

}
