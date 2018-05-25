package ru.job4j.array;

public class BubbleSort {
    /**
     * Bubble sort an array.
     *
     * @param array
     * @return
     */
    public int[] sort(int[] array) {
        int depth = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < depth; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            depth--;
        }
        return array;
    }
}
