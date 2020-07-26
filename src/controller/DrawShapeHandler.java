package src.controller;

import model.*;
import model.Shape;
import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShapeStrategy;
import view.gui.PaintCanvas;
import java.awt.*;
import java.util.List;

public class DrawShapeHandler implements IDrawShapeHandler {

    public PaintCanvas paintCanvas;
    public IShapeStrategy iShapeStrategy;

    public DrawShapeHandler(PaintCanvas paintCanvas, IShapeStrategy iShapeStrategy) {

        this.paintCanvas = paintCanvas;
        this.iShapeStrategy = iShapeStrategy;
    }

    public void update(List<Shape> globalShapeList) {

        Graphics2D graphics2D = paintCanvas.getGraphics2D();

        for(Shape shape : globalShapeList) {

            if(shape.shapeType.toString().equals("ELLIPSE") && (shape.shapeShadingType.toString().equals("FILLED_IN"))) {

                iShapeStrategy = new EllipseFilledInStrategy(shape.shapeColor, shape.lineColor, graphics2D, shape);

            }
        }

        iShapeStrategy.draw();
    }
}
