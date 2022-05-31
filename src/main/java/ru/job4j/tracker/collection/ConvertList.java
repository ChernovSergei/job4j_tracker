package ru.job4j.tracker.collection;

import java.util.List;
import java.util.ArrayList;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array: list) {
            for (int element: array) {
                result.add(element);
            }
        }
        return result;
    }
}
