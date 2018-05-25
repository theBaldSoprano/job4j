package ru.job4j.array;

public class FindLoop {
    /**
     * Returns the index of element in array.
     * Returns -1 if element not present.
     *
     * @param data
     * @param el
     * @return
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}