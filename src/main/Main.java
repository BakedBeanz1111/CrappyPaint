package main;

import controller.JPaintController;
import model.ShapeList;
import model.persistence.ApplicationState;
import src.controller.MouseAdapter;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        //Define UI Look at feel
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ShapeList shapeList = new ShapeList(new src.controller.DrawShapeHandler(paintCanvas));

        //Restore persistent application state
        ApplicationState appState = new ApplicationState(uiModule);

        //Setup Controller
        JPaintController controller = new JPaintController(uiModule, appState);

        //Setup Mouse
        MouseAdapter mouseAdapter = new MouseAdapter(appState, shapeList);
        paintCanvas.addMouseListener(mouseAdapter);

        //Setup Drawing
        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        src.controller.DrawShapeHandler drawShapeHandler = new src.controller.DrawShapeHandler(paintCanvas);



        controller.setup();
    }
}