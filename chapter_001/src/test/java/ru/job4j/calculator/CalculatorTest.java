package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOneToOne_ThenTwo() {
        //arrange
        Calculator calculator = new Calculator();
        double expected = 2d;
        double actual;
        //act
        calculator.add(1d, 1d);
        actual = calculator.getResult();
        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSubtractTwoFromOne_ThenMinusOne() {
        //arrange
        Calculator calculator = new Calculator();
        double expected = -1d;
        double actual;
        //act
        calculator.subtract(1d, 2d);
        actual = calculator.getResult();
        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void whenDivideSixByTwo_ThenThree() {
        //arrange
        Calculator calculator = new Calculator();
        double expected = 3d;
        double actual;
        //act
        calculator.div(6d, 2d);
        actual = calculator.getResult();
        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void whenMultiplySixAndTwo_ThenTwelve() {
        //arrange
        Calculator calculator = new Calculator();
        double expected = 12d;
        double actual;
        //act
        calculator.multiply(6d, 2d);
        actual = calculator.getResult();
        //assert
        assertThat(actual, is(expected));
    }
}

