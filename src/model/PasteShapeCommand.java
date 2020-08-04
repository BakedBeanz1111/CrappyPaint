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

            shape.startPoint.x = shape.startPoint.x + 100;
            shape.startPoint.y = shape.startPoint.y + 100;

            shape.endPoint.x = shape.endPoint.x + 100;
            shape.endPoint.y = shape.endPoint.y + 100;

            Shape copiedShape = new Shape(shape.startPoint, shape.endPoint, shape.shapeType, shape.shapeColor, shape.lineColor, shape.shapeShadingType);

            shapeList.globalShapeList.add(copiedShape);
        }

        System.out.println("You have pasted " + copiedShapesList.size() + " shapes");
    }

    @Override
    public void run() {

        paste(copiedShapesList);
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.globalShapeList);
    }
}
