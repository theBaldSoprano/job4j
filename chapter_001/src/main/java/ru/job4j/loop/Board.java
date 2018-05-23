package ru.job4j.loop;

public class Board {
    /**
     * Builds a visual chess deck of X and Spaces
     * with the passed width and height.
     *
     * @param width
     * @param height
     * @return
     */
    public String paint(int width, int height) {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((j + i) % 2 == 0) board.append('X');
                else board.append(" ");
            }
            if (i != height - 1) board.append(System.lineSeparator());
        }
        return board.toString();
    }
}
