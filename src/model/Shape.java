package model;

import java.awt.*;

public class Shape {
    public Point startPoint;
    public Point endPoint;
    public int height;
    public int width;
    public ShapeType shapeType;

    //Experimental for getting shapes to draw properly
    public int xMin, xMax, yMin, yMax, triangleMidPoint;

    public Shape(Point startPoint, Point endPoint, ShapeType shapeType) {
        this.shapeType = shapeType;

        this.startPoint = startPoint;
        this.endPoint = endPoint;

        xMin = Math.min(startPoint.x, endPoint.x);
        xMax = Math.max(startPoint.x, endPoint.x);

        yMin = Math.min(startPoint.y, endPoint.y);
        yMax = Math.max(startPoint.y, endPoint.y);

        height = yMax - yMin;
        width = xMax - xMin;
        triangleMidPoint = xMin + (width/2);
    }

    //getters
    public Point getStartPoint() {
        return startPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getxMin() {
        return xMin;
    }
    public int getyMin() {
        return yMin;
    }
    public int getxMax() {
        return xMax;
    }
    public int getyMax() {
        return yMax;
    }
    public int getTriangleMidPoint() {
        return triangleMidPoint;
    }
    public ShapeType getShapeType() {
        return shapeType;
    }

    //setters
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
}