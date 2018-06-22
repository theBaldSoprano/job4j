package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws NoSuchFieldException {
        Cell[] steps = new Cell[0];
        boolean rightWay = false;
        int x = source.x;
        int y = source.y;
        while (x > 0 && y > 0) {
            x--;
            y--;
        }
        for (int i = 0; i < 8; i++) {
            if (y > 7 || x > 7) {
                break;
            }
            if (x == dest.x && y == dest.y) {
                rightWay = true;
                break;
            }
            x++;
            y++;
        }
        System.out.println("here");
        if (rightWay) {
            if (source.x + source.y < dest.x + dest.y) {
                steps = new Cell[dest.x - source.x];
                x = source.x + 1;
                y = source.y + 1;
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.findByValue(x, y);
                    x++;
                    y++;
                }
            } else {
                steps = new Cell[source.x - dest.x];
                x = source.x - 1;
                y = source.y - 1;
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.findByValue(x, y);
                    x--;
                    y--;
                }
            }
            return steps;
        }
        x = source.x;
        y = source.y;
        while (x < 7 && y > 0) {
            x++;
            y--;
        }
        for (int i = 0; i < 8; i++) {
            if (y > 7 || x < 0) {
                break;
            }
            if (x == dest.x && y == dest.y) {
                rightWay = true;
                break;
            }
            x--;
            y++;
        }
        if (rightWay) {
            if (source.x < dest.x) {
                steps = new Cell[dest.x - source.x];
                x = source.x + 1;
                y = source.y - 1;
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.findByValue(x, y);
                    x++;
                    y--;
                }
            } else {
                steps = new Cell[source.x - dest.x];
                x = source.x - 1;
                y = source.y + 1;
                for (int i = 0; i < steps.length; i++) {
                    steps[i] = Cell.findByValue(x, y);
                    x--;
                    y++;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
