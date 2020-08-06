package model;

import model.interfaces.IShapeStrategy;
import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class TriangleFilledInStrategy implements IShapeStrategy {

    private Shape shape;
    private ShapeColor shapeColor;
    private Graphics2D graphics2D;

    public TriangleFilledInStrategy(Shape shape, ShapeColor shapeColor, Graphics2D graphics2D) {

        this.shape = shape;
        this.shapeColor = shapeColor;
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

        int[] xCoordinates = {shape.getxMin(), shape.getTriangleMidPoint(), shape.getxMax() };
        int[] yCoordinates = {shape.getyMin(), shape.getyMax(), shape.getyMin()};

        Color colorMapped = color(shapeColor);
        graphics2D.setColor(colorMapped);

        graphics2D.fillPolygon(xCoordinates, yCoordinates, 3);
    }
}
