package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void setStdOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenTwoTasksExistsThenTwoIsShown() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("foo", "moon"));
        tracker.add(new Item("bar", "coon"));
        StubInput stubInput = new StubInput(new String[]{"1", "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(
                new String(this.out.toByteArray())
                        .contains(
                                new StringBuilder()
                                        .append(tracker.getAll().get(0).toString())
                                        .append(System.lineSeparator())
                                        .append(tracker.getAll().get(1).toString()).toString()
                        ),
                is(
                        true
                ));
    }

    @Test
    public void whenAskTaskThenItIsShown() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("foo", "moon"));
        tracker.getAll().get(0).setId("foorba");
        StubInput stubInput = new StubInput(new String[]{"4", "foorba", "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(
                new String(this.out.toByteArray())
                        .contains(
                                new StringBuilder()
                                        .append(tracker.getAll().get(0).toString())
                                        .toString()
                        ),
                is(
                        true
                )
        );
    }

    @Test
    public void whenRequestTaskByNameThenAllNamesIsShown() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("foondo", "moon"));
        tracker.add(new Item("foockup", "goon"));
        tracker.add(new Item("barza", "goon"));
        StubInput stubInput = new StubInput(new String[]{"5", "foo", "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(
                new String(this.out.toByteArray())
                        .contains(
                                new StringBuilder()
                                        .append(tracker.getAll().get(0).toString())
                                        .append(System.lineSeparator())
                                        .append(tracker.getAll().get(1).toString())
                                        .toString()
                        ),
                is(
                        true
                )
        );
        assertThat(
                new String(this.out.toByteArray())
                        .contains(
                                new StringBuilder()
                                        .append(tracker.getAll().get(2).toString())
                                        .toString()
                        ),
                is(
                        false
                )
        );
    }

    @Test
    public void whenAddTaskThenItIsAdded() {
        Tracker tracker = new Tracker();
        StubInput stubInput = new StubInput(new String[]{"0", "foo", "bar", "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(tracker.getAll().size(), is(1));
        assertThat(tracker.getAll().get(0).getDescription(), is("bar"));
    }

    @Test
    public void whenDeleteTaskThenTrackerIsEmpty() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("foo", "baz"));
        String id = tracker.getAll().get(0).getId();
        StubInput stubInput = new StubInput(new String[]{"3", id, "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(tracker.getAll(), is(empty()));
    }

    @Test
    public void whenEditTaskThenTaskHasNewNameAndDescription() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("foo", "baz"));
        String id = tracker.getAll().get(0).getId();
        StubInput stubInput = new StubInput(new String[]{"2", id, "fan", "bazar", "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("fan"));
        assertThat(tracker.getAll().get(0).getDescription(), is("bazar"));
    }
}