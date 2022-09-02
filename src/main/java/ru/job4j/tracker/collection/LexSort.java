package ru.job4j.tracker.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    public static boolean isNumertic(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split("\\.");
        String[] splitRight = right.split("\\.");
        int result = 0;
        for (int i = 0; i < splitLeft.length; i++) {
            if (isNumertic(splitLeft[i]) && isNumertic(splitRight[i])) {
                result = Integer.compare(Integer.parseInt(splitLeft[i]), Integer.parseInt(splitRight[i]));
            } else if (isNumertic(splitLeft[i])) {
                result = 1;
            } else if (isNumertic(splitRight[i])) {
                result = -1;
            }
            if (result != 0) {
                return result;
            }
        }
        return result;
    }
}