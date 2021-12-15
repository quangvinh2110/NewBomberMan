package uet.oop.bomberman.Scene.Menu.NewGame;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import uet.oop.bomberman.Setup.ResourceLoader;
import uet.oop.bomberman.entities.MovingEntity.Bomber.Bomber;

public class CharacterPicker extends VBox {

    private final Bomber bomber;

    private boolean isChosen;

    public CharacterPicker(Bomber bomber) {
        ImageView characterImage = new ImageView(ResourceLoader.loadImage(bomber.getUrlCharacter(), 119, 200, false, true));
        this.bomber = bomber;
        isChosen = false;
        this.getChildren().add(characterImage);
    }

    public Bomber getCharacter() {
        return bomber;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setIsChosenEffect(boolean isChosen) {
        this.isChosen = isChosen;
        if (isChosen) {
            setEffect(new DropShadow());
        } else {
            setEffect(null);
        }
    }



}
