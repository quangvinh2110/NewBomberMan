package uet.oop.bomberman.Scene.Menu;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.GraphicsRenderer.RenderGraphics;

public class Test extends Application {
//    public void start(Stage stage) throws IOException {
//        //creating the image object
//        Image background = RenderGraphics.cropImage(Objects.requireNonNull(ResourceLoader.loadImage("background1.jpg")), 0, 0, 400, 425);
//        Image image1 = RenderGraphics.removeBackground(Objects.requireNonNull(ResourceLoader.loadImage("BarbarianBomber.png")));
//        ImageView imageView1 = new ImageView(image1);
//        ImageView backgroundImageView = new ImageView(background);
//        StackPane root = new StackPane();
//        root.getChildren().add(backgroundImageView);
//        root.getChildren().add(imageView1);
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    private final long[] frameTimes = new long[100];
    private int frameTimeIndex = 0 ;
    private boolean arrayFilled = false ;


    @Override
    public void start(Stage primaryStage) {
        Label label = new Label();
        AnimationTimer frameRateMeter = new AnimationTimer() {

            @Override
            public void handle(long now) {
                long oldFrameTime = frameTimes[frameTimeIndex] ;
                frameTimes[frameTimeIndex] = now ;
                frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length ;
                if (frameTimeIndex == 0) {
                    arrayFilled = true ;
                }
                if (arrayFilled) {
                    long elapsedNanos = now - oldFrameTime ;
                    long elapsedNanosPerFrame = elapsedNanos / frameTimes.length ;
                    double frameRate = 1_000_000_000.0 / elapsedNanosPerFrame ;
                    label.setText(String.format("Current frame rate: %.3f", frameRate));
                }
            }
        };

        frameRateMeter.start();

        primaryStage.setScene(new Scene(new StackPane(label), 250, 150));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}