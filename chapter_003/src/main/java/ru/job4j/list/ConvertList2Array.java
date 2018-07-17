package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {
    public static void main(String[] args) {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        for (int[] x : result) {
            System.out.println(Arrays.toString(x));
        }
    }

    public int[][] toArray(List<Integer> list, int rows) {
        int cells;
        if (list.size() % rows == 0) {
            cells = list.size() / rows;
        } else {
            cells = (list.size() / rows) + 1;
        }
        int[][] array = new int[rows][cells];

        Iterator<Integer> iterator = list.iterator();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                }
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int[] x : list) {
            for (int y : x) {
                integers.add(y);
            }
        }
        return integers;
    }
}
