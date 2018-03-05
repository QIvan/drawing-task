package com.creditsuisse.drawing.algo;

import com.creditsuisse.drawing.primitive.Colour;
import com.creditsuisse.drawing.primitive.Pixel;
import com.creditsuisse.drawing.primitive.Point;
import com.creditsuisse.drawing.primitive.Shape;

import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

/**
 * @author Ivan Zemlyanskiy
 */
public class BresenhamAlgo {

    static final Colour LINE_COLOUR = new Colour('x');

    public Shape drawLine(Point start, Point end) {
        if (start.equals(end)) {
            return new Shape(Collections.singletonList(new Pixel(start, LINE_COLOUR)));
        }

        if (start.getX() == end.getX()) {
            int x = start.getX();
            return new Shape(IntStream.rangeClosed(start.getY(), end.getY())
                                     .mapToObj(y -> new Pixel(x, y, LINE_COLOUR))
                                     .collect(Collectors.toList()));
        }

        if (abs(start.getY() - end.getY()) < abs(start.getX() - end.getX())) {
            if (start.getX() > end.getX()) {
                return bresenhamLow(end.getX(), end.getY(), start.getX(), start.getY());
            } else {
                return bresenhamLow(start.getX(), start.getY(), end.getX(), end.getY());
            }
        } else {
            if (start.getY() > end.getY()) {
                return bresenhamHeight(end.getX(), end.getY(), start.getX(), start.getY());
            } else {
                return bresenhamHeight(start.getX(), start.getY(), end.getX(), end.getY());
            }
        }

    }

    private Shape bresenhamLow(int x0, int y0, int x1, int y1) {
        final int deltaX = abs(x1 - x0);
        final int deltaY = y1 - y0;

        final int directionY = deltaY > 0 ? 1 : -1;

        final int deltaError = abs(deltaY);


        return new Shape(() -> new Iterator<Pixel>() {
            int currentX = x0;
            int currentY = y0;
            int error = 0;


            @Override
            public boolean hasNext() {
                return currentX <= x1;
            }

            @Override
            public Pixel next() {
                Pixel result = new Pixel(currentX, currentY, LINE_COLOUR);

                error = error + deltaError;
                if (2 * error > deltaX) {
                    currentY = currentY + directionY;
                    error = error - deltaX;
                }

                currentX++;
                return result;
            }
        });
    }


    private Shape bresenhamHeight(int x0, int y0, int x1, int y1) {
        final int deltaX = x1 - x0;
        final int deltaY = abs(y1 - y0);

        final int directionX = deltaX > 0 ? 1 : -1;

        final int deltaError = abs(deltaX);


        return new Shape(() -> new Iterator<Pixel>() {
            int currentX = x0;
            int currentY = y0;
            int error = 0;


            @Override
            public boolean hasNext() {
                return currentY <= y1;
            }

            @Override
            public Pixel next() {
                Pixel result = new Pixel(currentX, currentY, LINE_COLOUR);

                error = error + deltaError;
                if (2 * error > deltaY) {
                    currentX = currentX + directionX;
                    error = error - deltaY;
                }

                currentY++;
                return result;
            }
        });
    }


}
