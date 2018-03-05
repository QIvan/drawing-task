package com.creditsuisse.drawing.canvas;

import com.creditsuisse.drawing.primitive.Pixel;
import com.creditsuisse.drawing.primitive.Point;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/**
 * @author Ivan Zemlyanskiy
 */
public interface Canvas {

    void init(int width, int height);

    boolean drawPixel(Pixel pixel);

    Optional<Pixel> getPixel(Point point);

    void show(Writer writer) throws IOException;
}
