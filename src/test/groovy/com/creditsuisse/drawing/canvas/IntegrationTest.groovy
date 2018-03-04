package com.creditsuisse.drawing.canvas

import com.creditsuisse.drawing.command.CommandParser
import org.junit.Test

import static com.creditsuisse.drawing.canvas.Utils.assertCurrentCanvasPicture
import static org.junit.Assert.*;

class IntegrationTest {

    @Test
    void integration() throws Exception {
        ConsoleCanvas canvas = new ConsoleCanvas()

        CommandParser parser = new CommandParser()


        parser.parseCommand("C 20 4").draw(canvas)
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
""")

        parser.parseCommand("L 1 2 6 2").draw(canvas)
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------
""")

        parser.parseCommand("L 6 3 6 4").draw(canvas)
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------
""")

        parser.parseCommand("R 14 1 18 3").draw(canvas)
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------
""")

        parser.parseCommand("B 10 3 o").draw(canvas)
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------
""")


    }

}
