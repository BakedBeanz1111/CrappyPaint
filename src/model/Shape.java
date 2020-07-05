package model;

import java.awt.*;

public class Shape {
    public Point startPoint;
    public Point endPoint;
    public int height;
    public int width;

    public Shape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        //Calculations are made as follows
        //When given 2 points (x1,y1) and (x2,y2)
        //the distance between points is (x2-x1,y2-y1)
        //Absolute value is used since a length can't be negative
        //height is the delta of the y points for the Y-dimension
        //width is the delta of the x points for the  X-dimension

        height = Math.abs(endPoint.y - startPoint.y);
        width = Math.abs(endPoint.x - startPoint.x);

        //Noticed an issue when drawing rectangles
        //Shapes only appear on correct start point and end point when shapes are drawn down and to the left
        //Shapes draw incorrectly with start and end points when going in any other direction
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
