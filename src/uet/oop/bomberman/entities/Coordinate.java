package uet.oop.bomberman.entities;

public class Coordinate {

    private int x = 0;
    private int y = 0;

    public Coordinate(){

    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void updateX(int dx){
        this.x += dx;
    }

    public void updateY(int dy) {
        this.y += dy;
    }

}
