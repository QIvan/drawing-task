package com.pulsepoint.drawing.command;

/** @author Ivan Zemlyanskiy */
public class IllegalCommandException extends RuntimeException {

  public IllegalCommandException(String message) {
    super(message);
  }
}
