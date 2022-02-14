package com.pulsepoint.drawing.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/** @author Ivan Zemlyanskiy */
public class CommandParserTest {

  private final CommandParser parser = new CommandParser();

  @Test
  public void parseCreateCanvas() {
    String input = "C 1 2";
    Command command = parser.parseCommand(input);
    assertEquals(CommandNewCanvas.class, command.getClass());
    CommandNewCanvas newCanvas = (CommandNewCanvas) command;
    assertEquals(1, newCanvas.getWidth());
    assertEquals(2, newCanvas.getHeight());
  }

  @Test
  public void parseCreateLine() {
    String input = "L 1 2 3 4";
    Command command = parser.parseCommand(input);
    assertEquals(CommandLine.class, command.getClass());
    CommandLine line = (CommandLine) command;
    assertEquals(1, line.getStart().getX());
    assertEquals(2, line.getStart().getY());
    assertEquals(3, line.getEnd().getX());
    assertEquals(4, line.getEnd().getY());
  }

  @Test
  public void parseCreateRectangle() {
    String input = "R 1 2 3 4";
    Command command = parser.parseCommand(input);
    assertEquals(CommandRectangle.class, command.getClass());
    CommandRectangle rectangle = (CommandRectangle) command;
    assertEquals(1, rectangle.getLeftCorner().getX());
    assertEquals(2, rectangle.getLeftCorner().getY());
    assertEquals(3, rectangle.getRightCorner().getX());
    assertEquals(4, rectangle.getRightCorner().getY());
  }

  @Test
  public void parseCreateBucketFill() {
    String input = "B 1 2 o";
    Command command = parser.parseCommand(input);
    assertEquals(CommandBucketFill.class, command.getClass());
    CommandBucketFill bucketFill = (CommandBucketFill) command;
    assertEquals(1, bucketFill.getStartPoint().getX());
    assertEquals(2, bucketFill.getStartPoint().getY());
    assertEquals("o".charAt(0), bucketFill.getColour().getValue());
  }

  @Test
  public void parseCreateQuit() {
    String input = "Q";
    assertEquals(Quit.class, parser.parseCommand(input).getClass());
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "L 1 2 3",
        "R 1 2 3",
        "R 1 2 3",
        "No Command Here",
        "" // empty
      })
  public void parseBadCommands() {
    String input = "L 1 2 3";
    assertThrows(IllegalArgumentException.class, () -> parser.parseCommand(input));
  }
}
