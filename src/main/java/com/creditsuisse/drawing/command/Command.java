package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.canvas.Canvas;
import com.creditsuisse.drawing.primitive.Shape;

/**
 * @author Ivan Zemlyanskiy
 */
public interface Command {

    Shape draw(Canvas canvas);

}
