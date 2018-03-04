package com.creditsuisse.drawing.canvas

import com.creditsuisse.drawing.command.CommandParser
import org.junit.Test

import static com.creditsuisse.drawing.canvas.Utils.assertCurrentCanvasPicture

class IntegrationTest {

    @Test
    void integration() throws Exception {
        def canvas = new ConsoleCanvas()
        CanvasManager manager = new CanvasManager(canvas)

        CommandParser parser = new CommandParser()


        manager.applyCommand(parser.parseCommand("C 20 4"))
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
""")
//
//        parser.parseCommand("L 1 2 6 2").getAlgorithm()
//        assertCurrentCanvasPicture(canvas,
//                """
//----------------------
//|                    |
//|xxxxxx              |
//|                    |
//|                    |
//----------------------
//""")
//
//        parser.parseCommand("L 6 3 6 4").getAlgorithm()
//        assertCurrentCanvasPicture(canvas,
//                """
//----------------------
//|                    |
//|xxxxxx              |
//|     x              |
//|     x              |
//----------------------
//""")
//
//        parser.parseCommand("R 14 1 18 3").getAlgorithm()
//        assertCurrentCanvasPicture(canvas,
//                """
//----------------------
//|             xxxxx  |
//|xxxxxx       x   x  |
//|     x       xxxxx  |
//|     x              |
//----------------------
//""")
//
//        parser.parseCommand("B 10 3 o").getAlgorithm()
//        assertCurrentCanvasPicture(canvas,
//                """
//----------------------
//|oooooooooooooxxxxxoo|
//|xxxxxxooooooox   xoo|
//|     xoooooooxxxxxoo|
//|     xoooooooooooooo|
//----------------------
//""")
//

    }

}

