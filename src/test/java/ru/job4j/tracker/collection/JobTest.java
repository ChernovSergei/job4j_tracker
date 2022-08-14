package ru.job4j.tracker.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void ascByName() {
        Comparator<Job> ascName = new JobAscByName();
        int rsl = ascName.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void desByName() {
        Comparator<Job> desName = new JobDescByName();
        int rsl = desName.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void ascByPriority() {
        Comparator<Job> ascPriority = new JobAscByPriority();
        int rsl = ascPriority.compare(
                new Job("A", 1),
                new Job("B", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void desByPriority() {
        Comparator<Job> desPriority = new JobDescByPriority();
        int rsl = desPriority.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void equalNameByPriority() {
        Comparator<Job> equalNamePriority = new JobAscByPriority().thenComparing(new JobAscByPriority());
        int rsl = equalNamePriority.compare(
                new Job("A", 1),
                new Job("A", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void equalPriorityByName() {
        Comparator<Job> equalPriorityName = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = equalPriorityName.compare(
                new Job("Z", 2),
                new Job("A", 2)
        );
        assertThat(rsl).isLessThan(0);
    }
}
