package com.creditsuisse.drawing.canvas;

import com.creditsuisse.drawing.primitive.Colour;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Ivan Zemlyanskiy
 */
public interface Canvas {

    void init(int width, int height);

    void drawPixel(int x, int y, Colour colour);

    void show(Writer writer) throws IOException;
}
