package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.canvas.Canvas;

/**
 * @author Ivan Zemlyanskiy
 */
public class NopCommand implements Command {

    @Override
    public void draw(Canvas canvas) {
        // do nothing
    }
}
