package ru.job4j.tracker.collection;

import java.util.List;
import java.util.HashSet;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> result = new HashSet<>();
        for (Task element: list) {
            result.add(element.getNumber());
        }
        return result;
    }
}
