package model.interfaces;

import model.ShapeColor;
import java.awt.*;

public interface IShapeStrategy {

    Color color(ShapeColor shapeColor);
    void draw();
}
