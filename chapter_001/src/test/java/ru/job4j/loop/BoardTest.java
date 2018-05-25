package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFiveThenStringWithFiveColsAndFiveRows() {
        Board board = new Board();
        String result = board.paint(5, 5);
        final String line = System.lineSeparator();
        String expected = String.format("X X X" + line
                + " X X " + line
                + "X X X" + line
                + " X X " + line
                + "X X X" + line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(10, 3);
        final String line = System.lineSeparator();
        String expected = String.format("X X X X X " + line
                + " X X X X X" + line
                + "X X X X X " + line);
        assertThat(result, is(expected));
    }
}
