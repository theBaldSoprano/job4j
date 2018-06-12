package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure3T() {
    }

    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Argument mark:
     * true is for X
     * false is for O.
     *
     * @param mark
     * @return
     */
    public boolean hasMark(boolean mark) {
        if (mark) {
            return this.markX;
        } else {
            return this.markO;
        }
    }
}
