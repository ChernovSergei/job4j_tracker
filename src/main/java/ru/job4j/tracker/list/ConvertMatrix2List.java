package ru.job4j.tracker.list;

import java.util.List;
import java.util.ArrayList;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell: row) {
                list.add(cell);
            }
        }
        return list;
    }
}
