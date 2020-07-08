package model;

import java.awt.*;

public class Shape {
    public Point startPoint;
    public Point endPoint;
    public int height;
    public int width;
    public ShapeColor fillColor;

    //Experimental for getting shapes to draw properly
    public int xMin, xMax, yMin, yMax;

    public Shape(Point startPoint, Point endPoint, ShapeColor fillColor) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        //Calculations are made as follows
        //When given 2 points (x1,y1) and (x2,y2)
        //the distance between points is (x2-x1,y2-y1)
        //Absolute value is used since a length can't be negative
        //height is the delta of the y points for the Y-dimension
        //width is the delta of the x points for the  X-dimension
        //Top left most corner of the canvas is (0,0)
        //Going right increases x
        //Going down increases y

        //The current observed behavior with incorrect drawing are as follows:
        //Down and to the Right -- Works
        //Up and to the Right flips along the Y-axis
        //Down and to the left flips along the X&Y-axis
        //Up and to the left flips along the X&Y-axis

        //height = Math.abs(endPoint.y - startPoint.y);
        //width = Math.abs(endPoint.x - startPoint.x);

        //Noticed an issue when drawing rectangles
        //Shapes only appear on correct start point and end point when shapes are drawn down and to the left
        //Shapes draw incorrectly with start and end points when going in any other direction

        //The following things have been tried to resolve this arithmetic issue with height/width calculations
        /*
        if (endPoint.y > startPoint.y)
            height = Math.abs(endPoint.y - startPoint.y);
        else
            height = Math.abs(startPoint.y - endPoint.y);

        if (endPoint.x > startPoint.x)
            width = Math.abs(endPoint.x - startPoint.x);
        else
            width = Math.abs(startPoint.x - endPoint.x);

        ---- different attempt ----
*/
        //The Observed behavior of this implementation are as follows:
        //Down and to the Right -- Works
        //Up and to the Right flips along the Y-axis
        //Down and to the left flips along the X&Y-axis
        //Up and to the left flips along the X&Y-axis

        //Since the observed behavior is the same based on both implementations
        //I'm lead to believe the issue isn't here
        //I was right, I had to fix draw handler to use the xMin/yMin origin points

        xMin = Math.min(startPoint.x, endPoint.x);
        xMax = Math.max(startPoint.x, endPoint.x);
        width = xMax - xMin;

        yMin = Math.min(startPoint.y, endPoint.y);
        yMax = Math.max(startPoint.y, endPoint.y);
        height = yMax - yMin;

        this.fillColor = fillColor;
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
    public void setFillColor(ShapeColor shapeColor) {
        this.fillColor = shapeColor;
    }
}