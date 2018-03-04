package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.canvas.Canvas;
import com.creditsuisse.drawing.primitive.Colour;
import com.creditsuisse.drawing.primitive.Point;
import lombok.Getter;

import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
public class BucketFill implements Command {
    private final Point startPoint;
    private final Colour colour;

    public BucketFill(Deque<String> args) {
        try {
            startPoint = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));
            String colour = args.pop();
            if (colour.length() != 1) {
                throw new IllegalArgumentException("Colour should be represent as single character");
            }
            this.colour = new Colour(colour.toCharArray()[0]);

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for Rectangle command should have 4 coordinates which represent as 4 integer values"
            );
        }
    }

    @Override
    public void draw(Canvas canvas) {

    }
}
