package ru.job4j.tracker;

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
        Item[] items = tracker.findByName(console);
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Error. There aren't requests with \"" + console + "\" name.");
        }
        return true;
    }
}
