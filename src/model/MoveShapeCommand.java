package model;

import interfaces.IUndoRedo;
import model.interfaces.IShapeCommand;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MoveShapeCommand implements IShapeCommand, IUndoRedo {

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

    //The observed bug revolves around containsPoints function. It only says the first clicked shape has the contained points
    //and doesn't select other shapes for movement
    public void moveShape(List<Shape> shapeList) {

        System.out.println(shapeList.toString()); //debug information to figure out why its not doing collision detection when selecting shapes

        for(Shape shape : shapeList) {

            System.out.println("moveShape");

            if(shape.containsPoints(mousePressed.x, mousePressed.y)) {

                int newOriginX = shape.startPoint.x + deltaX;
                int newOriginY = shape.startPoint.y + deltaY;

                int newEndX = shape.endPoint.x + deltaX;
                int newEndY = shape.endPoint.y + deltaY;

                Point newOrigin = new Point(newOriginX, newOriginY);
                Point newEnd = new Point(newEndX, newEndY);

                Shape movedShape = new Shape(newOrigin, newEnd, shapeType, shape.shapeColor, shape.lineColor, shapeFactory.applicationState.getActiveShapeShadingType());

                shapeList.remove(shape);
                shapeList.add(movedShape);

                movedShapesList.add(shape);
                movedShapesList.add(movedShape);
            }
            else {

                System.out.println("You're not clicking anything to move!");
            }
        }
    }

    @Override
    public void run() {

        moveShape(shapeFactory.shapeList.globalShapeList);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
    }

    @Override
    public void undo() {

        if(shapeFactory.shapeList.globalShapeList.size() <= 0) {

            System.out.println("you can't undo");
        }
        else{

            shapeFactory.shapeList.globalShapeList.remove(shapeFactory.shapeList.globalShapeList.size()-1);

            shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.globalShapeList);
        }
    }

    @Override
    public void redo() {

        run();
    }
}