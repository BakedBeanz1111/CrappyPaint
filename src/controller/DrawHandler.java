package src.controller;

import view.gui.PaintCanvas;

import java.awt.*;

public class DrawHandler {

    private static PaintCanvas paintCanvas;

    public DrawHandler(PaintCanvas paintCanvas) {
        paintCanvas.getGraphics2D();
    }

    public static void draw(Shape shape) {
        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.draw(shape);
    }
}
