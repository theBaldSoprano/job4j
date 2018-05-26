package ru.job4j.condition;

import java.util.function.BiPredicate;

public class Segment {
    private int start;
    private int end;

    public Segment(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isCrossing(Segment that) {
        return
                this.test(that, (first, second) -> first.end >= second.start)
                        && this.test(that, (first, second) -> first.start <= second.end);
    }

    private boolean test(Segment second, BiPredicate<Segment, Segment> predicate) {
        return predicate.test(this, second);
    }
}
