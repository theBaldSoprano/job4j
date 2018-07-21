package ru.job4j.comparator;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        left = left.toLowerCase();
        right = right.toLowerCase();
        int cap;
        if (left.length() < right.length()) {
            cap = left.length();
        } else {
            cap = right.length();
        }
        for (int i = 0; i < cap; i++) {
            if (left.charAt(i) < right.charAt(i)) {
                return -1;
            } else if (left.charAt(i) > right.charAt(i)) {
                return 1;
            }
        }
        if (left.length() == right.length()) {
            return 0;
        }
        if (left.length() < right.length()) {
            return -1;
        } else {
            return 1;
        }
    }
}