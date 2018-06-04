package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddTaskThenItIsAdded() {
        Tracker tracker = new Tracker();
        StubInput stubInput = new StubInput(new String[]{"0", "foo", "bar", "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(tracker.getAllNotNull().length, is(1));
        assertThat(tracker.getAll()[0].getDescription(), is("bar"));
    }

    @Test
    public void whenDeleteTaskThenTrackerIsEmpty() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("foo", "baz"));
        String id = tracker.getAllNotNull()[0].getId();
        StubInput stubInput = new StubInput(new String[]{"3", id, "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(tracker.getAllNotNull(), is(emptyArray()));
    }

    @Test
    public void whenEditTaskThenTaskHasNewNameAndDescription() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("foo", "baz"));
        String id = tracker.getAllNotNull()[0].getId();
        StubInput stubInput = new StubInput(new String[]{"2", id, "fan", "bazar", "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(tracker.getAllNotNull()[0].getName(), is("fan"));
        assertThat(tracker.getAllNotNull()[0].getDescription(), is("bazar"));
    }
}