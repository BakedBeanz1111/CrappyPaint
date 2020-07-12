package model;

// I made the decision to use the singleton design pattern after reading this article: https://www.javatpoint.com/singleton-design-pattern-in-java
//Being able to map a ShapeColor to color would make my life easier to drawing colors

//Information I found about EnumMaps: https://www.geeksforgeeks.org/enummap-class-java-example/

import java.awt.*;
import java.util.EnumMap;

public class ColorSingleton {

    public ShapeColor shapeColor;
    public EnumMap<ShapeColor, Color> colorEnumMap;

    public ColorSingleton(ShapeColor shapeColor) {
        this.shapeColor = shapeColor;

        EnumMap<ShapeColor, Color> colorEnumMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);

        colorEnumMap.put(ShapeColor.BLACK, Color.BLACK);
        colorEnumMap.put(ShapeColor.BLUE, Color.BLUE);
        colorEnumMap.put(ShapeColor.CYAN, Color.CYAN);
        colorEnumMap.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        colorEnumMap.put(ShapeColor.GRAY, Color.GRAY);
        colorEnumMap.put(ShapeColor.GREEN, Color.GREEN);
        colorEnumMap.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        colorEnumMap.put(ShapeColor.MAGENTA, Color.MAGENTA);
        colorEnumMap.put(ShapeColor.ORANGE, Color.ORANGE);
        colorEnumMap.put(ShapeColor.PINK, Color.PINK);
        colorEnumMap.put(ShapeColor.RED, Color.RED);
        colorEnumMap.put(ShapeColor.WHITE, Color.WHITE);
        colorEnumMap.put(ShapeColor.YELLOW, Color.YELLOW);
    }
}
