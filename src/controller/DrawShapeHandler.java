package src.controller;

import model.*;
import model.Shape;
import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShapeStrategy;
import view.gui.PaintCanvas;
import java.awt.*;
import java.util.List;

public class DrawShapeHandler implements IDrawShapeHandler {

    public PaintCanvas paintCanvas;
    public IShapeStrategy iShapeStrategy;

    public DrawShapeHandler(PaintCanvas paintCanvas, IShapeStrategy iShapeStrategy) {

        this.paintCanvas = paintCanvas;
        this.iShapeStrategy = iShapeStrategy;
    }

    @Override
    public void update(List<Shape> globalShapeList) {

        Graphics2D graphics2D = paintCanvas.getGraphics2D();

        //Every time DrawShapeHandler.update is called, place a white rectangle on the screen and than draw over it
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,paintCanvas.getWidth(),paintCanvas.getHeight());

        System.out.println("I should be printing out " + globalShapeList.size() + " shapes");

        //Only printing the most recent shape
        for(Shape shape : globalShapeList) {

            if(shape.shapeType.toString().equals("ELLIPSE")) {

                if(shape.shapeShadingType.toString().equals("FILLED_IN")) {

                    iShapeStrategy = new EllipseFilledInStrategy(shape, shape.shapeColor, graphics2D);
                }

                else if(shape.shapeShadingType.toString().equals("OUTLINE")) {

                    iShapeStrategy = new EllipseOutlineStrategy(shape, shape.lineColor, graphics2D);
                }

                else if(shape.shapeShadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {

                    iShapeStrategy = new EllipseOutlineFilledInStrategy(shape, shape.shapeColor, shape.lineColor, graphics2D);
                }
            }

            if(shape.shapeType.toString().equals("RECTANGLE")) {

                if(shape.shapeShadingType.toString().equals("FILLED_IN")) {

                    iShapeStrategy = new RectangleFilledInStrategy(shape, shape.shapeColor, graphics2D);
                }

                else if(shape.shapeShadingType.toString().equals("OUTLINE")) {

                    iShapeStrategy = new RectangleOutlineStrategy(shape, shape.lineColor, graphics2D);
                }

                else if(shape.shapeShadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {

                    iShapeStrategy = new RectangleOutlineFilledInStrategy(shape, shape.shapeColor, shape.lineColor, graphics2D);
                }
            }

            if(shape.shapeType.toString().equals("TRIANGLE")) {

                if(shape.shapeShadingType.toString().equals("FILLED_IN")) {

                    iShapeStrategy = new TriangleFilledInStrategy(shape, shape.shapeColor, graphics2D);
                }

                else if(shape.shapeShadingType.toString().equals("OUTLINE")) {

                    iShapeStrategy = new TriangleOutlineStrategy(shape, shape.lineColor, graphics2D);
                }

                else if(shape.shapeShadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {

                    iShapeStrategy = new TriangleOutlineFilledInStrategy(shape, shape.shapeColor, shape.lineColor, graphics2D);
                }
            }

            iShapeStrategy.draw();
        }
    }
}
