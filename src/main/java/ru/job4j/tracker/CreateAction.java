package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Create a new item ==");
        String name = input.askStr("Enter item name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("The request had been added - " + item);
        return true;
    }
}
