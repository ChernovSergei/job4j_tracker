package ru.job4j.tracker.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originalText, String duplicateText) {
       boolean result = true;
       String[] origin = originalText.split(" ");
       String[] duplicate = duplicateText.split(" ");
       HashSet<String> check = new HashSet<>();
       for (String originWord : origin) {
           check.add(originWord);
       }
        for (String duplicateWord : duplicate) {
            if (!check.contains(duplicateWord)) {
                result = false;
                return result;
            }
        }
        return result;
    }
}
