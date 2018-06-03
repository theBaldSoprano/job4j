package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenReplaceThenGetNew() {
        Item firstItem = new Item("234234");
        Item secondItem = new Item("foo", "azaza");
        Item thirdItem = new Item("bar");
        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        String id = tracker.getAll()[1].getId();
        tracker.replace(id, new Item("bazaa", "lol"));
        assertThat(tracker.getAll()[1].getName(), is("bazaa"));
    }

    @Test
    public void whenDeleteItemThenItIsRemoved() {
        Item firstItem = new Item("234234");
        Item secondItem = new Item("foo");
        Item thirdItem = new Item("bar");
        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertThat(tracker.getAll()[1].getId(), is(secondItem.getId()));
        tracker.delete(secondItem.getId());
        assertThat(tracker.getAll()[1].getId(), is(thirdItem.getId()));
    }

    @Test
    public void whenSelectByNameThenGetOnlyThatName() {
        Item firstItem = new Item("234234", "foon");
        Item secondItem = new Item("foo", "foof");
        Item thirdItem = new Item("bar", "bar");
        Item fourthItem = new Item("barfoo", "baz");
        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.add(fourthItem);
        Item[] result = tracker.findByName("foo");
        assertThat(result.length, is(2));
        assertThat(result[0].getDescription(), is("foof"));
        assertThat(result[1].getDescription(), is("baz"));
    }

    @Test
    public void whenRequestSpecifiedIdThenGetIt() {
        Item firstItem = new Item("234234", "foo");
        Item secondItem = new Item("foo", "foo");
        Item thirdItem = new Item("bar", "bar");
        Item fourthItem = new Item("bar", "baz");
        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.add(fourthItem);

        Item result = tracker.findById(secondItem.getId());

        assertThat(result.getId(), is(secondItem.getId()));
    }

    @Test
    public void whenRequestNotExistingIdThenGetNull() {
        Item firstItem = new Item("234234", "foo");
        Item secondItem = new Item("foo", "foo");
        Item thirdItem = new Item("bar", "bar");
        Item fourthItem = new Item("bar", "baz");
        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.add(fourthItem);

        Item result = tracker.findById("worm");

        assertThat(result, is(nullValue()));
    }
}
