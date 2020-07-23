package model;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class RectangleFilledInStrategy {

    public RectangleFilledInStrategy(Shape shape, ShapeColor fillColor, ShapeFactory shapeFactory, Graphics2D graphics2D) {

        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        ColorSingleton fillColorSingleton = ColorSingleton.getInstance(fillColor, colorEnumMap);
        Color fillColorMapped = colorEnumMap.get(fillColor);

        graphics2D.setColor(fillColorMapped);
        graphics2D.fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
    }
}
