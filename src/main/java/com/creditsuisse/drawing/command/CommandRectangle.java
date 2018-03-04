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
public class CommandRectangle implements Command {
    private final Point leftCorner;
    private final Point rightCorner;


    public CommandRectangle(Deque<String> args) {
        try {
            leftCorner = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));
            rightCorner = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for CommandRectangle should have 4 coordinates which represent as 4 integer values"
            );
        }
    }
    @Override
    public void draw(Canvas canvas) {
    }
}
