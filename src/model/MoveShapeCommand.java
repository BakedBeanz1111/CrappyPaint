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
    public int deltaX, deltaY;

    public MoveShapeCommand(Point mousePressed, Point mouseReleased, ShapeType shapeType, ShapeFactory shapeFactory) {

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

                int newOriginX, newOriginY;
                int newEndX, newEndY;

                newOriginX = shape.startPoint.x + deltaX;
                newOriginY = shape.startPoint.y + deltaY;

                newEndX = shape.endPoint.x + deltaX;
                newEndY = shape.endPoint.y + deltaY;

                Point newOrigin = new Point(newOriginX, newOriginY);
                Point newEnd = new Point(newEndX, newEndY);

                Shape movedShape = new Shape(newOrigin, newEnd, shapeType, shape.getShapeColor(), shape.getLineColor(), shapeFactory, shape.shapeShadingType);

                //moveShapeList.add(shape);
                //shapeList.remove(shape);
                moveShapeList.add(movedShape);
            }
        }
    }

    public void run() {

        moveShape(shapeFactory.shapeList.globalShapeList);
        shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
    }
}
