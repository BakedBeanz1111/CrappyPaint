package model;

//https://www.tutorialspoint.com/design_pattern/factory_pattern.htm

import model.interfaces.IApplicationState;
import java.util.List;

public class ShapeFactory {

    public IApplicationState applicationState;
    public ShapeList shapeList;
    public List<Shape> selectedShapesList;

    public ShapeFactory(IApplicationState applicationState, ShapeList shapeList, List<Shape> selectedShapesList) {

        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.selectedShapesList = selectedShapesList;
    }

}