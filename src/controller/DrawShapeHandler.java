package src.controller;

import model.*;
import model.Shape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.List;
import java.awt.geom.Ellipse2D;
import java.util.EnumMap;

public class DrawShapeHandler {

    public PaintCanvas paintCanvas;

    public DrawShapeHandler(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void update(List<Shape> globalShapeList) {

        Graphics2D graphics2D = paintCanvas.getGraphics2D();

        for(Shape shape : globalShapeList) {

            if(shape.shapeType.toString().equals("ELLIPSE") && (shape.shapeShadingType.toString().equals("FILLED_IN"))) {

                EllipseFilledInStrategy ellipseFilledInStrategy = new EllipseFilledInStrategy(shape, shape.shapeColor, shape.shap)
            }
        }
    }
}
