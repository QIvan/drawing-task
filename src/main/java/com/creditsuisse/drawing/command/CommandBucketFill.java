package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.algo.FloodFill4;
import com.creditsuisse.drawing.canvas.Canvas;
import com.creditsuisse.drawing.primitive.Colour;
import com.creditsuisse.drawing.primitive.Point;
import com.creditsuisse.drawing.primitive.Shape;
import lombok.Getter;

import java.util.Collections;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
public class CommandBucketFill implements Command {
    private static FloodFill4 fillAlgo = new FloodFill4();

    private final Point startPoint;
    private final Colour colour;

    public CommandBucketFill(Deque<String> args) {
        try {
            startPoint = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));
            String colour = args.pop();
            if (colour.length() != 1) {
                throw new IllegalArgumentException("Colour should be represent as single character");
            }
            this.colour = new Colour(colour.toCharArray()[0]);

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for CommandBucketFill should have 4 coordinates which represent as 4 integer values"
            );
        }
    }

    @Override
    public Shape draw(Canvas canvas) {
        return fillAlgo.fill(canvas, startPoint, colour);

    }
}
