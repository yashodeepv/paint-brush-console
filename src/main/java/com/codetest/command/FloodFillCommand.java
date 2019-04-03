package com.codetest.command;

import com.codetest.entity.DrawingCanvas;

import java.util.List;

public class FloodFillCommand implements ConsoleCommand {

    @Override
    public void execute(List<String> params, DrawingCanvas drawingCanvas) {
        if(params.size() != 3) {
            throw new IllegalArgumentException("Invalid parameters. Usage : b x y color");
        }
        int x = Integer.parseInt(params.get(0));
        int y = Integer.parseInt(params.get(1));
        String color = params.get(2);
        drawingCanvas.fillColor(x, y, color);
        drawingCanvas.show();
    }
}
