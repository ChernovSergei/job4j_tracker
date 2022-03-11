package ru.job4j.tracker;

import java.lang.module.FindException;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select item:");
            if (select >= 0 && select < 7) {
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } else {
                System.out.println("Error. You put wrong number");
            }
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindIDAction(),
                new FindNameAction(),
                new ExitAction(),
        };
        new StartUI().init(input, tracker, actions);
    }
}
