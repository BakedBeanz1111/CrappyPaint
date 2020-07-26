package model;

import model.interfaces.IShapeStrategy;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class EllipseFilledInStrategy implements IShapeStrategy {

    private ShapeColor shapeColor;
    private ShapeColor lineColor;
    private Graphics2D graphics2D;
    private Shape shape;

    public EllipseFilledInStrategy(ShapeColor shapeColor, ShapeColor lineColor, Graphics2D graphics2D, Shape shape) {

        this.shapeColor = shapeColor;
        this.lineColor = lineColor;
        this.graphics2D = graphics2D;
        this.shape = shape;
    }


    @Override
    public Color color(ShapeColor shapeColor) {

        EnumMap<ShapeColor, Color> enumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);
        ColorSingleton colorSingleton = new ColorSingleton.getInstance(shapeColor, enumMap);
        Color mappedColor = colorMap.get(shapeColor);

        return mappedColor;
    }

    @Override
    public void draw() {

        Color shapeColorMapped = color(shapeColor);
        graphics2D.setColor(shapeColorMapped);
        graphics2D.fillOval(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
    }
}
