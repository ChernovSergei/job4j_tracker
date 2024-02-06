package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Delete request ==");
        int console = input.askInt("Enter id to delete required request: ");
        if (tracker.findById(console) != null) {
            tracker.delete(console);
            out.println("The item had been successfully deleted");
        } else {
            out.println("ERROR! There is no such item id to delete. Enter correct id");
        }
        return true;
    }
}
