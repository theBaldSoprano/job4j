package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private int key;
    private String info;

    public BaseAction(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
}
