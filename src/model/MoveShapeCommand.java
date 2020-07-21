package model;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MoveShapeCommand {

    public Point mousePressed;
    public Point mouseReleased;
    public ShapeType shapeType;
    public List<Shape> moveShapeList = new ArrayList<>();
    public ShapeFactory shapeFactory;

    public MoveShapeCommand(Point mousePressed, Point mouseReleased, ShapeType shapeType, ShapeFactory shapeFactory) {

        this.mousePressed = mousePressed;
        this.mouseReleased = mouseReleased;
        this.shapeType = shapeType;
        this.shapeFactory = shapeFactory;

    }

    public void moveShape(List<Shape> shapeList) {

        int deltaX, deltaY;
        int newOriginX, newOriginY;
        int newEndX, newEndY;

        deltaX =  mouseReleased.x - mousePressed.x;
        deltaY = mouseReleased.y - mousePressed.y;

        for(Shape shape : shapeList) {

            newOriginX = shape.startPoint.x + deltaX;
            newOriginY = shape.startPoint.y + deltaY;

            newEndX = shape.endPoint.x + deltaX;
            newEndY = shape.endPoint.y + deltaY;

            shape.startPoint = new Point(newOriginX, newOriginY);
            shape.endPoint = new Point(newEndX, newEndY);
        }
    }

    public void run() {
        moveShape();
    }
}
