package model;

import interfaces.IUndoRedo;

import java.awt.*;

public class DrawShapeCommand implements IUndoRedo {

    public Point startPoint;
    public Point endPoint;
    public Shape shape;
    public ShapeType shapeType;
    public ShapeFactory shapeFactory;


    public DrawShapeCommand(Point startPoint, Point endPoint, ShapeType shapeType, ShapeFactory shapeFactory) {

        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = shapeType;
        this.shapeFactory = shapeFactory;
    }

    public void run() {

        shape = new Shape(startPoint, endPoint, shapeType, shapeFactory.applicationState.getActivePrimaryColor(), shapeFactory.applicationState.getActiveSecondaryColor(), shapeFactory.applicationState.getActiveShapeShadingType());
        shapeFactory.shapeList.globalShapeList.add(shape);

        System.out.println("You have drawn " + shapeFactory.shapeList.globalShapeList.size() + " shapes");

        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);

        CommandHistory.add(this);
    }

    @Override
    public void undo() {

        CommandHistory.undo();
    }

    @Override
    public void redo() {

        run();
    }
}
