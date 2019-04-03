package com.codetest.command;

import com.codetest.entity.DrawingCanvas;

import java.util.List;

public class CreateCanvasCommand implements ConsoleCommand {

    @Override
    public void execute(List<String> params, DrawingCanvas drawingCanvas) {
        if(params.size() != 2) {
            throw new IllegalArgumentException("Invalid parameters. Usage : c w h ");
        }
        int width = Integer.parseInt(params.get(0));
        int height = Integer.parseInt(params.get(1));
        drawingCanvas.createCanvas(width, height);
        drawingCanvas.show();
    }
}
