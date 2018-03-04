package com.creditsuisse.drawing.canvas

import com.creditsuisse.drawing.command.CommandParser
import org.junit.Test

import static org.junit.Assert.assertEquals;

class Utils {

    public static void assertCurrentCanvasPicture(ConsoleCanvas canvas, String expected) {
        Writer writer = new StringWriter()
        canvas.show(writer)
        println(writer.getBuffer().toString())
        assertEquals(writer.getBuffer().toString(), expected.substring(1))
    }
}

