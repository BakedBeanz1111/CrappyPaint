package model;

import model.interfaces.IApplicationState;

import java.awt.*;

public class Shape {

    public IApplicationState applicationState;
    public Point startPoint;
    public Point endPoint;
    public int height;
    public int width;
    public int xMin, xMax, yMin, yMax, triangleMidPoint;
    public ShapeType shapeType;
    public ShapeList shapeList;
    public ShapeColor shapeColor;
    public ShapeColor lineColor;
    public ShapeFactory shapeFactory;

    public Shape(Point startPoint, Point endPoint, ShapeType shapeType, ShapeColor shapeColor, ShapeColor lineColor, ShapeFactory shapeFactory) {

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

        this.shapeColor = shapeColor;
        this.lineColor = lineColor;

        this.shapeFactory = shapeFactory;
    }

    //getters
    public IApplicationState getApplicationState(){

        return applicationState;
    }

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

    public ShapeList getShapeList() {

        return shapeList;
    }

    public ShapeColor getShapeColor() {

        return shapeColor;
    }

    public ShapeColor getLineColor() {

        return lineColor;
    }

    public ShapeFactory getShapeFactory() {

        return shapeFactory;
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

    public void setShapeColor(ShapeColor shapeColor) {

        this.shapeColor = shapeColor;
    }

    public void setLineColor(ShapeColor lineColor) {

        this.lineColor = lineColor;
    }

    public boolean containsPoints(int x, int y) {

        if (x >= startPoint.x && x < startPoint.x + width && y >= startPoint.y && y < startPoint.y + height) {
            return true;
        }
        else {
            return false;
        }
    }
}