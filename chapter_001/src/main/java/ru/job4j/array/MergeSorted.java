package ru.job4j.array;

import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) {
        int[] first = {1, 4, 6, 7, 10};
        int[] second = {-1, 3, 4, 5, 16};
        int[] result = new MergeSorted().merge(first, second);
        System.out.println(Arrays.toString(result));
    }

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
