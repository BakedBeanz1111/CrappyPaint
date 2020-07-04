package src.model;

import java.awt.*;

import model.ShapeColor;
import model.ShapeType;
import src.model.*;

//Object Class for Shape definition
//For Sprint #1, all we care about are shapes having
// *Start Point
// *End Point
// *Line Color
// *Fill Color
// *Shape Type - In This case - Rectangle
public class Shape {

    //At its core, what makes a shape a shape on a 2D rendering plane?
    private Point startPoint;
    private Point endPoint;
    private model.ShapeColor shapeColor;
    private model.ShapeColor fillColor;
    private model.ShapeType shapeType;


    //getters
    public Point getStartPoint() {
        return startPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public model.ShapeColor getShapeColor() {
        return shapeColor;
    }
    public model.ShapeColor getFillColor() {
        return fillColor;
    }
    public model.ShapeType getShapeType() {
        return shapeType;
    }

    //setters
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
    public void setShapeColor(model.ShapeColor shapeColor) {
        this.shapeColor = shapeColor;
    }
    public void setFillColor(ShapeColor fillColor) {
        this.fillColor = fillColor;
    }
    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
}
