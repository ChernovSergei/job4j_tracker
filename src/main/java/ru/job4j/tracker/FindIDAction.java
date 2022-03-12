package ru.job4j.tracker;

public class FindIDAction implements UserAction {
    private final Output out;

    public FindIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by ID.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Find request by id ==");
        int console = input.askInt("Enter request id to get its information: ");
        Item item = tracker.findById(console);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Error. There is no request with such id.");
        }
        return true;
    }
}
