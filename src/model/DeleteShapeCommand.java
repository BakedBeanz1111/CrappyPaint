package model;

import model.interfaces.IShapeCommand;

import java.util.List;

public class DeleteShapeCommand implements IShapeCommand {

    public ShapeList shapeList;
    public List<Shape> selectedShapesList;


    public DeleteShapeCommand(ShapeList shapeList, List<Shape> selectedShapesList) {

        this.shapeList = shapeList;
        this.selectedShapesList = selectedShapesList;
    }

    public void delete() {

        for(Shape shape : selectedShapesList) {

            shapeList.globalShapeList.remove(shape);
        }
    }

    @Override
    public void run() {

        delete();
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.globalShapeList);
    }
}
