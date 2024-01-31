package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace item.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Replace Item ==");
        int id = input.askInt("Enter id to replace request: ");
        String name = input.askStr("Enter new request: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            out.println("The request had been updated successfully");
        } else {
            out.println("Error. There is no such id in the archive");
        }
        return true;
    }
}
