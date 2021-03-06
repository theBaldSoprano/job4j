package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlternativePaintTest {
    @Test
    public void whenPyramidIs2ThenItMatchesThePattern() {
        AlternativePaint paint = new AlternativePaint();
        String rst = paint.pyramid(2);
        assertThat(rst,
                is(
                        " ^ " + System.lineSeparator()
                                + "^^^"

                )
        );
    }

    @Test
    public void whenPyramid4() {
        AlternativePaint paint = new AlternativePaint();
        String rst = paint.pyramid(4) + System.lineSeparator();
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }
}
