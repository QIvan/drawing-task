package com.pulsepoint.drawing.canvas

import com.pulsepoint.drawing.command.CommandParser
import org.junit.jupiter.api.Test

import static Utils.assertCurrentCanvasPicture

class IntegrationTest {

	@Test
	void "should draw some various commands"() throws Exception {
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
	void "should fill with a colour space between two lines"() {
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

	@Test
	void "should draw rectangle outside canvas"() {
		def canvas = new ConsoleCanvas()
		CanvasManager manager = new CanvasManager(canvas)
		CommandParser parser = new CommandParser()


		manager.applyCommand(parser.parseCommand("C 20 4"))
		manager.applyCommand(parser.parseCommand("R 10 1 20 20"))
		assertCurrentCanvasPicture(canvas,
				"""
----------------------
|                    |
|          xxxxxxxxxx|
|          x         |
|          x         |
----------------------
""")
	}
}

