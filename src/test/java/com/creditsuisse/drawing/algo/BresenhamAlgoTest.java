package com.creditsuisse.drawing.algo;

import com.creditsuisse.drawing.primitive.Pixel;
import com.creditsuisse.drawing.primitive.Point;
import com.creditsuisse.drawing.primitive.Shape;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @author Ivan Zemlyanskiy
 */
public class BresenhamAlgoTest {

    private BresenhamAlgo algo = new BresenhamAlgo();

    @Test
    public void drawLine() {
        Shape line = algo.drawLine(new Point(0, 1), new Point(6, 4));

        assertEquals(Arrays.asList(new Pixel(0, 1, 'x'),
                                   new Pixel(1, 1, 'x'),
                                   new Pixel(2, 2, 'x'),
                                   new Pixel(3, 2, 'x'),
                                   new Pixel(4, 3, 'x'),
                                   new Pixel(5, 3, 'x'),
                                   new Pixel(6, 4, 'x')
                     ),
                     IterableUtils.toList(line));

    }

    @Test
    public void drawVerticalLine() {
        Shape line = algo.drawLine(new Point(0, 1), new Point(0, 4));

        assertEquals(Arrays.asList(new Pixel(0, 1, 'x'),
                                   new Pixel(0, 2, 'x'),
                                   new Pixel(0, 3, 'x'),
                                   new Pixel(0, 4, 'x')
                     ),
                     IterableUtils.toList(line));

    }

    @Test
    public void drawHorizontalLine() {
        Shape line = algo.drawLine(new Point(1, 0), new Point(5, 0));

        assertEquals(Arrays.asList(new Pixel(1, 0, 'x'),
                                   new Pixel(2, 0, 'x'),
                                   new Pixel(3, 0, 'x'),
                                   new Pixel(4, 0, 'x'),
                                   new Pixel(5, 0, 'x')
                     ),
                     IterableUtils.toList(line));

    }

    @Test
    public void drawDot() {
        Shape line = algo.drawLine(new Point(0, 0), new Point(0, 0));

        assertEquals(Collections.singletonList(new Pixel(0, 0, 'x')),
                     IterableUtils.toList(line));
    }


    @Test
    public void drawLineStartToTheLeftEnd() {
        Shape line = algo.drawLine(new Point(6, 4), new Point(0, 1));

        assertEquals(Arrays.asList(new Pixel(0, 1, 'x'),
                                   new Pixel(1, 1, 'x'),
                                   new Pixel(2, 2, 'x'),
                                   new Pixel(3, 2, 'x'),
                                   new Pixel(4, 3, 'x'),
                                   new Pixel(5, 3, 'x'),
                                   new Pixel(6, 4, 'x')
                     ),
                     IterableUtils.toList(line));

    }


    @Test
    public void drawLineStartUnderEnd() {
        Shape line = algo.drawLine(new Point(0, 4), new Point(4, 0));

        assertEquals(Arrays.asList(new Pixel(4, 0, 'x'),
                                   new Pixel(3, 1, 'x'),
                                   new Pixel(2, 2, 'x'),
                                   new Pixel(1, 3, 'x'),
                                   new Pixel(0, 4, 'x')
                     ),
                     IterableUtils.toList(line));

    }

    @Test
    public void drawLineElongatedByY() {
        Shape line = algo.drawLine(new Point(0, 0), new Point(1, 10));

        assertEquals(Arrays.asList(new Pixel(0, 0, 'x'),
                                   new Pixel(0, 1, 'x'),
                                   new Pixel(0, 2, 'x'),
                                   new Pixel(0, 3, 'x'),
                                   new Pixel(0, 4, 'x'),
                                   new Pixel(0, 5, 'x'),
                                   new Pixel(1, 6, 'x'),
                                   new Pixel(1, 7, 'x'),
                                   new Pixel(1, 8, 'x'),
                                   new Pixel(1, 9, 'x'),
                                   new Pixel(1, 10, 'x')
                     ),
                     IterableUtils.toList(line));

    }


}