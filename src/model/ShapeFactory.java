package model;

//https://www.tutorialspoint.com/design_pattern/factory_pattern.htm

import model.interfaces.IApplicationState;

import java.util.List;

public class ShapeFactory {

    public IApplicationState applicationState;
    public Shape shape;
    public ShapeList shapeList;
    public List<Shape> selectedShapesList;
    public List<Shape> copiedShapesList;

    public ShapeFactory(IApplicationState applicationState, ShapeList shapeList, List<Shape> selectedShapesList) {

        this.applicationState = applicationState;
        this.shape = shape;
        this.shapeList = shapeList;
        this.selectedShapesList = selectedShapesList;
        this.copiedShapesList = copiedShapesList;
    }

    public void createRectangle() {

        if(applicationState.getActiveShapeType().toString().equals("RECTANGLE")) {
            shapeList.globalShapeList.add(shape);
        }
    }

    public void createEllipse() {

        if(applicationState.getActiveShapeType().toString().equals("ELLIPSE")) {
            shapeList.globalShapeList.add(shape);
        }
    }

    public  void createTriangle() {

        if(applicationState.getActiveShapeType().toString().equals("TRIANGLE")) {
            shapeList.globalShapeList.add(shape);
        }
    }
}