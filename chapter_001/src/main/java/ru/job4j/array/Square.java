package ru.job4j.array;

public class Square {
    /**
     * Fills an array with numbers from 1 to bound param
     * powered to 2.
     *
     * @param bound
     * @return
     */
    public int[] calculate(int bound) {
        if (bound < 1) {
            throw new IllegalArgumentException();
        }
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
