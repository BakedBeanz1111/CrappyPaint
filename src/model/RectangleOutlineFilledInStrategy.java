package model;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class RectangleOutlineFilledInStrategy {

    public RectangleOutlineFilledInStrategy(Shape shape, ShapeColor fillColor, ShapeColor lineColor, ShapeFactory shapeFactory, Graphics2D graphics2D) {

        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        ColorSingleton fillColorSingleton = ColorSingleton.getInstance(fillColor, colorEnumMap);
        ColorSingleton lineColorSingleton = ColorSingleton.getInstance(lineColor, colorEnumMap);

        Color fillColorMapped = colorEnumMap.get(fillColor);
        Color lineColorMapped = colorEnumMap.get(lineColor);

        graphics2D.setColor(fillColorMapped);
        graphics2D.fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

        graphics2D.setColor(lineColorMapped);
        graphics2D.drawRect(shape.getxMax(), shape.getyMin(), shape.getWidth(), shape.getHeight());
    }
}
