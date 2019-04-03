package com.codetest.command;

import com.codetest.entity.DrawingCanvas;

import java.util.List;

public interface ConsoleCommand {
    void execute(List<String> params, DrawingCanvas drawingCanvas);
}
