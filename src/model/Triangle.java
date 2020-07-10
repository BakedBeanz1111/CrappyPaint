package model;

import java.awt.*;

public class Triangle {

    public Point startPoint;
    public Point endPoint;
    public ShapeList shapeList;
    public ShapeType shapeType;
    public ShapeColor fillColor;

    public Triangle(Point startPoint, Point endPoint, ShapeList shapeList, ShapeType shapeType, ShapeColor fillColor) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.shapeType = shapeType;
        this.fillColor = fillColor;
    }

    public void run() {
        Shape triangle = new Shape(startPoint, endPoint, fillColor);
        shapeList.add(triangle);
    }

    public void setFillColor(ShapeColor shapeColor) {
        this.fillColor = shapeColor;
    }
}
