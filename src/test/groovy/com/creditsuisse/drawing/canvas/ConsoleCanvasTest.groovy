package com.creditsuisse.drawing.canvas

import com.creditsuisse.drawing.primitive.Colour
import org.junit.Test

import static com.creditsuisse.drawing.canvas.Utils.assertCurrentCanvasPicture

class ConsoleCanvasTest {


    @Test
    public void drawPixel() {
        def canvas = new ConsoleCanvas()
        canvas.init(3,2)
        canvas.drawPixel(0,0,new Colour('x' as char))
        assertCurrentCanvasPicture(canvas, """
-----
|x  |
|   |
-----
""")
        canvas.drawPixel(0,0,new Colour('c' as char))
        assertCurrentCanvasPicture(canvas, """
-----
|c  |
|   |
-----
""")


    }
}

