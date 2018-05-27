package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class MergeSortedTest {
    @Test
    public void whenTwoUnsortedArraysThenOneSorted() {
        int[] first = {1, 4, 6, 7, 10};
        int[] second = {-1, 3, 4, 5, 16};
        int[] expected = {-1, 1, 3, 4, 4, 5, 6, 7, 10, 16};
        int[] actual = new MergeSorted().merge(first, second);
        assertThat(actual, is(expected));
    }
}
