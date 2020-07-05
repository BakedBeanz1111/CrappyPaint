package src.model;

import java.awt.*;

//Rectangle contains all of Shape and then some
public class Rectangle extends Shape {

    //With rectangle shape, you care about the following parameters beyond the scope of generic shape
    public int height;
    public int width;

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
}
