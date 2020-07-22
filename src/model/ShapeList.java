package model;

//While researching how to draw shapes with Java Swing, I came across this post that inspired my approach
//https://mkyong.com/swing/java-swing-draw-shapes-dynamically-example/

import java.util.ArrayList;
import java.util.List;

import src.controller.DrawShapeHandler;

public class ShapeList {

    DrawShapeHandler drawShapeHandler;
    public List<Shape> globalShapeList;

    public ShapeList(DrawShapeHandler drawShapeHandler, List<Shape> globalShapeList) {

        this.drawShapeHandler = drawShapeHandler;
        this.globalShapeList = globalShapeList;
    }
}