package ru.job4j.condition;

import java.util.Objects;

/**
 * @author Gregory
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates distance from one point
     * to another.
     *
     * @param that
     * @return
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow((double) (this.x - that.x), 2) + Math.pow((double) (this.y - that.y), 2)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
