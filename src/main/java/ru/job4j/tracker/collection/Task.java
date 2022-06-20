package ru.job4j.tracker.collection;

import java.util.HashSet;

public class Task {
    String number;
    String taskDescription;

    public Task(String number, String taskDescription) {
        this.number = number;
        this.taskDescription = taskDescription;
    }

    public String getNumber() {
        return number;
    }
}
