package uet.oop.bomberman.Scene.Menu.MenuController;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import uet.oop.bomberman.Setup.ResourceLoader;

import java.io.FileNotFoundException;

public class MenuButton extends Button {

    private static final String buttonStyle = "-fx-background-color: transparent; -fx-background-image: url('white_button.png');";
    private static final String buttonPressedStyle = "-fx-background-color: transparent; -fx-background-image: url('white_button_pressed.png');";

    public MenuButton(String text) {
        setText(text);
        setButtonFont();
        setPrefHeight(49);
        setPrefWidth(190);
        setStyle(buttonStyle);
        InitializeButtonListener();
    }

    private void setButtonFont() {
        setFont(ResourceLoader.loadFont("kenVector_future.ttf", 23));
    }

    private void setButtonPressedStyle() {
        setStyle(buttonPressedStyle);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonReleasedStyle() {
        setStyle(buttonStyle);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    private void InitializeButtonListener() {
        setOnMousePressed(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                setButtonPressedStyle();
            }
        });

        setOnMouseReleased(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                setButtonReleasedStyle();
            }
        });

        setOnMouseEntered(mouseEvent -> setEffect(new DropShadow()));

        setOnMouseExited(mouseEvent -> setEffect(null));
    }
}
