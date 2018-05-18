package ru.job4j.condition;

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
}
