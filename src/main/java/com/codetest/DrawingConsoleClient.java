package com.codetest;

import com.codetest.entity.DrawingCanvas;
import com.codetest.exception.CanvasNotCreatedException;

import java.util.Scanner;

public class DrawingConsoleClient {

    public static void main(String[] args) {
        System.out.println("Welcome to Interactive Paint - Console based");
        System.out.println("Supported commands:");
        System.out.println("C w h           Should create a new canvas of width w and height h.\n" +
                "L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
                "                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
                "                will be drawn using the 'x' character.\n" +
                "R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
                "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
                "                using the 'x' character.\n" +
                "B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
                "                behaviour of this is the same as that of the \"bucket fill\" tool in paint\n" +
                "                programs.\n" +
                "Q               Should quit the program.");
        System.out.println("Enter commands below:");
        DrawingCanvas drawingCanvas = new DrawingCanvas();
        ConsoleCommandSwitch consoleCommandSwitch = new ConsoleCommandSwitch(drawingCanvas);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            try {
                boolean shouldExit = consoleCommandSwitch.executeCommand(input);
                if (shouldExit) {
                    break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            } catch (CanvasNotCreatedException cnc) {
                System.out.println("Canvas is not created - first issue c w h command and then issue l or r or g commands");
            }
        }
    }

}
