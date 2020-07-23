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

        shape = new Shape(startPoint, endPoint, shapeType, shapeFactory.applicationState.getActivePrimaryColor(), shapeFactory.applicationState.getActiveSecondaryColor(), shapeFactory, shapeFactory.applicationState.getActiveShapeShadingType());
        shapeFactory.shapeList.globalShapeList.add(shape);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
    }
}
