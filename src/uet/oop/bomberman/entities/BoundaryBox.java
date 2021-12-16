package uet.oop.bomberman.entities;

import uet.oop.bomberman.entities.Coordinate;

public class BoundaryBox {

    private Coordinate top_left;
    private Coordinate top_right;
    private Coordinate bottom_left;
    private Coordinate bottom_right;

    public BoundaryBox() {

    }

    public BoundaryBox(Coordinate top_left, Coordinate top_right, Coordinate bottom_left, Coordinate bottom_right) {
        this.top_left = top_left;
        this.top_right = top_right;
        this.bottom_left = bottom_left;
        this.bottom_right = bottom_right;
    }

    public BoundaryBox(Coordinate top_left, int width, int height) {
        this.top_left = top_left;
        this.top_right = new Coordinate(this.top_left.getX() + width, this.top_left.getY());
        this.bottom_left = new Coordinate(this.top_left.getX(), this.top_left.getY() + height);
        this.bottom_right = new Coordinate(this.top_left.getX() + width, this.top_left.getY() + height);
    }

    public void setTop_left(Coordinate top_left) {
        this.top_left = top_left;
    }

    public void setTop_right(Coordinate top_right) {
        this.top_right = top_right;
    }

    public void setBottom_left(Coordinate bottom_left) {
        this.bottom_left = bottom_left;
    }

    public void setBottom_right(Coordinate bottom_right) {
        this.bottom_right = bottom_right;
    }

    public Coordinate getBottom_left() {
        return bottom_left;
    }

    public Coordinate getBottom_right() {
        return bottom_right;
    }

    public Coordinate getTop_left() {
        return top_left;
    }

    public Coordinate getTop_right() {
        return top_right;
    }

    public void updateBoundaryBox(int dx, int dy) {
        this.top_left.updateCoordinate(dx, dy);
        this.top_right.updateCoordinate(dx, dy);
        this.bottom_left.updateCoordinate(dx, dy);
        this.bottom_right.updateCoordinate(dx, dy);
    }

    public int getBoundaryBoxWidth() {
        return this.top_right.getX() - this.top_left.getX();
    }

    public int getBoundaryBoxHeight() {
        return this.bottom_left.getY() - this.top_left.getY();
    }
}
