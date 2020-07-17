package model;

import model.interfaces.IApplicationState;

public class UndoCommand {

    public IApplicationState applicationState;
    public ShapeList shapeList;

    public UndoCommand(IApplicationState applicationState, ShapeList shapeList) {

        this.applicationState = applicationState;
        this.shapeList = shapeList;
    }

    public void runUndo() {

        //remove most recent addition to shapeList
    }
}
