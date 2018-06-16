package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws NoSuchFieldException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                boolean clear = true;
                for (int i = 0; i < steps.length; i++) {
                    if (findBy(steps[i]) != -1) {
                        clear = false;
                        break;
                    }
                }
                if (clear) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int i = 0; i != this.figures.length; i++) {
            if (this.figures[i] != null && this.figures[i].position().equals(cell)) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}