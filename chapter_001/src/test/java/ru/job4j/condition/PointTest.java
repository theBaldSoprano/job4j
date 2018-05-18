package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class PointTest {
    @Test
    public void distanceTo() {
        Point a = new Point(-5, 5);
        Point b = new Point(44, 1);

        double result = a.distanceTo(b);

        assertThat(result, closeTo(49.1, 0.1));

    }
}
