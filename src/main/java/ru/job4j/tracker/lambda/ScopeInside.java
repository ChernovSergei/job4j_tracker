package ru.job4j.tracker.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            total = add(total, () -> num);
        }
        System.out.println(total);
    }

    private static Integer add(Integer sum, Supplier<Integer> calc) {
        return sum + calc.get();
    }
}
