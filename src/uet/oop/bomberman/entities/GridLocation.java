package uet.oop.bomberman.entities;

import uet.oop.bomberman.Scene.Game.Map;

public class GridLocation {

    private int x;
    private int y;

    public GridLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GridLocation(GridLocation gridLocation) {
        this.x = gridLocation.getX();
        this.y = gridLocation.getY();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof GridLocation) {
            GridLocation gridLocation = (GridLocation) obj;
            return x == gridLocation.x && y == gridLocation.y;
        }
        return false;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPixelX() {
        return x* Map.TILE_SIZE;
    }

    public int getPixelY() {
        return y* Map.TILE_SIZE;
    }

    public static int getPixelX(int x) {
        return x* Map.TILE_SIZE;
    }

    public static int getPixelY(int y) {
        return y* Map.TILE_SIZE;
    }
}
