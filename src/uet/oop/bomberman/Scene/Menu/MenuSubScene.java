package uet.oop.bomberman.Scene.Menu;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.util.Duration;

public class MenuSubScene extends SubScene {


    private boolean isHidden;

    public MenuSubScene() {
        super(new AnchorPane(), 600, 400);
        prefWidth(600);
        prefHeight(400);

        Image backgroundImage = new Image("background3.png", 600, 400, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, null);

        AnchorPane creditRoot = (AnchorPane)  this.getRoot();
        creditRoot.setBackground(new Background(background));

        setLayoutX(1060);
        setLayoutY(71);

        InitializeSubSceneListener();

        isHidden = true;
    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.3));
        transition.setNode(this);
        if(isHidden) {
            transition.setToX(-676);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }

    private void InitializeSubSceneListener() {

        setOnMouseEntered(mouseEvent -> setEffect(new DropShadow()));

        setOnMouseExited(mouseEvent -> setEffect(null));
    }

    public AnchorPane getRootAnchorPane() {
        return (AnchorPane) this.getRoot();
    }
}
