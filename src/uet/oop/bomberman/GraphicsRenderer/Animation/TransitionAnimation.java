package uet.oop.bomberman.GraphicsRenderer.Animation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.Setup.BaseWindow;

public class TransitionAnimation {

    public static void run(Stage stage, Scene scene1, Scene scene2) {

        // Create snapshots with the last state of the scenes
        WritableImage wi = new WritableImage(BaseWindow.WIDTH, BaseWindow.HEIGHT);
        Image img1 = scene1.snapshot(wi);
        ImageView imgView1 = new ImageView(img1);
        wi = new WritableImage(BaseWindow.WIDTH, BaseWindow.HEIGHT);
        Image img2 = scene2.snapshot(wi);
        ImageView imgView2 = new ImageView(img2);

        // Create new pane with both images
        imgView1.setTranslateX(0);
        imgView2.setTranslateX(BaseWindow.WIDTH);
        StackPane pane = new StackPane(imgView1,imgView2);
        pane.setPrefSize(BaseWindow.WIDTH,BaseWindow.HEIGHT);

        // Replace root1 with new pane
        Scene newScene = new Scene(pane, BaseWindow.WIDTH, BaseWindow.HEIGHT);
        stage.setScene(newScene);

        // create transition
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(imgView2.translateXProperty(), 0, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t->{
            // set scene 2
            stage.setScene(scene2);
        });
        timeline.play();
    }
}
