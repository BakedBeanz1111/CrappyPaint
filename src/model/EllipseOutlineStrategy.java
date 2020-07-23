package model;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class EllipseOutlineStrategy {

    public EllipseOutlineStrategy(Shape shape, ShapeColor lineColor, ShapeFactory shapeFactory, Graphics2D graphics2D) {

        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        ColorSingleton lineColorSingleton = ColorSingleton.getInstance(lineColor, colorEnumMap);
        Color lineColorMapped = colorEnumMap.get(lineColor);

        graphics2D.setColor(lineColorMapped);
        graphics2D.drawOval(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
    }
}
