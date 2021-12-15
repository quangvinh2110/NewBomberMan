package uet.oop.bomberman.GraphicsRenderer;


import javafx.scene.image.Image;
import javafx.scene.paint.Color;


/**
 * Class này để tạo ra các màu gradient (ở đây là linear gradient)
 */
public class GradientColor {

    public static final Color transparentColor = new Color(0, 0, 0, 0);

    private final Color color;
    private final double changingLength;

    private final double redDiff;
    private final double greenDiff;
    private final double blueDiff;
    private final double alphaDiff;


    public GradientColor(Color color1, Color color2, double changingLength) {
        this.color = color1;
        this.changingLength = changingLength;

        this.redDiff = (color2.getRed() - color1.getRed()) / changingLength;
        this.greenDiff = (color2.getGreen() - color1.getGreen()) / changingLength;
        this.blueDiff = (color2.getBlue() - color1.getBlue()) / changingLength;
        this.alphaDiff = (color2.getOpacity() - color1.getOpacity()) / changingLength;
    }


    public Color getGradientColor(double distance) {
        if (distance < 0) distance = 0;
        else if (distance > changingLength) distance = changingLength;

        int red = (int) Math.round(color.getRed() + redDiff * distance);
        int green = (int) Math.round(color.getGreen() + greenDiff * distance);
        int blue = (int) Math.round(color.getBlue() + blueDiff * distance);
        int alpha = (int) Math.round(color.getOpacity() + alphaDiff * distance);

        return new Color(red, green, blue, alpha);
    }


    public static Color getMiddleColor(Color color1, Color color2) {
        double red = Math.round((color1.getRed() + color2.getRed()) / 2.0);
        double green = Math.round((color1.getGreen() + color2.getGreen()) / 2.0);
        double blue = Math.round((color1.getBlue() + color2.getBlue()) / 2.0);
        return new Color(red, green, blue, 1);
    }


    /**
     * Method này thay đổi màu gradient trên background cùng với trục x (tính từ góc trái trên)
     * Chỉ thay đổi trong hình chữ nhật có biên là : {xa <= x <= xb; ya <= y <= yb}.
     */
//    public static void createGradientBackground_alongX(Image gradientBackground, Color color1, Color color2, int fromLineX, int toLineX, int fromLineY, int toLineY) {
//
//        final Canvas canvas = new Canvas(gradientBackground.getWidth(), gradientBackground.getHeight());
//        if (fromLineX > toLineX) {
//            int tempX = fromLineX;
//            fromLineX = toLineX;
//            toLineX = tempX;
//
//            Color tempColor = color1;
//            color1 = color2;
//            color2 = tempColor;
//        }
//
//        GradientColor color = new GradientColor(color1, color2, toLineX - fromLineX);
//        int j = 0;
//        for (int i = fromLineX; i < toLineX; i++) {
//            g.setColor(color.getGradientColor(j++));
//            g.drawLine(i, fromLineY, i, toLineY);
//        }
//
//        g.dispose();
//    }


    public static void createGradientBackground_alongX(Image gradientBackground, Color color1, Color color2, int fromLineX, int toLineX, int fromLineY, int toLineY) {

    }


    /**
     * Method này thay đổi màu gradient trên background cùng với trục x (tính từ góc trái trên)
     * Chỉ thay đổi trong hình chữ nhật có biên của cột x là : {xa <= x <= xb} (y không bị giới hạn)
     */
    public static void createGradientBackground_alongX(Image gradientBackground, Color color1, Color color2, int fromLineX, int toLineX) {
        createGradientBackground_alongX(gradientBackground, color1, color2, fromLineX, toLineX, 0, (int) gradientBackground.getHeight());
    }


    /**
     * Method này thay đổi màu gradient trên background cùng với trục x (tính từ góc trái trên)
     * Ở đây x và y không bị giới hạn.
     */
    public static void createGradientBackground_alongX(Image gradientBackground, Color color1, Color color2) {
        createGradientBackground_alongX(gradientBackground, color1, color2, 0, (int) gradientBackground.getWidth(), 0, (int) gradientBackground.getHeight());
    }


    /**
     * Method này thay đổi màu gradient trên background cùng với trục y (tính từ góc trái trên)
     * Chỉ thay đổi trong hình chữ nhật có biên là: {xa <= x <= xb; ya <= y <= yb}.
     */
//    public static void createGradientBackground_alongY(Image gradientBackground, Color color1, Color color2, int fromLineY, int toLineY, int fromLineX, int toLineX) {
//        Graphics2D g = gradientBackground.createGraphics();
//
//        if (fromLineY > toLineY) {
//            int tempY = fromLineY;
//            fromLineY = toLineY;
//            toLineY = tempY;
//
//            Color tempColor = color1;
//            color1 = color2;
//            color2 = tempColor;
//        }
//
//        GradientColor color = new GradientColor(color1, color2, toLineY - fromLineY);
//        int j = 0;
//        for (int i = fromLineY; i < toLineY; i++) {
//            g.setColor(color.getGradientColor(j++));
//            g.drawLine(fromLineX, i, toLineX, i);
//        }
//
//        g.dispose();
//    }

    public static void createGradientBackground_alongY(Image gradientBackground, Color color1, Color color2, int fromLineY, int toLineY, int fromLineX, int toLineX) {

    }


    /**
     * Changing gradient color is along with Y-axis.
     */
    public static void createGradientBackground_alongY(Image gradientBackground, Color color1, Color color2, int fromLineY, int toLineY) {
        createGradientBackground_alongY(gradientBackground, color1, color2, fromLineY, toLineY, 0, (int) gradientBackground.getWidth());
    }


    /**
     * Changing gradient color is along with Y-axis.
     */
    public static void createGradientBackground_alongY(Image gradientBackground, Color color1, Color color2) {
        createGradientBackground_alongY(gradientBackground, color1, color2, 0, (int) gradientBackground.getHeight(), 0, (int) gradientBackground.getWidth());
    }

}
