package uet.oop.bomberman.GraphicsRenderer;

import uet.oop.bomberman.entities.Bomb.Bomb;

import java.util.Comparator;

/**
 * Class này để sắp xếp thứ các đối tượng sẽ được render
 */
public class RenderingOrder implements Comparator<GraphicsObject> {

    public int compare(GraphicsObject g1, GraphicsObject g2) {
        if (g1.getImageLocationY() < g2.getImageLocationY()) {
            return -1;
        }
        if (g1.getImageLocationY() > g2.getImageLocationY()) {
            return +1;
        }

        boolean is_g1_Bomb = g1 instanceof Bomb;
        boolean is_g2_Bomb = g2 instanceof Bomb;
        if (is_g1_Bomb && !is_g2_Bomb) return -1;
        if (!is_g1_Bomb && is_g2_Bomb) return +1;

        return 0;
    }
}
