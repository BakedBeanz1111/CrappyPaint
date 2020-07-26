package model;

import java.awt.*;
import java.util.EnumMap;

//https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
public class EllipseFilledInStrategy {

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

    
}
