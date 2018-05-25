package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] test = {"foo", "foo", "bar", "too", "baz", "foo", "bar", "baz", "bar", "foo", "bar", "baz"};
        String[] actual = new ArrayDuplicate().remove(test);
        String[] expected = {"foo", "bar", "too", "baz"};
        assertThat(actual, is(expected));
    }
}
