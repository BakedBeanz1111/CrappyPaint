package model;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;

import java.util.List;

public class DeleteShapeCommand implements IShapeCommand {

    public ShapeList shapeList;
    public IApplicationState applicationState;

    public DeleteShapeCommand(ShapeList shapeList, IApplicationState applicationState) {

        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    public void delete() {

        if(shapeList.globalShapeList.size() == 0) {

            System.out.println("Can't delete anything!");
        }
        else {

            shapeList.globalShapeList.remove(shapeList.globalShapeList.size() - 1);
        }
    }

    @Override
    public void run() {

        delete();
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.globalShapeList);
    }
}
