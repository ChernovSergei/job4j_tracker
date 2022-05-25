package ru.job4j.tracker.search;

public class Task {
    private String dest;
    private int priority;

    public Task(String dest, int priority) {
        this.dest = dest;
        this.priority = priority;
    }

    public String getDest() {
        return dest;
    }

    public int getPriority() {
        return priority;
    }
}
