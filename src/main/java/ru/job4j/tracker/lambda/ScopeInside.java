package ru.job4j.tracker.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        total = add(() -> {
                    int subTotal = 0;
                    for (Integer num : number) {
                        subTotal = subTotal + num;
                    }
                    return subTotal;
                }
                );
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
