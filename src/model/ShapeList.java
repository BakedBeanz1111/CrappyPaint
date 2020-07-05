package model;

//While researching how to draw shapes with Java Swing, I came across this post that inspired my approach
//https://mkyong.com/swing/java-swing-draw-shapes-dynamically-example/

import java.util.ArrayList;
import src.controller.DrawHandler;

public class ShapeList {
    ArrayList<Shape> shapeArrayList = new ArrayList<Shape>();
    DrawHandler drawHandler;

    public ShapeList(DrawHandler drawHandler) {
        this.drawHandler = drawHandler;
    }

    public void add(Shape shape) {
        shapeArrayList.add(shape);
        drawHandler.update(shapeArrayList);
    }
}
