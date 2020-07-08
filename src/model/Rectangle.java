package src.model;

import model.Shape;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeType;
import java.awt.*;

public class Rectangle {

    public Point startPoint;
    public Point endPoint;
    public ShapeList shapeList;
    public ShapeType shapeType;
    public ShapeColor fillColor;

    public Rectangle(Point startPoint, Point endPoint, ShapeList shapeList, ShapeType shapeType, ShapeColor fillColor) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.shapeType = shapeType;
        this.fillColor = fillColor;
    }

    public void run() {
        Shape rectangle = new Shape(startPoint, endPoint, fillColor);
        shapeList.add(rectangle);
    }

    public void setFillColor(ShapeColor shapeColor) {
        this.fillColor = shapeColor;
    }
}
