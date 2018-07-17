package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertThreeThenAsExpected() {
        List<int[]> ints = new ArrayList<>();
        ints.add(new int[]{3, 66, 2});
        ints.add(new int[]{8});
        ints.add(new int[]{11, -3, -44, 0});
        List<Integer> actual;
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(66);
        expected.add(2);
        expected.add(8);
        expected.add(11);
        expected.add(-3);
        expected.add(-44);
        expected.add(0);

        actual = new ConvertList2Array().convert(ints);

        assertThat(actual, is(expected));
    }
}