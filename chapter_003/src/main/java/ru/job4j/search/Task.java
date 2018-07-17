package ru.job4j.search;

public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{"
                + "desc='" + desc + '\''
                + ", priority=" + priority
                + '}';
    }
}
