package ru.job4j.tracker.array;

public class JavaNameValidator {
    public static boolean isNameValid(String name) {
        boolean result = false;
        if (name.length() > 0 && isLowerLatinLetter(name.charAt(0))) {
                result = name.chars()
                        .allMatch(i -> isSpecialSymbol(i)
                                || isUpperLatinLetter(i)
                                || isLowerLatinLetter(i)
                                || Character.isDigit(i));
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
