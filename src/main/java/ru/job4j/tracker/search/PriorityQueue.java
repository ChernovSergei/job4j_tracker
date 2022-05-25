package ru.job4j.tracker.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element: tasks) {
            index = (task.getPriority() > element.getPriority()) ? (index + 1) : index;
        }
        tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}