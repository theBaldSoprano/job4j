package ru.job4j.max;

public class Max {
    /**
     * Takes two ints and returns max of them.
     *
     * @param first
     * @param second
     * @return returns max value of two args
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Returns the max num from three.
     *
     * @param first
     * @param second
     * @param third
     * @return
     */
    public int max(int first, int second, int third) {
        int tmp = max(first, second);
        return max(tmp, third);
    }
}
