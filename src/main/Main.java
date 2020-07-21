package main;

import controller.JPaintController;
import model.Shape;
import model.ShapeFactory;
import model.ShapeList;
import model.persistence.ApplicationState;
import src.controller.MouseAdapter;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import src.controller.DrawShapeHandler;
import java.util.List;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        //Define UI Look at feel
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        List<Shape> globalShapeList = new ArrayList<Shape>();

        //Restore persistent application state
        ApplicationState appState = new ApplicationState(uiModule);

        ShapeList shapeList = new ShapeList(new DrawShapeHandler(paintCanvas), globalShapeList);
        ShapeFactory shapeFactory = new ShapeFactory(appState, shapeList);

        //Setup Controller
        JPaintController controller = new JPaintController(uiModule, appState);
        model.ShapeColor.setup();

        //Setup Mouse
        MouseAdapter mouseAdapter = new MouseAdapter(shapeFactory);
        paintCanvas.addMouseListener(mouseAdapter);

        controller.setup();
    }
}