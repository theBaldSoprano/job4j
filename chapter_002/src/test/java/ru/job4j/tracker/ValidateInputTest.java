package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInputThenErrorMessage() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1", "2", "3"})
        );
        input.ask("", new int[]{1, 2, 3});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter valid number -> Must be a number of action from menu%n")
                )
        );
    }

    @Test
    public void whenOutOfMenuRangeThenErrorMessage() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"2", "1"})
        );
        input.ask("", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("No such number in menu%n")
                )
        );
    }
}