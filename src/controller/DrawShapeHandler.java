package src.controller;

import model.Shape;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class DrawShapeHandler {

    public PaintCanvas paintCanvas;
    private IApplicationState applicationState;
    private ShapeType shapeType;

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
                int[] xCoordinates = {shape.getxMin(), shape.getTriangleMidPoint(), shape.getxMax() };
                int[] yCoordinates = {shape.getyMin(), shape.getyMax(), shape.getyMin()};

                paintCanvas.getGraphics2D().drawPolygon(xCoordinates, yCoordinates, 3);
            }
        }
    }
}
