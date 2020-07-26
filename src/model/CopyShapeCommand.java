package model;

import model.interfaces.IShapeCommand;

import java.util.List;

public class CopyShapeCommand implements IShapeCommand {

    public ShapeList shapeList;
    public List<Shape> selectedShapeList;
    public List<Shape> copiedShapeList;

    public CopyShapeCommand(ShapeList shapeList, List<Shape> selectedShapeList, List<Shape> copiedShapeList) {

        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.copiedShapeList = copiedShapeList;
    }

    public void copy(List<Shape> selectedShapeList) {

        for(Shape shape : selectedShapeList) {

            copiedShapeList.add(shape);
        }
    }

    @Override
    public void run() {

        if(selectedShapeList != null) {

            copy(selectedShapeList);
        }
    }
}
