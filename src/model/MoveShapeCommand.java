package model;

import model.interfaces.IShapeCommand;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MoveShapeCommand implements IShapeCommand {

    public Point mousePressed;
    public Point mouseReleased;
    public ShapeType shapeType;
    public ShapeFactory shapeFactory;
    public List<Shape> movedShapesList = new ArrayList<>();
    public int deltaX;
    public int deltaY;

    public MoveShapeCommand(Point mousePressed, Point mouseReleased, ShapeType shapeType, ShapeFactory shapeFactory ) {

        this.mousePressed = mousePressed;
        this.mouseReleased = mouseReleased;
        this.shapeType = shapeType;
        this.shapeFactory = shapeFactory;

        deltaX = mouseReleased.x - mousePressed.x;
        deltaY = mouseReleased.y - mousePressed.y;
    }

    public void moveShape(List<Shape> shapeList) {

        for(Shape shape : shapeList) {

            if(shape.containsPoints(mousePressed.x, mousePressed.y)) {

                int newOriginX = shape.startPoint.x + deltaX;
                int newOriginY = shape.startPoint.y + deltaY;

                int newEndX = shape.endPoint.x + deltaX;
                int newEndY = shape.endPoint.y + deltaY;

                Point newOrigin = new Point(newOriginX, newOriginY);
                Point newEnd = new Point(newEndX, newEndY);

                Shape movedShape = new Shape(newOrigin, newEnd, shapeType, shape.shapeColor, shape.lineColor, shapeFactory.applicationState.getActiveShapeShadingType());

                movedShapesList.add(shape);
                movedShapesList.add(movedShape);
            }
        }
    }

    @Override
    public void run() {

        moveShape(shapeFactory.shapeList.globalShapeList);
        shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
    }
}