package ru.job4j.tracker.collection;

import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int columns) {
        int rows = (int) Math.ceil((double) list.size() / columns);
        int[][] array = new int[rows][columns];
        int row = 0, column = 0;
        for (int num: list) {
            array[row][column] = num;
            column++;
            if (column == columns) {
                row++;
                column = 0;
            }
        }
        return array;
    }
}
