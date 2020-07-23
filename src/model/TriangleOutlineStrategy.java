package model;

import java.awt.*;
import java.util.EnumMap;

public class TriangleOutlineStrategy {

    public TriangleOutlineStrategy(Shape shape, ShapeColor lineColor, ShapeFactory shapeFactory, Graphics2D graphics2D) {

        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        ColorSingleton lineColorSingleton = ColorSingleton.getInstance(lineColor, colorEnumMap);
        Color lineColorMapped = colorEnumMap.get(lineColor);

        int[] xCoordinates = {shape.getxMin(), shape.getTriangleMidPoint(), shape.getxMax() };
        int[] yCoordinates = {shape.getyMin(), shape.getyMax(), shape.getyMin()};

        graphics2D.setColor(lineColorMapped);
        graphics2D.drawPolygon(xCoordinates, yCoordinates, 3);
    }
}
