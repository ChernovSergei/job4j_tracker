package ru.job4j.tracker.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {
    public List<Double> diaposon(int start, int end, Function<Double, Double> func) {
        Double result;
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
             result = func.apply(Double.valueOf(i));
             list.add(result);
        }
        return list;
    }
}
