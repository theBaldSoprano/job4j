package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                result = false;
                break;
            }
        }
        if (result) {
            return result;
        }
        result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][data.length - i - 1] != data[i + 1][data.length - i - 2]) {
                return false;
            }
        }
        return result;
    }
}
