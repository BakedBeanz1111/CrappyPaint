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

        for(Shape shape : shapeList) {

            deltaX =  mouseReleased.x - mousePressed.x;
            deltaY = mouseReleased.y - mousePressed.y;

            if(shape.containsPoints(mousePressed.x, mousePressed.y)) {

                newOriginX = shape.startPoint.x + deltaX;
                newOriginY = shape.startPoint.y + deltaY;

                newEndX = shape.endPoint.x + deltaX;
                newEndY = shape.endPoint.y + deltaY;

                Point newOrigin = new Point(newOriginX, newOriginY);
                Point newEnd = new Point(newEndX, newEndY);

                Shape movedShape = new Shape(newOrigin, newEnd, shapeType, shape.getShapeColor(), shape.getLineColor(), shapeFactory);

                //moveShapeList.add(shape);
                moveShapeList.add(movedShape);
            }
        }
    }

    public void run() {

        moveShape(shapeFactory.shapeList.globalShapeList);
        //shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
    }
}
