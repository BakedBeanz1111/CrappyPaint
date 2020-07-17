package src.controller;

import model.DrawShapeCommand;
import model.ShapeColor;
import model.ShapeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    private DrawShapeCommand drawShapeCommand;
    private ShapeColor lineColor;
    private ShapeColor fillColor;
    private Color line;
    private Color fill;

    public MouseAdapter(IApplicationState applicationState, ShapeList shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
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
        actionLog("Mouse Released", e);
        endPoint = new Point(e.getX(),e.getY());

        shapeType = applicationState.getActiveShapeType();
        System.out.println("Shape Type is: " + shapeType.toString());

        lineColor = applicationState.getActivePrimaryColor();
        line = ShapeColor.getMap().get(lineColor);
        fillColor = applicationState.getActiveSecondaryColor();
        fill = ShapeColor.getMap().get(fillColor);

        System.out.println("line color is: " + lineColor.toString());
        System.out.println("fill color is: " + fillColor.toString());

        drawShapeCommand = new DrawShapeCommand(startPoint, endPoint, shapeType, shapeList, line, fill);
        drawShapeCommand.run();
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