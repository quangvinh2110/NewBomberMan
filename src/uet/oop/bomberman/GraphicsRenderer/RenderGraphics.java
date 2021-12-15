package uet.oop.bomberman.GraphicsRenderer;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.paint.Color;


/**
 * Class này chứa tất cả các method cơ bản (Vd như scale ảnh, chỉnh giá trị alpha,...) cho việc render đồ họa.
 */
public class RenderGraphics {

    public static Image resizeImage(Image input, int width, int height) {
        ImageView imageView = new ImageView(input);
        imageView.setFitHeight(height);
        if (input.getWidth()*height == input.getHeight()*width) {
            imageView.setPreserveRatio(true);
            return imageView.snapshot(new SnapshotParameters(), null);
        }
        imageView.setFitWidth(width);
        return imageView.snapshot(new SnapshotParameters(), null);
    }

    public static Image cropImage(Image input, int x, int y, int width, int height) {
        PixelReader pixelReader = input.getPixelReader();
        return new WritableImage(pixelReader, x, y, width, height);
    }

    public static Image scaleImage(Image input, int scaleFactor) {
        final int W = (int) input.getWidth();
        final int H = (int) input.getHeight();

        WritableImage output = new WritableImage(
                W * scaleFactor,
                H * scaleFactor
        );

        PixelReader reader = input.getPixelReader();
        PixelWriter writer = output.getPixelWriter();

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                final int argb = reader.getArgb(x, y);
                for (int dy = 0; dy < scaleFactor; dy++) {
                    for (int dx = 0; dx < scaleFactor; dx++) {
                        writer.setArgb(x * scaleFactor + dx, y * scaleFactor + dy, argb);
                    }
                }
            }
        }

        return output;
    }


    public static double clampValueInRGB(double value) {
        if(value > 255) return 255;
        if(value < 0) return 0;
        return value;
    }

    public static Color setAlpha(Color color, int alpha) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), clampValueInRGB(alpha)/255);
    }

    public static Image setAlpha(Image input, double alpha) {
        alpha = clampValueInRGB(alpha);
        PixelReader pixelReader = input.getPixelReader();
        WritableImage output = new WritableImage((int) input.getWidth(), (int) input.getHeight());
        for (int y = 0; y < input.getHeight(); y++) {
            for (int x = 0; x < input.getWidth(); x++) {
                output.getPixelWriter().setArgb(x, y, (0x00ffffff | ((int) alpha << 24)) & pixelReader.getArgb(x, y));
            }
        }
        return output;
    }


    public static Image removeBackground(Image input) {
        PixelReader pixelReader = input.getPixelReader();
        WritableImage output = new WritableImage((int) input.getWidth(), (int) input.getHeight());
        PixelWriter pixelWriter = output.getPixelWriter();
        Color backgroundColor = pixelReader.getColor(1,1);
        for (int y = 0; y < input.getHeight(); y++) {
            for (int x = 0; x < input.getWidth(); x++) {
                Color color = pixelReader.getColor(x, y);
                if (color.equals(backgroundColor)) {
                    pixelWriter.setColor(x, y, setAlpha(color, 0));
                } else {
                    pixelWriter.setColor(x, y, color);
                }
            }
        }
        return output;
    }
}
