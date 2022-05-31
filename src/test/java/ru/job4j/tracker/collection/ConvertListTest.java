package ru.job4j.tracker.collection;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertListTest {

    @Test
    public void whenTwoLists() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[]{1, 2});
        in.add(new int[]{3, 4, 5});
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(ConvertList.convert(in), is(result));
    }
}
