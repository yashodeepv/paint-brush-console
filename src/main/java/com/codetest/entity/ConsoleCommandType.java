package com.codetest.entity;

import java.util.stream.Stream;

public enum ConsoleCommandType {
    CREATE_CANVAS("C"),
    DRAW_LINE("L"),
    DRAW_RECTANGLE("R"),
    FLOOD_FILL("B"),
    QUIT("Q");

    String commandName;

    ConsoleCommandType(String c) {
        this.commandName = c;
    }

    public static ConsoleCommandType getValueOf(String s) {
        return Stream.of(ConsoleCommandType.values())
                .filter(a -> a.commandName.equalsIgnoreCase(s))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Command not supported"));
    }
}
