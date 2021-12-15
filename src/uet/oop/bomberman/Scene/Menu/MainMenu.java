package uet.oop.bomberman.Scene.Menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import uet.oop.bomberman.Scene.Menu.MenuController.MenuButton;
import uet.oop.bomberman.Scene.Menu.NewGame.NewGameSubScene;
import uet.oop.bomberman.Setup.BaseWindow;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private Scene menuScene;
    private AnchorPane menuRoot;
    private List<MenuButton> menuButtons;

    private MenuSubScene newGameSubScene;
    private MenuSubScene creditsSubScene;
    private MenuSubScene helpSubScene;
    private MenuSubScene scoreSubScene;

    private MenuSubScene sceneToHide;

    private final static int NEW_BUTTON_START_X = 85;
    private final static int NEW_BUTTON_START_Y = 220;

    private void Initialize() {
        menuButtons = new ArrayList<>();

        menuRoot = new AnchorPane();
        menuRoot.setPrefSize(BaseWindow.WIDTH, BaseWindow.HEIGHT);

        menuScene = new Scene(menuRoot, BaseWindow.WIDTH, BaseWindow.HEIGHT);
    }

    public MainMenu() {
        Initialize();
        createSubScene();
        createButton();
        createBackGround();
        createLogo();
    }

    private void createLogo() {
        ImageView logo = new ImageView(new Image("logo.png", 720, 170, false, true));
        logo.setLayoutX(-180);
        logo.setLayoutY(30);

        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(new DropShadow());
            }
        });

        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(null);
            }
        });

        menuRoot.getChildren().add(logo);

    }

    private void showSubScene(MenuSubScene subScene) {
        if (sceneToHide != null) {
            if (sceneToHide.equals(subScene)) {
                sceneToHide = null;
                subScene.moveSubScene();
                return ;
            } else {
                sceneToHide.moveSubScene();
            }
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    private void createSubScene() {
        creditsSubScene = new MenuSubScene();
        menuRoot.getChildren().add(creditsSubScene);

        helpSubScene = new MenuSubScene();
        menuRoot.getChildren().add(helpSubScene);

        scoreSubScene = new MenuSubScene();
        menuRoot.getChildren().add(scoreSubScene);

        newGameSubScene = new NewGameSubScene();
        menuRoot.getChildren().add(newGameSubScene);

    }

    private void createButton() {
        createNewGameButton();
        createScoreButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    private void createBackGround() {

        Image backgroundImage = new Image("background1.jpg", BaseWindow.WIDTH, BaseWindow.HEIGHT, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        menuRoot.setBackground(new Background(background));
    }

    private void addMenuButton(MenuButton button) {
        button.setLayoutX(NEW_BUTTON_START_X);
        button.setLayoutY(NEW_BUTTON_START_Y + menuButtons.size()*52);
        menuButtons.add(button);
        menuRoot.getChildren().add(button);
    }

    private void createNewGameButton() {
        MenuButton newGameButton = new MenuButton("NEW GAME");
        addMenuButton(newGameButton);

        newGameButton.setOnAction(actionEvent -> showSubScene(newGameSubScene));
    }

    private void createScoreButton() {
        MenuButton scoreboardButton = new MenuButton("SCORES");
        addMenuButton(scoreboardButton);

        scoreboardButton.setOnAction(actionEvent -> showSubScene(scoreSubScene));
    }

    private void createHelpButton() {
        MenuButton helpButton = new MenuButton("HELP");
        addMenuButton(helpButton);

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(helpSubScene);
            }
        });
    }

    private void createCreditsButton() {
        MenuButton creditsButton = new MenuButton("CREDITS");
        addMenuButton(creditsButton);

        creditsButton.setOnAction(actionEvent -> showSubScene(creditsSubScene));
    }

    private void createExitButton() {
        MenuButton exitButton = new MenuButton("EXIT");
        addMenuButton(exitButton);
        exitButton.setOnAction(actionEvent -> ((Stage)(((MenuButton) actionEvent.getSource()).getScene().getWindow())).close());
    }

    public Scene getMenuScene() {
        return menuScene;
    }


}
