package model;

//While researching how to draw shapes with Java Swing, I came across this post that inspired my approach
//https://mkyong.com/swing/java-swing-draw-shapes-dynamically-example/

import java.util.ArrayList;
import java.util.List;

import src.controller.DrawShapeHandler;

public class ShapeList {

    DrawShapeHandler drawShapeHandler;
    public List<Shape> globalShapeList;

    public ShapeList(src.controller.DrawShapeHandler drawShapeHandler, List<Shape> globalShapeList) {

        this.drawShapeHandler = drawShapeHandler;
        this.globalShapeList = globalShapeList;
    }

    public void add(Shape shape) {

        System.out.println("shape: " + shape.toString());

        globalShapeList.add(shape);
        drawShapeHandler.update(globalShapeList);
    }

    public void remove(Shape shape) {

        globalShapeList.remove(shape);
        drawShapeHandler.update(globalShapeList);
    }

    public int size() {

        int counter = 0;

        for(Shape shape : globalShapeList) {
            counter ++;
        }

        return counter;
    }

    public Shape getShapeIndex(int index) {

        return this.globalShapeList.get(index);
    }
}