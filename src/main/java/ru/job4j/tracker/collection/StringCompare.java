package ru.job4j.tracker.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int lenght = (Integer.compare(left.length(), right.length()) <= 0) ? left.length() : right.length();
        for (int index = 0; index < lenght; index++) {
            if (Character.compare((left.charAt(index)), right.charAt(index)) != 0) {
                 return Character.compare((left.charAt(index)), right.charAt(index));
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
