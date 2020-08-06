package model;

import model.interfaces.IShapeStrategy;
import java.awt.*;
import java.util.EnumMap;

public class TriangleOutlineStrategy implements IShapeStrategy {

    private Shape shape;
    private ShapeColor lineColor;
    private Graphics2D graphics2D;

    public TriangleOutlineStrategy(Shape shape, ShapeColor lineColor, Graphics2D graphics2D) {

        this.shape = shape;
        this.lineColor = lineColor;
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

        Color colorMapped = color(lineColor);
        graphics2D.setColor(colorMapped);

        graphics2D.drawPolygon(xCoordinates, yCoordinates, 3);
    }
}
