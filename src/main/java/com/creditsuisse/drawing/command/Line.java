package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.canvas.Canvas;
import com.creditsuisse.drawing.primitive.Point;
import lombok.Getter;

import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
public class Line implements Command {
    private final Point start;
    private final Point end;


    public Line(Deque<String> args) {
        try {
            start = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));
            end = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for Line command should have 4 coordinates which represent as 4 integer values"
            );
        }
    }

    @Override
    public void draw(Canvas canvas) {

    }
}
