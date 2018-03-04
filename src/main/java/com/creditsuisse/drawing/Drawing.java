package com.creditsuisse.drawing;

import com.creditsuisse.drawing.canvas.CanvasManager;
import com.creditsuisse.drawing.canvas.ConsoleCanvas;
import com.creditsuisse.drawing.command.*;

import java.io.*;
import java.util.Scanner;

/**
 * @author Ivan Zemlyanskiy
 */
public class Drawing {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);


        Writer writer = new PrintWriter(System.out);
        CanvasManager manager = new CanvasManager(new ConsoleCanvas());

        CommandParser parser = new CommandParser();
        Command command;
        do {
            String input = scanner.nextLine();

            try {
                command = parser.parseCommand(input);
            } catch (IllegalCommandException | IllegalArgumentException e) {
                writer.append("Verify your input! Error message: ").append(e.getMessage()).append("\n");
                command = new NopCommand();
            }

            try {
                manager.applyCommand(command);

                manager.show(writer);
            } catch (IllegalStateException e) {
                writer.append(e.getMessage());
            }

        } while (command.getClass().equals(Quit.class));

        scanner.close();

    }


}
