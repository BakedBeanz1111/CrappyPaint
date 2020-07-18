package src.controller;

import model.ColorSingleton;
import model.Shape;
import model.ShapeColor;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
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

    public void update(ArrayList<Shape> shapeArrayList) {

        Graphics2D graphics2D = paintCanvas.getGraphics2D();

        for (Shape shape : shapeArrayList ) {

            if(shape.getShapeType().toString().equals("RECTANGLE")) {

                EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);

                shapeColor = ColorSingleton.getInstance(shape.shapeColor, colorEnumMap);
                lineColor = ColorSingleton.getInstance(shape.lineColor, colorEnumMap);

                shapeColorMapped = colorEnumMap.get(shape.shapeColor);
                lineColorMapped = colorEnumMap.get(shape.lineColor);

                graphics2D.setColor(shapeColorMapped);
                graphics2D.fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

                graphics2D.setColor(lineColorMapped);
                graphics2D.drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

            }
            else if(shape.getShapeType().toString().equals("ELLIPSE")) {

                paintCanvas.getGraphics2D().draw(new Ellipse2D.Double(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight()));
            }
            else if(shape.getShapeType().toString().equals("TRIANGLE")) {

                int[] xCoordinates = {shape.getxMin(), shape.getTriangleMidPoint(), shape.getxMax() };
                int[] yCoordinates = {shape.getyMin(), shape.getyMax(), shape.getyMin()};

                paintCanvas.getGraphics2D().drawPolygon(xCoordinates, yCoordinates, 3);
            }
            else {

                System.out.println("How did you get here? There are only 3 shapes!");
            }
        }
    }
}
