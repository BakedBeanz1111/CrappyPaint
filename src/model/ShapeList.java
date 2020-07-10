package model;

//While researching how to draw shapes with Java Swing, I came across this post that inspired my approach
//https://mkyong.com/swing/java-swing-draw-shapes-dynamically-example/

import java.util.ArrayList;

public class ShapeList {
    ArrayList<Shape> shapeArrayList = new ArrayList<Shape>();
    src.controller.DrawShapeHandler drawShapeHandler;

    public ShapeList(src.controller.DrawShapeHandler drawShapeHandler) {
        this.drawShapeHandler = drawShapeHandler;
    }

    public void add(Shape shape) {
        shapeArrayList.add(shape);
        drawShapeHandler.update(shapeArrayList);
    }
}
