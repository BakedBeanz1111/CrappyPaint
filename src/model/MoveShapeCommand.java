package model;

import java.awt.*;

public class MoveShapeCommand {

    public Point newStartPoint;
    public Point newEndPoint;
    public ShapeList shapeList;
    Shape shape;

    public MoveShapeCommand(Point newStartPoint, Point newEndPoint, ShapeList shapeList) {

        this.newStartPoint = newStartPoint;
        this.newEndPoint = newEndPoint;
        this.shapeList = shapeList;

    }

    public void moveShape() {

        int deltaX, deltaY;
        int newOriginX, newOriginY;
        int newEndX, newEndY;

        deltaX =  newEndPoint.x - newStartPoint.x;
        deltaY = newEndPoint.y - newStartPoint.y;

        newOriginX = shape.startPoint.x + deltaX;
        newOriginY = shape.startPoint.y + deltaY;

        newEndX = shape.endPoint.x + deltaX;
        newEndY = shape.endPoint.y + deltaY;

        shape.startPoint = new Point(newOriginX, newOriginY);
        shape.endPoint = new Point(newEndX, newEndY);
    }

    public void run() {
        moveShape();
    }
}
