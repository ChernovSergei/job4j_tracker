package ru.job4j.tracker.collection;



import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FullSearchTest {
    @Test
    public void extractNumberTest() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "multiply"),
                new Task("2", "divide"),
                new Task("1", "multiply")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }
}
