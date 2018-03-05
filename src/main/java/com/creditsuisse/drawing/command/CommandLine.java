package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.algo.BresenhamAlgo;
import com.creditsuisse.drawing.canvas.Canvas;
import com.creditsuisse.drawing.primitive.Point;
import com.creditsuisse.drawing.primitive.Shape;
import lombok.Getter;

import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
public class CommandLine implements Command {

    private static final BresenhamAlgo lineAlgo = new BresenhamAlgo();

    private final Point start;
    private final Point end;

    public CommandLine(Deque<String> args) {
        try {
            start = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));
            end = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for CommandLine should have 4 coordinates which represent as 4 integer values"
            );
        }
    }

    @Override
    public Shape draw(Canvas canvas) {
        return lineAlgo.drawLine(start, end);
    }

}
