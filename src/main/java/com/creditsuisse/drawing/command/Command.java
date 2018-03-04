package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.canvas.Canvas;

/**
 * @author Ivan Zemlyanskiy
 */
public interface Command {

    void draw(Canvas canvas);

}
