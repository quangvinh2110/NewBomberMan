package uet.oop.bomberman.Scene.Menu.NewGame;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import uet.oop.bomberman.GraphicsRenderer.Animation.TransitionAnimation;
import uet.oop.bomberman.Scene.Game.MainGame;
import uet.oop.bomberman.Scene.Menu.MenuController.MenuButton;
import uet.oop.bomberman.Scene.Menu.MenuSubScene;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Bomber;

import java.util.ArrayList;
import java.util.List;

public class NewGameSubScene extends MenuSubScene {

    private List<CharacterPicker> characterList;
    private Bomber chosenBomber;

    public NewGameSubScene() {

        super();
        InfoLabel chooseCharacterLabel = new InfoLabel("CHOOSE YOUR CHARACTER");
        chooseCharacterLabel.setLayoutX(110);
        chooseCharacterLabel.setLayoutY(25);

        this.getRootAnchorPane().getChildren().add(chooseCharacterLabel);
        this.getRootAnchorPane().getChildren().add(createCharacterToChoose());
        this.getRootAnchorPane().getChildren().add(createStartButton());


    }

    private HBox createCharacterToChoose() {
        HBox box = new HBox();
        box.setSpacing(5);
        characterList = new ArrayList<>();
        for (Bomber BOMBER : Bomber.values()) {
            CharacterPicker characterPicker = new CharacterPicker(BOMBER);
            box.getChildren().add(characterPicker);
            characterList.add(characterPicker);
            characterPicker.setOnMouseClicked(mouseEvent -> {
                for (CharacterPicker character1 : characterList) {
                    character1.setIsChosenEffect(false);
                }
                characterPicker.setIsChosenEffect(true);
                chosenBomber = characterPicker.getCharacter();
            });
        }
        box.setLayoutX(60);
        box.setLayoutY(100);
        return box;
    }

    private MenuButton createStartButton() {
        MenuButton startButton = new MenuButton("START");
//        startButton.setTextFill(Color.YELLOW);
        startButton.setLayoutX(350);
        startButton.setLayoutY(320);

        startButton.setOnAction(actionEvent -> {
            if (chosenBomber != null) {
                MainGame mainGame = new MainGame();
                mainGame.createNewGame(chosenBomber);
                Scene scene1 = ((MenuButton) actionEvent.getSource()).getScene();
                Stage mainStage = (Stage) scene1.getWindow();
                TransitionAnimation.run(mainStage, scene1, mainGame.getGameScene());

            }
        });

        return startButton;
    }

}
