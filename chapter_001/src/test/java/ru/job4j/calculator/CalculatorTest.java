package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOneToOneThenTwo() {
        Calculator calculator = new Calculator();
        double expected = 2d;
        double actual;
        calculator.add(1d, 1d);
        actual = calculator.getResult();
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSubtractTwoFromOneThenMinusOne() {
        Calculator calculator = new Calculator();
        double expected = -1d;
        double actual;
        calculator.subtract(1d, 2d);
        actual = calculator.getResult();
        assertThat(actual, is(expected));
    }

    @Test
    public void whenDivideSixByTwoThenThree() {
        Calculator calculator = new Calculator();
        double expected = 3d;
        double actual;
        calculator.div(6d, 2d);
        actual = calculator.getResult();
        assertThat(actual, is(expected));
    }

    @Test
    public void whenMultiplySixAndTwoThenTwelve() {
        Calculator calculator = new Calculator();
        double expected = 12d;
        double actual;
        calculator.multiply(6d, 2d);
        actual = calculator.getResult();
        assertThat(actual, is(expected));
    }
}

