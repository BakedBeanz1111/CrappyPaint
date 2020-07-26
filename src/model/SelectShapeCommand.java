package model;

import java.awt.*;
import java.util.List;

public class SelectShapeCommand {

    public Point startPoint;
    public Point endPoint;
    public int xStart, yStart, xEnd, yEnd;
    public ShapeFactory shapeFactory;

    public SelectShapeCommand(Point startPoint, Point endPoint, ShapeFactory shapeFactory) {

        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeFactory = shapeFactory;
    }

    public void addShapeToList(List<Shape> globalShapeList) {

        xStart = startPoint.x;
        yStart = startPoint.y;

        xEnd = endPoint.x;
        yEnd = endPoint.y;

        for (Shape shape : globalShapeList) {

            if (shape.containsPoints(xStart, yStart) && shape.containsPoints(xEnd, yEnd)) {

                shapeFactory.selectedShapesList.add(shape);
            }
        }

        System.out.println("You have selected " + shapeFactory.selectedShapesList.size() + " shapes");

    }

    public void run() {

        addShapeToList(shapeFactory.shapeList.globalShapeList);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
    }
}
