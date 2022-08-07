package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SortItems {
    @Test
    public void ascendant() {
        List<Item> items = new ArrayList<Item>();
        List<Item> expected = new ArrayList<Item>();
        items.add(new Item("Z", 1));
        items.add(new Item("P", 2));
        items.add(new Item("A", 3));
        items.add(new Item("Y", 4));
        expected.add(new Item("A", 3));
        expected.add(new Item("P", 2));
        expected.add(new Item("Y", 4));
        expected.add(new Item("Z", 1));
        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    public void descending() {
        List<Item> items = new ArrayList<Item>();
        List<Item> expected = new ArrayList<Item>();
        items.add(new Item("Z", 1));
        items.add(new Item("P", 2));
        items.add(new Item("A", 3));
        items.add(new Item("Y", 4));
        expected.add(new Item("Z", 1));
        expected.add(new Item("Y", 4));
        expected.add(new Item("P", 2));
        expected.add(new Item("A", 3));
        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}
