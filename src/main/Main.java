package main;

import controller.JPaintController;
import model.Shape;
import model.ShapeFactory;
import model.ShapeList;
import model.interfaces.IShapeStrategy;
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
        List<Shape> selectedShapesList = new ArrayList<Shape>();
        List<Shape> copiedShapesList = new ArrayList<Shape>();

        //Restore persistent application state
        ApplicationState appState = new ApplicationState(uiModule);

        IShapeStrategy iShapeStrategy = null;
        ShapeList shapeList = new ShapeList(new DrawShapeHandler(paintCanvas, iShapeStrategy), globalShapeList);
        ShapeFactory shapeFactory = new ShapeFactory(appState, shapeList, selectedShapesList);

        //Setup Controller
        JPaintController controller = new JPaintController(uiModule, appState, shapeList, selectedShapesList, copiedShapesList);
        model.ShapeColor.setup();

        //Setup Mouse
        MouseAdapter mouseAdapter = new MouseAdapter(shapeFactory);
        paintCanvas.addMouseListener(mouseAdapter);

        controller.setup();
    }
}