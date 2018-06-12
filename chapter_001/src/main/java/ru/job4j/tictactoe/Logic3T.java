package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Argument who represents who to check.
     * True is for X.
     * False is for O.
     *
     * @param who
     * @return
     */
    public boolean isWinner(boolean who) {
        boolean result = true;
        // Check all rows.
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMark(who)) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return result;
            }
            result = true;
        }
        // Check all columns.
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[j][i].hasMark(who)) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return result;
            }
            result = true;
        }
        // Check diagonals.
        for (int i = 0; i < table.length; i++) {
            if (!table[i][i].hasMark(who)) {
                result = false;
                break;
            }
        }
        if (result) {
            return result;
        }
        result = true;
        for (int i = 0; i < table.length; i++) {
            if (!table[i][table.length - 1 - i].hasMark(who)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean hasGap() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (!table[i][j].hasMark(true) && !table[i][j].hasMark(false)) {
                    return true;
                }
            }
        }
        return false;
    }
}