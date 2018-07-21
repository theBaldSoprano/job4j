package ru.job4j.user;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    /**
     * Returns set of users sorted by age.
     *
     * @param input
     * @return
     */
    public Set<User> sort(List<User> input) {
        return new TreeSet<>(input);
    }

    /**
     * Sorts Users by name length.
     *
     * @param in
     * @return
     */
    public List<User> sortNameLength(List<User> in) {
        in.sort(Comparator.comparing(u -> u.getName().length()));
        return in;
    }
}
