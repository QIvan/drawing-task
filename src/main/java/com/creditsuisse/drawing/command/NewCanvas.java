package com.creditsuisse.drawing.command;

import com.creditsuisse.drawing.canvas.Canvas;
import lombok.Getter;

import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
public class NewCanvas implements Command {

    private final int width;
    private final int height;

    public NewCanvas(Deque<String> args) {
        try {
            width = Integer.valueOf(args.pop());
            height = Integer.valueOf(args.pop());

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for Create Canvas command should have width and height which represent as 2 integer values"
            );
        }
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.init(width, height);
    }
}
