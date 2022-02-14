package com.pulsepoint.drawing;

import com.pulsepoint.drawing.canvas.CanvasManager;
import com.pulsepoint.drawing.canvas.ConsoleCanvas;
import com.pulsepoint.drawing.command.*;
import com.pulsepoint.drawing.command.result.CommandResult;
import java.io.*;
import java.util.Scanner;

/** @author Ivan Zemlyanskiy */
public class Drawing {

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);

    Writer writer = new PrintWriter(System.out, true);
    PrintWriter error = new PrintWriter(System.err, true);
    CanvasManager manager = new CanvasManager(new ConsoleCanvas());

    CommandParser parser = new CommandParser();
    Command command;
    do {
      writer.write("Input command: ");
      writer.flush();
      String input = scanner.nextLine();

      try {
        command = parser.parseCommand(input);
      } catch (IllegalCommandException | IllegalArgumentException e) {
        System.err.println("Verify your input! Error message: " + e.getMessage());
        command = new NopCommand();
      }

      CommandResult commandResult = manager.applyCommand(command);
      commandResult.printCommandResult(writer, error);

      manager.show(writer);
      writer.write(System.lineSeparator());

    } while (!command.getClass().equals(Quit.class));

    scanner.close();
  }
}
