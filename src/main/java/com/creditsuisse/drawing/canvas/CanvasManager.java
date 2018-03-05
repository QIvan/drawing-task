package com.creditsuisse.drawing.canvas;

import com.creditsuisse.drawing.command.Command;
import com.creditsuisse.drawing.primitive.Pixel;

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

    public boolean applyCommand(Command command) {
        for (Pixel pixel : command.draw(canvas)) {
            if (!canvas.drawPixel(pixel)) {
                return false;
            }
        }
        return true;
    }

    public void show(Writer writer) throws IOException {
        canvas.show(writer);
    }
}
