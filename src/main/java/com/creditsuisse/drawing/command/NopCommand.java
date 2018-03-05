package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.canvas.Canvas;
import com.creditsuisse.drawing.primitive.Shape;

import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author Ivan Zemlyanskiy
 */
public class NopCommand implements Command {

    @Override
    public Shape draw(Canvas canvas) {
        // do nothing
        return new Shape(Collections::emptyIterator);

    }
}
