package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] actual = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        actual = bubbleSort.sort(actual);
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSortArrayWithOneElementThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] actual = {1};
        actual = bubbleSort.sort(actual);
        int[] expected = {1};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSortArrayWithNegativeElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] actual = {1, -7, -4, 2, -44};
        actual = bubbleSort.sort(actual);
        int[] expected = {-44, -7, -4, 1, 2};
        assertThat(actual, is(expected));
    }
}
