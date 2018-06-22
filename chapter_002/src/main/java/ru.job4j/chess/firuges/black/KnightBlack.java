package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Random;

public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] way = new Cell[0];
        System.out.println("---------------------------------------");
        System.out.println("source is " + source);
        System.out.println("dest is " + dest);
        if (
                (source.x == dest.x - 1 && source.y == dest.y - 2)
                        || (source.x == dest.x + 1 && source.y == dest.y - 2)
                        || (source.x == dest.x + 2 && source.y == dest.y - 1)
                        || (source.x == dest.x + 2 && source.y == dest.y + 1)
                        || (source.x == dest.x + 1 && source.y == dest.y + 2)
                        || (source.x == dest.x - 1 && source.y == dest.y + 2)
                        || (source.x == dest.x - 2 && source.y == dest.y + 1)
                        || (source.x == dest.x - 2 && source.y == dest.y - 1)
        ) {
            way = new Cell[]{dest};
            char c = (char) (new Random().nextInt(300));
            System.out.println("here knight " + c);
        }

        return way;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
