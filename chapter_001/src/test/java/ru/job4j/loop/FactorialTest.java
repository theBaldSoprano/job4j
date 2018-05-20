package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    private Factorial factorial = new Factorial();

    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        assertThat(factorial.calc(5), is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        assertThat(factorial.calc(0), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassLessThanZeroThenIllegalArgumentExeption(){
        factorial.calc(-1);
    }
}
