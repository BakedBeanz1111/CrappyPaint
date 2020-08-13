package model;

import interfaces.IUndoRedo;
import model.interfaces.IShapeCommand;

import java.util.List;

public class UndoCommand implements IShapeCommand, IUndoRedo {

    public ShapeList shapeList;
    public List<Shape> undoHistory;
    public List<Shape> redoHistory;

    public UndoCommand(ShapeList shapeList, List<Shape> undoHistory, List<Shape> redoHistory) {

        this.shapeList = shapeList;
        this.undoHistory = undoHistory;
        this.redoHistory = redoHistory;
    }

    @Override
    public void undo() {

        CommandHistory.undo();
    }

    @Override
    public void redo() {

        CommandHistory.redo();
    }

    @Override
    public void run() {

        undo();

        if(shapeList.globalShapeList.size() == 0 & undoHistory.size() == 0) {

            System.out.println("Can't undo anything!");
        }
        else {

            int redoIndex = shapeList.globalShapeList.size() - 1;
            Shape redoShape = shapeList.globalShapeList.get(redoIndex);

            if( redoHistory.size() > 1) {

                redoHistory.clear();
                redoHistory.add(redoShape);
            }
            else {

                redoHistory.add(redoShape);
            }

            shapeList.globalShapeList.remove(shapeList.globalShapeList.size() - 1);
            shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeList.drawShapeHandler.update(shapeList.globalShapeList);
        }
    }
}
