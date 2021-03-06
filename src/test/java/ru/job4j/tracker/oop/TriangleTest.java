package ru.job4j.tracker.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point first = new Point(0, 0);
        Point second = new Point(4, 0);
        Point third = new Point(0, 4);
        Triangle triangle = new Triangle(first, second, third);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void when00and100and00ThenMinus1() {
        Point first = new Point(0, 0);
        Point second = new Point(10, 0);
        Point third = new Point(0, 0);
        Triangle triangle = new Triangle(first, second, third);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }
}