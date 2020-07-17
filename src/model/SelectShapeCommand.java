package model;

import java.awt.*;
import java.util.List;

public class SelectShapeCommand {

    public Shape shape;
    public List<Shape> selectedShapesList;
    public Point startPoint;
    public Point endPoint;
    public int xStart, yStart, xEnd, yEnd;

    public SelectShapeCommand(Shape shape, Point startPoint, Point endPoint) {

        this.shape = shape;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void addShapeToList(List<Shape> shapeList) {

        xStart = startPoint.x;
        yStart = startPoint.y;

        xEnd = endPoint.x;
        yEnd = endPoint.y;

        for (Shape shape : shapeList) {

            if (shape.containsPoints(xStart, yStart) && shape.containsPoints(xEnd, yEnd)) {

                //add shape to list
            }
        }

    }
}
