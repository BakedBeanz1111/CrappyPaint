package src.controller;

import model.Shape;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class DrawHandler {

    public PaintCanvas paintCanvas;

    public DrawHandler(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void update(ArrayList<Shape> shapeArrayList) {
        for (Shape shape : shapeArrayList ){
            paintCanvas.getGraphics2D().drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
        }
    }

}
