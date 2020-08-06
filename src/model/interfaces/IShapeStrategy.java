package model.interfaces;

import model.ShapeColor;
import java.awt.*;

//https://dzone.com/articles/null-object-pattern-in-java
public interface IShapeStrategy {

    Color color(ShapeColor shapeColor);
    void draw();
}
