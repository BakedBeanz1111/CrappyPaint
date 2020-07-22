package src.controller;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.interfaces.IApplicationState;

//An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".
// (Taken from https://www.javatpoint.com/adapter-pattern)
public class MouseAdapter extends JPanel implements MouseListener {

    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;
    public ShapeFactory shapeFactory;

    public MouseAdapter(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    private void actionLog(String action, MouseEvent e) {
        System.out.println(action);
    }

    //What is the difference between Mouse Clicked vs Mouse Pressed + Mouse Released?
    @Override
    public void mousePressed(MouseEvent e) {
        actionLog("Mouse Pressed", e);
        startPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point(e.getX(), e.getY());
        shapeType = shapeFactory.applicationState.getActiveShapeType();

        if(shapeFactory.applicationState.getActiveStartAndEndPointMode()==StartAndEndPointMode.DRAW) {

            DrawShapeCommand drawShapeCommand = new DrawShapeCommand(startPoint, endPoint, shapeType, shapeFactory);
            drawShapeCommand.run();
        }
        else if(shapeFactory.applicationState.getActiveStartAndEndPointMode()==StartAndEndPointMode.SELECT) {

            SelectShapeCommand selectShapeCommand = new SelectShapeCommand(startPoint, endPoint, shapeFactory);
            selectShapeCommand.run();
        }
        else if(shapeFactory.applicationState.getActiveStartAndEndPointMode()==StartAndEndPointMode.MOVE) {

            MoveShapeCommand moveShapeCommand = new MoveShapeCommand(startPoint, endPoint, shapeType, shapeFactory);
            moveShapeCommand.run();
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