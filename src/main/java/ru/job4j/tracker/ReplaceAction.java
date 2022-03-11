package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Replace Item ==");
        int id = input.askInt("Enter id to replace request: ");
        String name = input.askStr("Enter new request: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("The request had been updated successfully");
        } else {
            System.out.println("Error. There is no such id in the archive");
        }
        return true;
    }
}
