package com.codetest.entity;

import com.codetest.exception.CanvasNotCreatedException;

import java.util.Optional;

public class DrawingCanvas {

    private String[][] canvas;
    private int width, height;

    public void createCanvas(int width, int height) {
        canvas = new String[height + 2][width + 2];
        this.width = width;
        this.height = height;

        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                String val = " ";
                if (isEdge(i, j, height, width)) {
                    if (isTopOrBottomEdge(i, j, height)) {
                        val = "-";
                    } else {
                        val = "|";
                    }
                }
                canvas[i][j] = val;
            }
        }
    }

    public void show() {
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println("");
        }
    }

    private boolean isTopOrBottomEdge(int i, int j, int i1) {
        return (i == 0 || i == i1 + 1);
    }

    private boolean isEdge(int i, int j, int i1, int i2) {
        return (i == 0 || i1 + 1 == i) || (j == 0 || j == i2 + 1);
    }

    public String getValueAt(int i, int i1) {
        return canvas[i][i1];
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        if(canvas == null) {
            throw new CanvasNotCreatedException();
        }
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                canvas[y1][i] = "x";
            }
        } else if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                canvas[i][x1] = "x";
            }
        } else {
            System.out.println("Only Horizontal or vertical lines are supported as of now");
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2) {
        if(canvas == null) {
            throw new CanvasNotCreatedException();
        }
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if ((i == y1 && j >= x1) ||
                        (i == y2 && j <= x2) ||
                        (i >= y1 && j == x1) ||
                        (i <= y2 && j == x2)) {
                    canvas[i][j] = "x";
                }
            }
        }
    }

    public void fillColor(int x, int y, String o) {
        if(canvas == null) {
            throw new CanvasNotCreatedException();
        }
        fillColorRecursively(x, y, o);
    }

    private void fillColorRecursively(int x, int y, String o) {
        if(!isOutsideBoundaries(x, y)) {
            if(!isAlreadyColored(x, y, o)
                    && !isAlreadyColored(x, y, "x")
                    && !isAlreadyColored(x, y, "-")
                    && !isAlreadyColored(x, y, "|")
            ) {
                canvas[y][x] = o;
                fillColorRecursively(x + 1, y, o);
                fillColorRecursively(x - 1, y, o);
                fillColorRecursively(x, y + 1, o);
                fillColorRecursively(x, y - 1, o);
            }
        }
    }

    private boolean isAlreadyColored(int x, int y, String o) {
        return Optional.ofNullable(canvas[y][x]).orElse(" ").equals(o);
    }

    private boolean isOutsideBoundaries(int x, int y) {
        return x < 0 || y < 0 || x > width || y > height;
    }


}


