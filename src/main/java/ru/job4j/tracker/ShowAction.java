package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Show all items ==");
        ArrayList<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Error. The archive doesn't have any requests");
        }
        return true;
    }
}
