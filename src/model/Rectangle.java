package src.model;

import java.awt.*;

//Rectangle contains all of Shape and then some
public class Rectangle {

    //With rectangle shape, you care about the following parameters beyond the scope of generic shape
    private static int height;
    private static int width;
    private static int x;
    private static int y;
    static Point startPoint;
    static Point endPoint;

    //getters
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    //setters
    public void setHeight(int height) {
        this.height = endPoint.y - startPoint.y;
    }
    public void setWidth(int width) {
        this.width = endPoint.x - startPoint.x;
    }

    public Rectangle(int x, int y, int height, int width) {
        this.x = startPoint.x;
        this.y = startPoint.y;
        this.height = height;
        this.width = width;
    }

    public static void drawRectangle() {
        height = endPoint.y - startPoint.y;
        width = endPoint.x - startPoint.x;

        Rectangle rectangle = new Rectangle(startPoint.x,startPoint.y, height, width);
    }
}
