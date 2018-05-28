package ru.job4j.loop;

public class AlternativePaint {
    /**
     * Paints a pyramid with the passed height.
     *
     * @param h
     * @return
     */
    String pyramid(int h) {
        if (h < 1) {
            throw new IllegalArgumentException();
        }
        int width = h + h - 1;
        StringBuilder pyramid = new StringBuilder();
        StringBuilder row = new StringBuilder();
        for (int i = 1; i < h + 1; i++) {
            for (int j = 0; j < width - (i + i - 1); j++) {
                row.append(" ");
            }
            for (int j = 0; j < i + i - 1; j++) {
                row.insert((width - (i + i - 1)) / 2, '^');
            }
            if (i != h) {
                row.append(System.lineSeparator());
            }
            pyramid.append(row.toString());
            row.setLength(0);
        }
        return pyramid.toString();
    }
}
