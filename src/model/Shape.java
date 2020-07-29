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
    public ShapeColor shapeColor;
    public ShapeColor lineColor;
    public ShapeShadingType shapeShadingType;

    public Shape(Point startPoint, Point endPoint, ShapeType shapeType, ShapeColor shapeColor, ShapeColor lineColor, ShapeShadingType shapeShadingType) {

        this.shapeType = shapeType;
        this.shapeShadingType = shapeShadingType;

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
    }

    //getters
    public IApplicationState getApplicationState(){

        return applicationState;
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

    public boolean containsPoints(int x, int y) {

        if (x >= startPoint.x && x < startPoint.x + width && y >= startPoint.y && y < startPoint.y + height) {

            return true;
        }
        else {

            return false;
        }
    }

    public void selectShape() {

        this.shapeShadingType = shapeShadingType.OUTLINE;
        this.lineColor = shapeColor.RED;
    }
}