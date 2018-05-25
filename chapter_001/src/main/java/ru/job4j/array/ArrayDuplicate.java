package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Removes duplicates from passed array.
     *
     * @param array
     * @return
     */
    public String[] remove(String[] array) {
        int duplicates = 0;
        String sample;
        for (int i = 0; i < array.length - duplicates; i++) {
            sample = array[i];
            for (int j = i + 1; j < array.length - duplicates; j++) {
                if (sample.equals(array[j])) {
                    for (int k = j; k < array.length - 1; k++) {
                        String tmp = array[k];
                        array[k] = array[k + 1];
                        array[k + 1] = tmp;
                    }
                    j--;
                    duplicates++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - duplicates);
    }
}
