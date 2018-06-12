package ru.job4j.array;

public class MergeSorted {
    public static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int foo = 0;
        int sar = 0;
        for (int i = 0; i < result.length; i++) {
            if (foo == first.length) {
                result[i] = second[sar++];
            } else if (sar == second.length) {
                result[i] = first[foo++];
            } else if (first[foo] <= second[sar]) {
                result[i] = first[foo++];
            } else if (first[foo] > second[sar]) {
                result[i] = second[sar++];
            }
        }
        return result;
    }
}
