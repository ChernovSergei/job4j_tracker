package ru.job4j.tracker.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] el1 = o1.split("/");
        String[] el2 = o2.split("/");
        int result = el2[0].compareTo(el1[0]);
        return result != 0 ? result : o1.compareTo(o2);
    }
}
