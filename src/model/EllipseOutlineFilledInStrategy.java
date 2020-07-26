package model;

import model.interfaces.IShapeStrategy;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class EllipseOutlineFilledInStrategy implements IShapeStrategy {

    public ShapeColor shapeColor;
    public ShapeColor lineColor;
    public Shape shape;
    public Graphics2D graphics2D;

    public EllipseOutlineFilledInStrategy(Shape shape, ShapeColor shapeColor, ShapeColor lineColor, Graphics2D graphics2D) {

        this.shapeColor = shapeColor;
        this.lineColor = lineColor;
        this.shape = shape;
        this.graphics2D = graphics2D;
    }

    @Override
    public Color color(ShapeColor color) {

        EnumMap<ShapeColor, Color> enumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        ColorSingleton colorSingleton = ColorSingleton.getInstance(color, enumMap);
        Color mappedColor = enumMap.get(color);
        return mappedColor;
    }

    @Override
    public void draw() {

        Color shapeColorMapped = color(shapeColor);
        graphics2D.setColor(shapeColorMapped);
        graphics2D.fillOval(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());

        Color lineColorMapped = color(lineColor);
        graphics2D.setColor(lineColorMapped);
        graphics2D.drawOval(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
    }
}
