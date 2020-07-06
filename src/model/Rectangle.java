package src.model;

import model.Shape;
import model.ShapeList;
import model.ShapeType;
import java.awt.*;

public class Rectangle {

    public Point startPoint;
    public Point endPoint;
    public ShapeList shapeList;
    public ShapeType shapeType;

    public Rectangle(Point startPoint, Point endPoint, ShapeList shapeList, ShapeType shapeType) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.shapeType = shapeType;
    }

    public void run() {
        Shape rectangle = new Shape(startPoint, endPoint);
        shapeList.add(rectangle);
    }
}
