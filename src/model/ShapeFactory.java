package model;

//https://www.tutorialspoint.com/design_pattern/factory_pattern.htm

import model.interfaces.IApplicationState;

public class ShapeFactory {

    public IApplicationState applicationState;
    public Shape shape;
    public ShapeList shapeList;

    public ShapeFactory(IApplicationState applicationState, Shape shape, ShapeList shapeList) {

        this.applicationState = applicationState;
        this.shape = shape;
        this.shapeList = shapeList;
    }

    public void createRectangle() {

        if(applicationState.getActiveShapeType().toString().equals("RECTANGLE")) {

            System.out.println(("RECTANGLE!!!"));
        }
    }

    public void createEllipse() {

        if(applicationState.getActiveShapeType().toString().equals("ELLIPSE")) {

            System.out.println(("ELLIPSE!!!"));
        }
    }

    public  void createTriangle() {

        if(applicationState.getActiveShapeType().toString().equals("TRIANGLE")) {

            System.out.println("TRIANGLE!!!");
        }
    }

}
