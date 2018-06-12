package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean corner = data[0][0];
        boolean isMono = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i][i] != corner) {
                isMono = false;
                break;
            }
            if (data[i][data.length - i - 1] != corner) {
                isMono = false;
                break;
            }
        }
        return isMono;
    }
}
