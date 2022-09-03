package ru.job4j.tracker.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split("\\.");
        String[] splitRight = right.split("\\.");
        return Integer.compare(Integer.parseInt(splitLeft[0]), Integer.parseInt(splitRight[0]));
    }
}