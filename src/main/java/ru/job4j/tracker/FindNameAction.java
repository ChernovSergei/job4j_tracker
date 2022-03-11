package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "Find item by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Find items by name ==");
        String console = input.askStr("Enter request name: ");
        Item[] items = tracker.findByName(console);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Error. There aren't requests with \"" + console + "\" name.");
        }
        return true;
    }
}
