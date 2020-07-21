package model;

import java.awt.*;

public class DrawShapeCommand {

    public Point startPoint;
    public Point endPoint;
    public ShapeType shapeType;
    public Shape shape;
    public ShapeFactory shapeFactory;


    public DrawShapeCommand(Point startPoint, Point endPoint, ShapeType shapeType, ShapeFactory shapeFactory) {

        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = shapeType;
        this.shapeFactory = shapeFactory;
    }

    public void run() {

        System.out.println("startPoint: " + startPoint);
        System.out.println("endPoint: " + endPoint);
        System.out.println("shapeType: " + shapeType);
        System.out.println("Fill Color: " + shapeFactory.applicationState.getActivePrimaryColor());
        System.out.println("Line Color: " + shapeFactory.applicationState.getActiveSecondaryColor());
        System.out.println("shapeFactory: " + shapeFactory.toString());

        shape = new Shape(startPoint, endPoint, shapeType, shapeFactory.applicationState.getActivePrimaryColor(), shapeFactory.applicationState.getActiveSecondaryColor(), shapeFactory);
        shapeFactory.shapeList.add(shape);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
    }
}
