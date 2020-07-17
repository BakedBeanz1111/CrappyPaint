package model;

import java.awt.*;

public class DrawShapeCommand {

    public Point startPoint;
    public Point endPoint;
    public ShapeType shapeType;
    public ShapeList shapeList;
    public Shape shape;
    public Color shapeColor;
    public Color lineColor;

    public DrawShapeCommand(Point startPoint, Point endPoint, ShapeType shapeType, ShapeList shapeList, Color shapeColor, Color lineColor) {

        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = shapeType;
        this.shapeList = shapeList;
        this.shapeColor = shapeColor;
        this.lineColor = lineColor;
    }

    public void run() {

        shape = new Shape(startPoint, endPoint, shapeType, shapeColor, lineColor);
        shapeList.add(shape);
    }
}
