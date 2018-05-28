package ru.job4j.array;

import java.util.Arrays;

public class MergeSorted {
    public int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        for (int i = 0; i < first.length; i++) {
            result[i] = first[i];
        }
        for (int i = 0; i < second.length; i++) {
            result[i + first.length] = second[i];
        }
        return new BubbleSort().sort(result);
    }
}
