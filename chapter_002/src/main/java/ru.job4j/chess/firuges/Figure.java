package ru.job4j.chess.firuges;

public interface Figure {

    Cell position();

    Figure copy(Cell dest);

    Cell[] way(Cell source, Cell dest) throws NoSuchFieldException;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }
}
