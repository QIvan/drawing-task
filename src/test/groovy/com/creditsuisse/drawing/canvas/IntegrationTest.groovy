package com.creditsuisse.drawing.canvas

import com.creditsuisse.drawing.command.CommandParser
import org.junit.Test

import static com.creditsuisse.drawing.canvas.Utils.assertCurrentCanvasPicture

class IntegrationTest {

    @Test
    void integrationSampleInput() throws Exception {
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

        manager.applyCommand(parser.parseCommand("L 0 1 5 1"))
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------
""")

        manager.applyCommand(parser.parseCommand("L 5 2 5 3"))
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------
""")

        manager.applyCommand(parser.parseCommand("R 13 0 17 2"))
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------
""")

        manager.applyCommand(parser.parseCommand("B 10 3 o"))
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

    @Test
    public void integrationTestFill() {
        def canvas = new ConsoleCanvas()
        CanvasManager manager = new CanvasManager(canvas)

        CommandParser parser = new CommandParser()


        manager.applyCommand(parser.parseCommand("C 20 4"))
        manager.applyCommand(parser.parseCommand("L 0 1 10 3"))
        manager.applyCommand(parser.parseCommand("L 15 0 19 2"))
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|               xx   |
|xxx              xx |
|   xxxxx           x|
|        xxx         |
----------------------
""")

        manager.applyCommand(parser.parseCommand("B 0 0 o"))
        assertCurrentCanvasPicture(canvas,
                """
----------------------
|oooooooooooooooxx   |
|xxxooooooooooooooxx |
|   xxxxxooooooooooox|
|        xxxooooooooo|
----------------------
""")

    }
}

