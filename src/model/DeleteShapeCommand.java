package model;

import interfaces.IUndoRedo;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;

public class DeleteShapeCommand implements IShapeCommand, IUndoRedo {

    public ShapeList shapeList;
    public IApplicationState applicationState;
    public Shape deletedShape;

    public DeleteShapeCommand(ShapeList shapeList, IApplicationState applicationState) {

        this.shapeList = shapeList;
        this.applicationState = applicationState;
        deletedShape =shapeList.globalShapeList.get(shapeList.globalShapeList.size() - 1);
    }

    //This delete function deletes the most recent drawn shape, it doesn't delete the selected shape
    //This is basically undo
    //Came to this realization on 8/5@8:17pm...
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

    @Override
    public void undo() {

        CommandHistory.undo();
        if(shapeList.globalShapeList.size() == 0) {

            System.out.println("nothing to undo");
        }
        else {

            shapeList.globalShapeList.add(deletedShape);
            shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeList.drawShapeHandler.update(shapeList.globalShapeList);
        }
    }

    @Override
    public void redo() {

        run();
    }
}
