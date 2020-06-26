package src.controller;

//Object used to define coordinate pairs on an XY grid
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //get Methods
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    //set Methods
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
