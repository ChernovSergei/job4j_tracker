package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> rsl = new ArrayList<>();
        int count = 0;
        for (Item testItem: items) {
            if (testItem.getName().equals(key)) {
                rsl.add(testItem);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        Item result = null;
        for (Item test: items) {
            if (test.getId() == id) {
                result = test;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        Item test = findById(id);
        int index;
        if (test != null) {
            index = items.indexOf(test);
            item.setId(id);
            items.set(index, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        Item test = findById(id);
        int index;
        if (test != null) {
            index = items.indexOf(test);
            items.remove(index);
            return true;
        }
        return false;
    }
}