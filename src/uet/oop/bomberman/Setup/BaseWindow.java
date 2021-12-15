package uet.oop.bomberman.Setup;



import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;
import uet.oop.bomberman.Scene.Game.MainGame;
import uet.oop.bomberman.Scene.Menu.MainMenu;

import java.io.IOException;

public class BaseWindow {


    private String HowToPlayInfoFromFile;
    private String CreditInfoFromFile;


    private Stage mainStage;


    public static final int WIDTH = 1024;
    public static final int HEIGHT = 544;


    private void Initialize() {
        MainMenu mainMenu = new MainMenu();


        Scene mainScene = mainMenu.getMenuScene();

        mainStage = new Stage();
        mainStage.setResizable(false);
        mainStage.setTitle(Strings.WindowTitle);
        mainStage.setScene(mainScene);

        try {
            this.HowToPlayInfoFromFile = ResourceLoader.loadText(FilePath.InfoFilePath.HowToPlayInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.CreditInfoFromFile = ResourceLoader.loadText(FilePath.InfoFilePath.CreditInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BaseWindow() {
        Initialize();
    }

    public Stage getMainStage() {
        return mainStage;
    }


}