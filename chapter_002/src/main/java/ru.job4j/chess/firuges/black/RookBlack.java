package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Random;

public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws NoSuchFieldException {
        Cell[] steps = new Cell[0];
        if (source.x != dest.x && source.y == dest.y) {
            System.out.println("me in X");
            steps = new Cell[Math.abs(source.x - dest.x)];
            int index = 0;
            if (source.x < dest.x) {
                for (int i = source.x + 1; i <= dest.x; i++) {
                    steps[index] = Cell.findByValue(i, source.y);
                    index++;
                }
            } else {
                for (int i = source.x - 1; i >= dest.x; i--) {
                    steps[index] = Cell.findByValue(i, source.y);
                    index++;
                }
            }
        } else if (source.x == dest.x && source.y != dest.y) {
            System.out.println("me in Y");
            steps = new Cell[Math.abs(source.y - dest.y)];
            System.out.println("steps size is " + steps.length);
            int index = 0;
            if (source.y < dest.y) {
                for (int i = source.y + 1; i <= dest.y; i++) {
                    steps[index] = Cell.findByValue(source.x, i);
                    index++;
                }
            } else {
                for (int i = source.y - 1; i >= dest.y; i--) {
                    steps[index] = Cell.findByValue(source.x, i);
                    index++;
                }
            }
            System.out.println(Arrays.toString(steps));
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
