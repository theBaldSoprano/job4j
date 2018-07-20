package ru.job4j.user;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> input) {
        return new TreeSet<>(input);
    }
}
