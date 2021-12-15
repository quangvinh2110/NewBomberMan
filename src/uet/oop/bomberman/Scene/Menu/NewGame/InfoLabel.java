package uet.oop.bomberman.Scene.Menu.NewGame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import uet.oop.bomberman.Setup.ResourceLoader;

import java.io.FileNotFoundException;
import java.util.Objects;

public class InfoLabel extends Label {

    public InfoLabel(String text) {

        setPrefWidth(380);
        setPrefHeight(49);
        setText(text);
        setWrapText(true);
        setLabelFont();
        setBackgroundImage();
        setAlignment(Pos.CENTER);
    }

    private void setLabelFont() {
        setFont(ResourceLoader.loadFont("kenVector_future.ttf", 22));
    }

    private void setBackgroundImage() {
        BackgroundImage backgroundImage = new BackgroundImage(Objects.requireNonNull(ResourceLoader.loadImage(
                "/NewGame/small_blue_panel.png",380, 49, false, true)),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, null);
        setBackground(new Background(backgroundImage));

    }
}
