package src.controller;

import model.ShapeColor;
import model.ShapeList;
import src.model.Rectangle;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import model.ShapeType;
import model.interfaces.IApplicationState;

//An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".
// (Taken from https://www.javatpoint.com/adapter-pattern)
public class MouseAdapter extends JPanel implements MouseListener {

    private IApplicationState applicationState;
    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;
    private ShapeList shapeList;
    private ShapeColor shapeColor;

    public MouseAdapter(IApplicationState applicationState, ShapeList shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
    }

    //Debug Function
    //Output string to console for whenever the mouse does something
    private void actionLog(String action, MouseEvent e) {
        System.out.println(action);
    }

    //What is the difference between Mouse Clicked vs Mouse Pressed + Mouse Released?
    @Override
    public void mousePressed(MouseEvent e) {
        actionLog("Mouse Pressed", e);
        startPoint = new Point(e.getX(), e.getY());
        System.out.println(startPoint.toString());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shapeType = applicationState.getActiveShapeType();
        shapeColor = applicationState.getActiveSecondaryColor();
        System.out.println(shapeColor.toString());
        actionLog("Mouse Clicked", e);

        endPoint = new Point(e.getX(), e.getY());
        System.out.println(endPoint.toString());

        if(shapeType.toString().equals("RECTANGLE")) {
            Rectangle rectangle = new Rectangle(startPoint, endPoint, shapeList, shapeType, shapeColor);
            rectangle.setFillColor(shapeColor);
            rectangle.run();
        }
        else {
            System.out.println("nothing to see here for sprint 1!");
        }
    }

    //Remove this function because it seems to do the exact same thing as mouseReleased
    @Override
    public void mouseClicked(MouseEvent e) {
        actionLog("Mouse button Clicked", e);
    }

    //Remove this function because it currently doesn't do anything towards what we need from sprint #1
    @Override
    public void mouseEntered(MouseEvent e) {
        actionLog("Mouse entered drawing area", e);
    }

    //Remove this function because it currently doesn't do anything towards what we need from sprint #1
    @Override
    public void mouseExited(MouseEvent e) {
        actionLog("Mouse exited drawing area", e);
    }
}