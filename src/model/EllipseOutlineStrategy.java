package model;

import model.interfaces.IShapeStrategy;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class EllipseOutlineStrategy implements IShapeStrategy {

    private ShapeColor lineColor;
    private Graphics2D graphics2D;
    private Shape shape;

    public EllipseOutlineStrategy(Shape shape, ShapeColor lineColor, Graphics2D graphics2D) {

        this.shape = shape;
        this.lineColor = lineColor;
        this.graphics2D = graphics2D;
    }

    @Override
    public Color color(ShapeColor color) {

        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        ColorSingleton colorSingleton = ColorSingleton.getInstance(color, colorEnumMap);
        Color colorMapped = colorEnumMap.get(color);

        return colorMapped;
    }

    @Override
    public void draw() {

        Color colorMapped = color(lineColor);
        graphics2D.setColor(colorMapped);
        graphics2D.drawOval(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
    }
}
