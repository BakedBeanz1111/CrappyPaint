package model;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class TriangleFilledInStrategy {

    public TriangleFilledInStrategy(Shape shape, ShapeColor fillColor, ShapeFactory shapeFactory, Graphics2D graphics2D) {

        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        Color fillColorMapped = colorEnumMap.get(fillColor);

        int[] xCoordinates = {shape.getxMin(), shape.getTriangleMidPoint(), shape.getxMax() };
        int[] yCoordinates = {shape.getyMin(), shape.getyMax(), shape.getyMin()};

        graphics2D.setColor(fillColorMapped);
        graphics2D.fillPolygon(xCoordinates, yCoordinates, 3);
    }
}
