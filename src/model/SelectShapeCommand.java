package model;

import model.interfaces.IShapeCommand;
import java.awt.*;
import java.util.List;

public class SelectShapeCommand implements IShapeCommand {

    public Point startPoint;
    public Point endPoint;
    public int xStart, yStart, xEnd, yEnd;
    public ShapeFactory shapeFactory;

    public SelectShapeCommand(Point startPoint, Point endPoint, ShapeFactory shapeFactory) {

        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeFactory = shapeFactory;
    }

    public void selectShape(List<Shape> globalShapeList) {

        xStart = startPoint.x;
        yStart = startPoint.y;

        xEnd = endPoint.x;
        yEnd = endPoint.y;

        for (Shape shape : globalShapeList) {

            if (shape.containsPoints(xStart, yStart) && shape.containsPoints(xEnd, yEnd)) {

                System.out.println("You're clicking something!");

                shape.selectShape(); //This is the wrong implementation of select shape
                shapeFactory.selectedShapesList.add(shape);
            }
        }

        System.out.println("You have selected " + shapeFactory.selectedShapesList.size() + " shapes");
    }

    @Override
    public void run() {

        selectShape(shapeFactory.shapeList.globalShapeList);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
    }
}
