package ru.job4j.tracker;

public class FindIDAction implements UserAction {
    @Override
    public String name() {
        return "Find item by ID.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Find request by id ==");
        int console = input.askInt("Enter request id to get its information: ");
        Item item = tracker.findById(console);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Error. There is no request with such id.");
        }
        return true;
    }
}
