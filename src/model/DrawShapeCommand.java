package model;

import java.awt.*;

public class DrawShapeCommand {
    public Point startPoint;
    public Point endPoint;
    public ShapeType shapeType;
    public ShapeList shapeList;
    public Shape shape;

    public DrawShapeCommand(Point startPoint, Point endPoint, ShapeType shapeType, ShapeList shapeList) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = shapeType;
        this.shapeList = shapeList;
    }

    public void run() {
        shape = new Shape(startPoint, endPoint, shapeType);
        shapeList.add(shape);
    }
}
