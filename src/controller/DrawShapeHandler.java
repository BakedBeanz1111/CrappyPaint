package src.controller;

import model.Shape;
import view.gui.PaintCanvas;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class DrawShapeHandler {

    public PaintCanvas paintCanvas;

    public DrawShapeHandler(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void update(ArrayList<Shape> shapeArrayList) {
        for (Shape shape : shapeArrayList ){
            if(shape.getShapeType().toString().equals("RECTANGLE")) {
                paintCanvas.getGraphics2D().drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
            }
            else if(shape.getShapeType().toString().equals("ELLIPSE")) {
                paintCanvas.getGraphics2D().draw(new Ellipse2D.Double(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight()));
            }
            else if(shape.getShapeType().toString().equals("TRIANGLE")) {
                int[] xCoordinates = {shape.getxMin(), shape.getxMax(), shape.getTriangleMidPoint()};
                int[] yCoordinates = {shape.getyMin(), shape.getyMax()};

                paintCanvas.getGraphics2D().drawPolygon(xCoordinates, yCoordinates, 3);
            }
            //use draw* for putting shapes. I only used fillRect to fill in the rectangle for sprint #1
            //paintCanvas.getGraphics2D().drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight()); //using shape.getxMin()/getyMin() solved the drawing problem
            //paintCanvas.getGraphics2D().fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

        }
    }

}
