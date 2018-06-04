package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        StringBuilder sb = new StringBuilder();
        sb.append("   /\\");
        sb.append(System.lineSeparator());
        sb.append("  /  \\");
        sb.append(System.lineSeparator());
        sb.append(" /    \\");
        sb.append(System.lineSeparator());
        sb.append("/______\\");
        assertThat(
                triangle.draw(),
                is(sb.toString())
        );
    }
}
