package ru.job4j.tracker.search;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PriorityQueueTest {

    @Test
    public void whenHighPriority() {
        PriorityQueue queue = new PriorityQueue();
        Task washEngine = new Task("Wash Engine", 1);
        Task instrumentCheck = new Task ("Check data units", 3);
        Task borescopeInspection = new Task ("Complete borescope inspection", 2);
        queue.put(washEngine);
        queue.put(instrumentCheck);
        queue.put(borescopeInspection);
        Task result = queue.take();
        assertThat(result.getDest(), is("Wash Engine"));
    }
}
