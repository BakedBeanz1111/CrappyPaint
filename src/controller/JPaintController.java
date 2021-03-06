package controller;

import model.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

import java.util.List;

public class JPaintController implements IJPaintController {

    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    public ShapeList shapeList;
    public List<Shape> selectedShapesList;
    public List<Shape> copiedShapesList;
    public List<Shape> undoHistory;
    public List<Shape> redoHistory;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList, List<Shape> selectedShapesList, List<Shape> copiedShapesList, List<Shape> undoHistory, List<Shape> redoHistory) {

        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.selectedShapesList = selectedShapesList;
        this.copiedShapesList = copiedShapesList;
        this.undoHistory = undoHistory;
        this.redoHistory = redoHistory;
    }

    @Override
    public void setup() {

        setupEvents();
    }

    private void setupEvents() {

        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> new CopyShapeCommand(shapeList, selectedShapesList, copiedShapesList).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShapeCommand(shapeList,copiedShapesList).run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShapeCommand(shapeList, applicationState).run());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand(shapeList, undoHistory, redoHistory).run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand(shapeList, undoHistory, redoHistory).run());
    }
}
