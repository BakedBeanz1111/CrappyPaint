package model;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class TriangleOutlineFilledInStrategy {

    public TriangleOutlineFilledInStrategy(Shape shape, ShapeColor fillColor, ShapeColor lineColor, ShapeFactory shapeFactory, Graphics2D graphics2D) {

        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        Color fillColorMapped = colorEnumMap.get(fillColor);
        Color lineColorMapped = colorEnumMap.get(lineColor);

        int[] xCoordinates = {shape.getxMin(), shape.getTriangleMidPoint(), shape.getxMax() };
        int[] yCoordinates = {shape.getyMin(), shape.getyMax(), shape.getyMin()};

        graphics2D.setColor(fillColorMapped);
        graphics2D.fillPolygon(xCoordinates, yCoordinates, 3);

        graphics2D.setColor(lineColorMapped);
        graphics2D.drawPolygon(xCoordinates, yCoordinates, 3);
    }
}
