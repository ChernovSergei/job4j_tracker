package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Delete request ==");
        int console = input.askInt("Enter id to delete required request: ");
        if (tracker.delete(console)) {
            System.out.println("Selected request has been deleted successfully.");
        } else {
            System.out.println("Error. There is no request with such id.");
        }
        return true;
    }
}
