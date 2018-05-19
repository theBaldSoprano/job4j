package ru.job4j.loop;

public class Counter {
    /**
     * Returns the sum of all even nums from start to finish
     * @param start
     * @param finish
     * @return
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) result += i;
        }
        return result;
    }
}
