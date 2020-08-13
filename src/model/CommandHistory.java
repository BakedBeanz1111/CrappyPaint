package model;

import interfaces.IUndoRedo;

import java.util.Stack;

public class CommandHistory {

    private static final Stack<IUndoRedo> undoStack = new Stack<>();
    private static final Stack<IUndoRedo> redoStack = new Stack<>();

    public static void add(IUndoRedo add) {

        undoStack.push(add);
        redoStack.clear();
    }

    public static boolean undo() {

        boolean result = !undoStack.empty();

        if(result) {

            IUndoRedo cmd = undoStack.pop();
            redoStack.push(cmd);
            cmd.undo();
        }

        return result;
    }

    public static boolean redo() {

        boolean result = !redoStack.empty();

        if(result) {

            IUndoRedo cmd = redoStack.pop();
            undoStack.push(cmd);
            cmd.redo();
        }

        return result;
    }
}
