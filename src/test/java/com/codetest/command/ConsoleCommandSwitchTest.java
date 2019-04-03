package com.codetest.command;

import com.codetest.ConsoleCommandSwitch;
import com.codetest.entity.DrawingCanvas;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ConsoleCommandSwitchTest {

    @Mock
    DrawingCanvas drawingCanvas;

    @InjectMocks
    ConsoleCommandSwitch consoleCommandSwitch;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_call_create_canvas_for_c_command() {
        // given

        // when
        consoleCommandSwitch.executeCommand("c 20 4");

        // then
        Mockito.verify(drawingCanvas).createCanvas(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void should_call_draw_line_for_l_command() {
        // given

        // when
        consoleCommandSwitch.executeCommand("l 20 4 10 4");

        // then
        Mockito.verify(drawingCanvas).drawLine(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void should_call_draw_rect_for_r_command() {
        // given

        // when
        consoleCommandSwitch.executeCommand("r 20 4 10 4");

        // then
        Mockito.verify(drawingCanvas).drawRectangle(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void should_call_flood_fill_for_b_command() {
        // given

        // when
        consoleCommandSwitch.executeCommand("b 20 4 o");

        // then
        Mockito.verify(drawingCanvas).fillColor(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }


}