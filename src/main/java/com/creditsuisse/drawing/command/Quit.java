package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.canvas.Canvas;

import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * @author Ivan Zemlyanskiy
 */
public class Quit implements Command {


    public Quit(Deque<String> ignore) {

    }

    @Override
    public void draw(Canvas canvas) {
        // do nothing
    }
}
