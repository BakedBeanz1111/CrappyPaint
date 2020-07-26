package model;

import model.interfaces.IShapeStrategy;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class RectangleFilledInStrategy implements IShapeStrategy {

    private Shape shape;
    private ShapeColor shapeColor;
    private Graphics2D graphics2D;

    public RectangleFilledInStrategy(Shape shape, ShapeColor shapeColor, Graphics2D graphics2D) {

        this.shape = shape;
        this.shapeColor = shapeColor;
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

        Color shapeColorMapped = color(shapeColor);
        graphics2D.setColor(shapeColorMapped);
        graphics2D.fillRect(shape.getxMin(), shape.getyMin(), shape.getWidth(), shape.getHeight());
    }
}
