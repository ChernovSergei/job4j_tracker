package ru.job4j.tracker;

import java.util.ArrayList;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Find items by name ==");
        String console = input.askStr("Enter request name: ");
        ArrayList<Item> items = tracker.findByName(console);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Error. There aren't requests with \"" + console + "\" name.");
        }
        return true;
    }
}
