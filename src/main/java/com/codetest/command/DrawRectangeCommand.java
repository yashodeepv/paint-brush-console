package com.codetest.command;

import com.codetest.entity.DrawingCanvas;

import java.util.List;

public class DrawRectangeCommand implements ConsoleCommand {

    @Override
    public void execute(List<String> params, DrawingCanvas drawingCanvas) {
        if(params.size() != 4) {
            throw new IllegalArgumentException("Invalid parameters. Usage : r x1 y1 x2 y2");
        }
        int x1 = Integer.parseInt(params.get(0));
        int y1 = Integer.parseInt(params.get(1));
        int x2 = Integer.parseInt(params.get(2));
        int y2 = Integer.parseInt(params.get(3));
        drawingCanvas.drawRectangle(x1, y1, x2, y2);
        drawingCanvas.show();
    }
}
