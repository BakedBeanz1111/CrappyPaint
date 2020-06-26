package src.model;

import java.awt.*;

public class Shape {

    //At its core, what makes a shape a shape on a 2D rendering plane?
    private Point startPoint;
    private Point endPoint;

    //get methods
    public Point getStartPoint() {
        return startPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }

    //set methods
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
