package com.codetest.command;

import com.codetest.entity.DrawingCanvas;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class WhenDrawingCommandsIssued {

    DrawingCanvas drawingCanvas;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        drawingCanvas = new DrawingCanvas();
    }


    @Test
    public void should_create_a_blank_canvas_of_given_size() {
        // given

        // when
        drawingCanvas.createCanvas(20, 4);

        // then
        Assert.assertThat(drawingCanvas.getValueAt(0,0), CoreMatchers.is("-"));
        Assert.assertThat(drawingCanvas.getValueAt(1,0), CoreMatchers.is("|"));
    }

    @Test
    public void should_create_a_horizontal_line_for_given_coordinates() {
        // given

        // when
        drawingCanvas.createCanvas(20, 4);
        drawingCanvas.drawLine(1,2,6,2);
        // then
        Assert.assertThat(drawingCanvas.getValueAt(2,2), CoreMatchers.is("x"));
    }

    @Test
    public void should_create_a_vertical_line_for_given_coordinates() {
        // given

        // when
        drawingCanvas.createCanvas(20, 4);
        drawingCanvas.drawLine(1,2,6,2);
        drawingCanvas.drawLine(6,3,6,4);
        // then
        Assert.assertThat(drawingCanvas.getValueAt(2,2), CoreMatchers.is("x"));
        Assert.assertThat(drawingCanvas.getValueAt(4,6), CoreMatchers.is("x"));
    }

    @Test
    public void should_create_a_rectangle_for_given_coordinates() {
        // given

        // when
        drawingCanvas.createCanvas(20, 4);
        drawingCanvas.drawLine(1,2,6,2);
        drawingCanvas.drawLine(6,3,6,4);
        drawingCanvas.drawRectangle(14, 1, 18, 3);
        // then
        Assert.assertThat(drawingCanvas.getValueAt(2,2), CoreMatchers.is("x"));
        Assert.assertThat(drawingCanvas.getValueAt(4,6), CoreMatchers.is("x"));
        Assert.assertThat(drawingCanvas.getValueAt(2,14), CoreMatchers.is("x"));
    }

    @Test
    public void should_flood_fill_around_given_coordinate() {
        // given

        // when
        drawingCanvas.createCanvas(20, 4);
        drawingCanvas.drawLine(1,2,6,2);
        drawingCanvas.drawLine(6,3,6,4);
        drawingCanvas.drawRectangle(14, 1, 18, 3);
        drawingCanvas.fillColor(10, 3, "o");
        // then
        Assert.assertThat(drawingCanvas.getValueAt(2,2), CoreMatchers.is("x"));
        Assert.assertThat(drawingCanvas.getValueAt(4,6), CoreMatchers.is("x"));
        Assert.assertThat(drawingCanvas.getValueAt(2,14), CoreMatchers.is("x"));
        Assert.assertThat(drawingCanvas.getValueAt(3,10), CoreMatchers.is("o"));
    }


}
