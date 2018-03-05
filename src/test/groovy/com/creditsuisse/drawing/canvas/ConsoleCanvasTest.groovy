package com.creditsuisse.drawing.canvas

import com.creditsuisse.drawing.primitive.Pixel
import org.junit.Test

import static com.creditsuisse.drawing.canvas.Utils.assertCurrentCanvasPicture
import static org.junit.Assert.*

class ConsoleCanvasTest {


    @Test
    public void drawPixel() {
        def canvas = new ConsoleCanvas()
        canvas.init(3, 2)
        canvas.drawPixel(new Pixel(0, 0, 'x' as char))
        assertCurrentCanvasPicture(canvas, """
-----
|x  |
|   |
-----
""")
        canvas.drawPixel(new Pixel(0, 0, 'c' as char))
        assertCurrentCanvasPicture(canvas, """
-----
|c  |
|   |
-----
""")

        assertFalse(canvas.drawPixel(new Pixel(0, 2, 'x' as char)))
        assertFalse(canvas.drawPixel(new Pixel(0, 3, 'x' as char)))
        assertFalse(canvas.drawPixel(new Pixel(3, 0, 'x' as char)))
        assertFalse(canvas.drawPixel(new Pixel(5, 0, 'x' as char)))
    }
}

