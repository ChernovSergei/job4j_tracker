package ru.job4j.tracker.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] el1 = o1.split("/");
        String[] el2 = o2.split("/");
        int lenghtMin = Math.min(el1.length, el2.length);
        int result = 0;

        for (int i = 0; i < lenghtMin; i++) {
            if (i == 0) {
                result = el2[i].compareTo(el1[i]);
            } else if (result == 0) {
                result = el1[i].compareTo(el2[i]);
            }
        }

        return result != 0 ? result : ((Integer) el1.length).compareTo((Integer) el2.length);
    }
}
