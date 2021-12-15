package uet.oop.bomberman.Setup;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.text.Font;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

public class ResourceLoader {

    public static String loadText(String filePath) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ResourceLoader.class.getResourceAsStream(filePath))));

        char[] buffer = new char[1 << 13];
        StringBuilder sb = new StringBuilder();
        try {
            while (in.read(buffer) != -1) {
                sb.append(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static BufferedImage loadBufferedImage(String filePath) throws IOException {
        return ImageIO.read(Objects.requireNonNull(ResourceLoader.class.getResource(filePath)));
    }

    public static Image loadImage(String filePath) {
        try {
            return new Image(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image loadImage(String filePath, int width, int height, boolean preserveRatio, boolean smooth) {
        try {
            return new Image(filePath, width, height, preserveRatio, smooth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Media loadSound(String filePath) {
        try {
            return new Media(Objects.requireNonNull(ResourceLoader.class.getResource(filePath)).toURI().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Font loadFont(String filePath, double size) {
        try {
            return Font.loadFont(new FileInputStream(filePath), size);
        } catch (FileNotFoundException e) {
            return Font.font("Verdana",23);
        }
    }
}
