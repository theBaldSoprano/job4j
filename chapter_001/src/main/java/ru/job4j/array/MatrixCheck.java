package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean diag1 = true;
        boolean diag2 = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                diag1 = false;
            }
            if (data[i][data.length - i - 1] != data[i + 1][data.length - i - 2]){
                diag2 = false;
            }
        }
        return diag1 || diag2;
    }
}
