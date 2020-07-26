package model;

import model.interfaces.IShapeStrategy;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class RectangleOutlineStrategy implements IShapeStrategy {

    private Shape shape;
    private ShapeColor lineColor;
    private Graphics2D graphics2D;

    public RectangleOutlineStrategy(Shape shape, ShapeColor lineColor, Graphics2D graphics2D) {

        this.shape = shape;
        this.lineColor = lineColor;
        this.graphics2D = graphics2D;
    }

    @Override
    public Color color(ShapeColor shapeColor) {

        EnumMap<ShapeColor, Color> enumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        ColorSingleton colorSingleton = ColorSingleton.getInstance(shapeColor, enumMap);
        Color mappedColor = enumMap.get(shapeColor);

        return mappedColor;
    }

    @Override
    public void draw() {

        Color lineColorMapped = color(lineColor);
        graphics2D.setColor(lineColorMapped);
        graphics2D.drawRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
    }
}
