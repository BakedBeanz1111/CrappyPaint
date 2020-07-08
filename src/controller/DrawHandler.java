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
            //use draw* for putting shapes. I only used fillRect to fill in the rectangle for sprint #1
            //paintCanvas.getGraphics2D().drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight()); //using shape.getxMin()/getyMin() solved the drawing problem
            paintCanvas.getGraphics2D().fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
        }
    }

}
