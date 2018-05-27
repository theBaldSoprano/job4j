package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkX()) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return result;
            }
            result = true;
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[j][i].hasMarkX()) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return result;
            }
            result = true;
        }
        for (int i = 0; i < table.length; i++) {
            if (!table[i][i].hasMarkX()) {
                result = false;
                break;
            }
        }
        if (result) {
            return result;
        }
        result = true;
        for (int i = 0; i < table.length; i++) {
            if (!table[i][table.length - 1 - i].hasMarkX()) {
                result = false;
                break;
            }
        }
        if (result) {
            return result;
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkO()) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return result;
            }
            result = true;
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[j][i].hasMarkO()) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return result;
            }
            result = true;
        }
        for (int i = 0; i < table.length; i++) {
            if (!table[i][i].hasMarkO()) {
                result = false;
                break;
            }
        }
        if (result) {
            return result;
        }
        result = true;
        for (int i = 0; i < table.length; i++) {
            if (!table[i][table.length - 1 - i].hasMarkO()) {
                result = false;
                break;
            }
        }
        if (result) {
            return result;
        }
        return result;
    }

    public boolean hasGap() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (!table[i][j].hasMarkX() && !table[i][j].hasMarkO()) {
                    return true;
                }
            }
        }
        return false;
    }
}

