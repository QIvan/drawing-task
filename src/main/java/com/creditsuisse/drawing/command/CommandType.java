package com.creditsuisse.drawing.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Ivan Zemlyanskiy
 */
@RequiredArgsConstructor
public enum CommandType {
    NEW_CANVAS("C", NewCanvas::new),
    LINE("L", Line::new),
    RECTANGLE("R", Rectangle::new),
    BUCKET_FILL("B", BucketFill::new),
    QUIT("Q", Quit::new),
    ;

    private final String commandCharacter;
    @Getter
    private final Function<Deque<String>, Command> commandSupplier;

    public Optional<CommandType> parse(String input) {
        return input.equalsIgnoreCase(commandCharacter) ? Optional.of(this) : Optional.empty();
    }
}
