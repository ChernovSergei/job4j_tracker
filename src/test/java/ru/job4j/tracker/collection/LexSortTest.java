package ru.job4j.tracker.collection;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input =  {
                "10. Task.",
                "2.3. Task.",
                "2.1. Task."
        };
        String[] out = {
                "2.1. Task.",
                "2.3. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(out);
    }
}
