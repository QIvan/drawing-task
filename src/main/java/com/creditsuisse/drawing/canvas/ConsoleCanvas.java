package com.creditsuisse.drawing.canvas;

import com.creditsuisse.drawing.primitive.Colour;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Ivan Zemlyanskiy
 */
public class ConsoleCanvas implements Canvas {

    private boolean init = false;

    private int width = 0;
    private int height = 0;

    private char[][] matrix;

    @Override
    public void init(int width, int height) {
        this.width = width;
        this.height = height;

        matrix = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = ' ';
            }
        }

        init = true;
    }

    @Override
    public void drawPixel(int x, int y, Colour colour) {
        checkState();

        matrix[y][x] = colour.getValue();
    }

    @Override
    public void show(Writer writer) throws IOException {
        checkState();

        for (int i = 0; i < width + 2; i++) {
            writer.append('-');
        }
        writer.append("\n");

        for (int i = 0; i < height; i++) {
            writer.append('|');
            for (char c : matrix[i]) {
                writer.append(c);
            }
            writer.append("|\n");
        }

        for (int i = 0; i < width + 2; i++) {
            writer.append('-');
        }
        writer.append("\n");
        writer.flush();
    }

    private void checkState() {
        if (!init) {
            throw new IllegalStateException("Canvas wasn't initialized!");
        }
    }
}
