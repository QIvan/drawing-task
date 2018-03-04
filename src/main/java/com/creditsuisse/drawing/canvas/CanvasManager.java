package com.creditsuisse.drawing.canvas;

import com.creditsuisse.drawing.command.Command;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Ivan Zemlyanskiy
 */
public class CanvasManager {

    private final Canvas canvas;

    public CanvasManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public void applyCommand(Command command) {
        command.draw(canvas);
    }

    public void show(Writer writer) throws IOException {
        canvas.show(writer);
    }
}
