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
    public IApplicationState applicationState;
    public ShapeType shapeType;
    public ShapeColor shapeColor;
    public ShapeColor lineColor;
    public Color shapeColorMapped;
    public Color lineColorMapped;
    public ColorSingleton shapeColorSingleton;
    public ColorSingleton lineColorSingleton;

    public DrawShapeHandler(PaintCanvas paintCanvas, IApplicationState applicationState) {
        this.paintCanvas = paintCanvas;
        this.applicationState = applicationState;
    }

    public void update(ArrayList<Shape> shapeArrayList) {

        EnumMap<ShapeColor, Color> enumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        enumMap.put(ShapeColor.BLUE, Color.BLUE);
        enumMap.put(ShapeColor.GREEN, Color.GREEN);

        Graphics2D graphics2D = paintCanvas.getGraphics2D();

        for (Shape shape : shapeArrayList ){

            if(shape.getShapeType().toString().equals("RECTANGLE")) {
                //The following line prints normally everything after is experimental for printing with color
                //paintCanvas.getGraphics2D().drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

                //application state is null
                //System.out.println(enumMap.toString());

                shapeColorSingleton = new ColorSingleton(applicationState.getActivePrimaryColor(), enumMap);
                lineColorSingleton = new ColorSingleton(applicationState.getActiveSecondaryColor(), enumMap);

                System.out.println("" + applicationState.getActivePrimaryColor());
                System.out.println("" + applicationState.getActiveSecondaryColor());

                shapeColorMapped = enumMap.get(applicationState.getActivePrimaryColor());
                lineColorMapped = enumMap.get(applicationState.getActiveSecondaryColor());

                System.out.println("" + shape.getShapeColor());
                System.out.println("" + shape.getLineColor());

                //paintCanvas.getGraphics2D().setColor(shape.getShapeColor());
                //paintCanvas.getGraphics2D().drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
                graphics2D.setColor(shapeColorMapped);
                graphics2D.fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

                //paintCanvas.getGraphics2D().setColor(shape.getLineColor());
                //paintCanvas.getGraphics2D().fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
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
