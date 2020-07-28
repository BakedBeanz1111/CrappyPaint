package model;

import model.interfaces.IShapeCommand;

import java.util.List;

public class PasteShapeCommand implements IShapeCommand {

    public ShapeList shapeList;
    public List<Shape> copiedShapesList;

    public PasteShapeCommand(ShapeList shapeList, List<Shape> copiedShapesList) {

        this.shapeList = shapeList;
        this.copiedShapesList = copiedShapesList;
    }

    public void paste(List<Shape> copiedShapesList) {

        for(Shape shape : copiedShapesList) {

            shape.startPoint.x = 0;
            shape.startPoint.y = 0;

            shape.endPoint.x = 0;
            shape.endPoint.y = 0;

            Shape copiedShape = new Shape(shape.startPoint, shape.endPoint, shape.shapeType, shape.shapeColor, shape.lineColor, shape.shapeShadingType);

            shapeList.globalShapeList.add(copiedShape);
        }
    }

    @Override
    public void run() {

        paste(copiedShapesList);
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.globalShapeList);
    }
}
