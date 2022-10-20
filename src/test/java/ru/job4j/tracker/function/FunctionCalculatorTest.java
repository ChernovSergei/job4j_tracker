package ru.job4j.tracker.function;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import java.lang.Math;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diaposon(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diaposon(5, 8, x ->  Math.pow(x, 2) + 2 * x + 1);
        List<Double> expected = Arrays.asList(36D, 49D, 64D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExpFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diaposon(5, 8, x ->  Math.pow(2, x+1));
        List<Double> expected = Arrays.asList(64D, 128D, 256D);
        assertThat(result).containsAll(expected);
    }
}
