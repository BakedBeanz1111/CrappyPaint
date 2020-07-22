package src.controller;

import model.ColorSingleton;
import model.Shape;
import model.ShapeColor;
import view.gui.PaintCanvas;
import model.ShapeFactory;

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
        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);

        for (Shape shape : shapeList ) {

            shapeColor = ColorSingleton.getInstance(shape.shapeColor, colorEnumMap);
            lineColor = ColorSingleton.getInstance(shape.lineColor, colorEnumMap);

            shapeColorMapped = colorEnumMap.get(shape.shapeColor);
            lineColorMapped = colorEnumMap.get(shape.lineColor);

            if(shape.getShapeType().toString().equals("RECTANGLE")) {

                System.out.println("YOU ARE PRINTING A RECTANGLE");

                graphics2D.setColor(shapeColorMapped);
                graphics2D.fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

                graphics2D.setColor(lineColorMapped);
                graphics2D.drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

            }
            else if(shape.getShapeType().toString().equals("ELLIPSE")) {

                System.out.println("YOU ARE PRINTING A ELLIPSE");

                graphics2D.setColor(shapeColorMapped);
                graphics2D.fill(new Ellipse2D.Double(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight()));

                graphics2D.setColor(lineColorMapped);
                graphics2D.draw(new Ellipse2D.Double(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight()));
            }
            else if(shape.getShapeType().toString().equals("TRIANGLE")) {

                System.out.println("YOU ARE PRINTING A TRIANGLE");

                int[] xCoordinates = {shape.getxMin(), shape.getTriangleMidPoint(), shape.getxMax() };
                int[] yCoordinates = {shape.getyMin(), shape.getyMax(), shape.getyMin()};

                graphics2D.setColor(shapeColorMapped);
                graphics2D.fillPolygon(xCoordinates, yCoordinates, 3);

                graphics2D.setColor(lineColorMapped);
                graphics2D.drawPolygon(xCoordinates, yCoordinates, 3);
            }
            else {

                System.out.println("How did you get here? There are only 3 shapes!");
            }
        }
    }
}
