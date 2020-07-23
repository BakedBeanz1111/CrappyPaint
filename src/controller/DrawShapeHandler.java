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
    ColorSingleton shapeColor;
    ColorSingleton lineColor;
    public Color shapeColorMapped;
    public Color lineColorMapped;

    public DrawShapeHandler(PaintCanvas paintCanvas) {

        this.paintCanvas = paintCanvas;
    }

    public void update(List<Shape> shapeList) {

        Graphics2D graphics2D = paintCanvas.getGraphics2D();

        for (Shape shape : shapeList ) {

            if(shape.getShapeType().toString().equals("RECTANGLE")) {

                if(shape.shapeShadingType.toString().equals("FILLED_IN")) {

                    new RectangleFilledInStrategy(shape, shape.shapeColor, shape.shapeFactory, graphics2D);
                }
                else if(shape.shapeShadingType.toString().equals("OUTLINE")) {

                    new RectangleOutlineStrategy(shape, shape.lineColor, shape.shapeFactory, graphics2D);
                }
                else if(shape.shapeShadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {

                    new RectangleOutlineFilledInStrategy(shape, shape.shapeColor, shape.lineColor, shape.shapeFactory, graphics2D);
                }
                else {
                    System.out.println("Something wrong happened");
                }

            }
            else if(shape.getShapeType().toString().equals("ELLIPSE")) {

                if(shape.shapeShadingType.toString().equals("FILLED_IN")) {

                    new EllipseFilledInStrategy(shape, shape.shapeColor, shape.shapeFactory, graphics2D);
                }
                else if(shape.shapeShadingType.toString().equals("OUTLINE")) {

                    new EllipseOutlineStrategy(shape, shape.lineColor, shape.shapeFactory, graphics2D);
                }
                else if(shape.shapeShadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {

                    new EllipseOutlineFilledInStrategy(shape, shape.shapeColor, shape.lineColor, shape.shapeFactory, graphics2D);
                }
                else {
                    System.out.println("Something wrong happened");
                }

            }
            else if(shape.getShapeType().toString().equals("TRIANGLE")) {

                if(shape.shapeShadingType.toString().equals("FILLED_IN")) {

                    new TriangleFilledInStrategy(shape, shape.shapeColor, shape.shapeFactory, graphics2D);
                }
                else if(shape.shapeShadingType.toString().equals("OUTLINE")) {

                    new TriangleOutlineStrategy(shape, shape.lineColor, shape.shapeFactory, graphics2D);
                }
                else if(shape.shapeShadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {

                    new TriangleOutlineFilledInStrategy(shape, shape.shapeColor, shape.lineColor, shape.shapeFactory, graphics2D);
                }
                else {
                    System.out.println("Something wrong happened");
                }

            }
            else {

                System.out.println("How did you get here? There are only 3 shapes!");
            }
        }
    }
}
