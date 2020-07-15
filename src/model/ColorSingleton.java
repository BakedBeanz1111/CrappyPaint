package model;

// I made the decision to use the singleton design pattern after reading this article: https://www.javatpoint.com/singleton-design-pattern-in-java
//Being able to map a ShapeColor to color would make my life easier to drawing colors

//Information I found about EnumMaps: https://www.geeksforgeeks.org/enummap-class-java-example/

import java.awt.*;
import java.util.EnumMap;

public class ColorSingleton {

    public ShapeColor shapeColor;
    public EnumMap<ShapeColor, Color> colorEnumMap;
    public static ColorSingleton colorSingleton;

    //default constructor
    public ColorSingleton(ShapeColor shapeColor, EnumMap<ShapeColor, Color> colorEnumMap) {
        this.shapeColor = shapeColor;
        this.colorEnumMap = colorEnumMap;

        this.colorEnumMap.put(ShapeColor.BLACK, Color.BLACK);
        this.colorEnumMap.put(ShapeColor.BLUE, Color.BLUE);
        this.colorEnumMap.put(ShapeColor.CYAN, Color.CYAN);
        this.colorEnumMap.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        this.colorEnumMap.put(ShapeColor.GRAY, Color.GRAY);
        this.colorEnumMap.put(ShapeColor.GREEN, Color.GREEN);
        this.colorEnumMap.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        this.colorEnumMap.put(ShapeColor.MAGENTA, Color.MAGENTA);
        this.colorEnumMap.put(ShapeColor.ORANGE, Color.ORANGE);
        this.colorEnumMap.put(ShapeColor.PINK, Color.PINK);
        this.colorEnumMap.put(ShapeColor.RED, Color.RED);
        this.colorEnumMap.put(ShapeColor.WHITE, Color.WHITE);
        this.colorEnumMap.put(ShapeColor.YELLOW, Color.YELLOW);
    }

    public static ColorSingleton getInstance(ShapeColor shapeColor, EnumMap<ShapeColor, Color> colorEnumMap) {
        colorSingleton = new ColorSingleton(shapeColor, colorEnumMap);

        return colorSingleton;
    }

}
