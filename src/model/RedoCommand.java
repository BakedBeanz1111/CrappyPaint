package model;

import interfaces.IUndoRedo;
import model.interfaces.IShapeCommand;

import java.util.List;

public class RedoCommand implements IShapeCommand, IUndoRedo {

    public ShapeList shapeList;
    public List<Shape> undoHistory;
    public List<Shape> redoHistory;

    public RedoCommand(ShapeList shapeList, List<Shape> undoHistory, List<Shape> redoHistory) {

        this.shapeList = shapeList;
        this.undoHistory = undoHistory;
        this.redoHistory = redoHistory;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void run() {

        redo();

        if( shapeList.globalShapeList.size() == 0 && redoHistory.size() == 0) {

            System.out.println("Nothing to redo!");
        }
        else {

            int undoIndex = redoHistory.size() - 1;
            Shape undoShape = redoHistory.get(undoIndex);

            if( undoHistory.size() > 1) {

                undoHistory.clear();
                undoHistory.add(undoShape);
            }
            else {

                undoHistory.add(undoShape);
            }

            shapeList.globalShapeList.add(undoShape);
            shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeList.drawShapeHandler.update(shapeList.globalShapeList);
        }
    }
}

