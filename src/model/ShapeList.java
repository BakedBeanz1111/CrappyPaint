package model;

//While researching how to draw shapes with Java Swing, I came across this post that inspired my approach
//https://mkyong.com/swing/java-swing-draw-shapes-dynamically-example/

import java.util.ArrayList;
import src.controller.DrawShapeHandler;

public class ShapeList {

    ArrayList<Shape> shapeArrayList = new ArrayList<Shape>();
    DrawShapeHandler drawShapeHandler;

    public ShapeList(src.controller.DrawShapeHandler drawShapeHandler) {

        this.drawShapeHandler = drawShapeHandler;
    }

    public void add(Shape shape) {

        shapeArrayList.add(shape);
        drawShapeHandler.update(shapeArrayList);
    }

    public void remove(Shape shape) {

        shapeArrayList.remove(shape);
        drawShapeHandler.update(shapeArrayList);
    }

    public int size() {

        int counter = 0;

        for(Shape shape:shapeArrayList) {
            counter ++;
        }

        return counter;
    }

    public Shape getShapeIndex(int index) {

        return this.shapeArrayList.get(index);
    }
}