package com.codetest;

import com.codetest.command.*;
import com.codetest.entity.ConsoleCommandType;
import com.codetest.entity.DrawingCanvas;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;


/**
 * Acts like remote control which will have multiple commands and respective execution classes
 */
public class ConsoleCommandSwitch {

    private DrawingCanvas drawingCanvas;
    private Map<ConsoleCommandType, ConsoleCommand> commands;

    public ConsoleCommandSwitch(DrawingCanvas drawingCanvas) {
        this.drawingCanvas = drawingCanvas;
        commands = new HashMap<>();
        commands.put(ConsoleCommandType.CREATE_CANVAS, new CreateCanvasCommand());
        commands.put(ConsoleCommandType.DRAW_LINE, new DrawLineCommand());
        commands.put(ConsoleCommandType.DRAW_RECTANGLE, new DrawRectangeCommand());
        commands.put(ConsoleCommandType.FLOOD_FILL, new FloodFillCommand());
    }

    public boolean executeCommand(String inputLine) {
        String[] inputLineSplit = inputLine.split(" ");
        if(inputLineSplit.length > 0) {
            ConsoleCommandType command = ConsoleCommandType.getValueOf(inputLineSplit[0]);
            ConsoleCommand consoleCommand = commands.get(command);
            if(consoleCommand != null) {
                consoleCommand.execute(
                        asList(inputLineSplit)
                                .stream()
                                .skip(1)
                                .collect(Collectors.toList()),
                        drawingCanvas);
            }
            return ConsoleCommandType.QUIT == command;
        }
        return false;
    }
}
