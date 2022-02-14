package com.pulsepoint.drawing.canvas


import static org.junit.jupiter.api.Assertions.assertEquals

class Utils {

	static void assertCurrentCanvasPicture(ConsoleCanvas canvas, String expected) {
		Writer writer = new StringWriter()
		canvas.show(writer)
		println(writer.getBuffer().toString())
		assertEquals(expected, System.lineSeparator() + writer.getBuffer().toString())
	}
}

