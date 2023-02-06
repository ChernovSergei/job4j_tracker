package ru.job4j.tracker.array;

public class JavaNameValidator {
    public static boolean isNameValid(String name) {
        boolean result = true;
        if (name.length() == 0 || !isLowerLatinLetter(name.charAt(0))) {
                result = false;
        } else {
                result = name.chars()
                        .skip(1)
                        .noneMatch(i -> !isSpecialSymbol(i)
                                && !isUpperLatinLetter(i)
                                && !isLowerLatinLetter(i)
                                && !Character.isDigit(i));
        }
        return result;
    }

    public static boolean isSpecialSymbol(int code) {
        return code == 36 || code == 95;
    }

    public static boolean isUpperLatinLetter(int code) {
        return code >= 65 && code <= 90;
    }

    public static boolean isLowerLatinLetter(int code) {
        return code >= 97 && code <= 122;
    }
}
