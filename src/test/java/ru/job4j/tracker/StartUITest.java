package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        String[] answers = {"0", "Create Item", "1"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] action = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, action);
        assertThat(tracker.findAll()[0].getName(), is("Create Item"));
    }

    @Test
    public void whenReplaceAction() {
        Tracker tracker = new Tracker();
        Item item = new Item("Replaced Item");
        String[] answers = {"1", item.getName(), "1"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        tracker.add(item);
        UserAction[] action = {new ReplaceAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, action);
        assertThat(tracker.findById(item.getId()).getName(), is("Replaced Item"));
    }

    @Test
    public void whenDeleteAction() {
        String[] answers = {"0", "1", "1"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Item to delete");
        tracker.add(item);
        UserAction[] action = {new DeleteAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, action);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Item item = new Item("Item to replace");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "Replaced item", "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        UserAction[] actions = {new ReplaceAction(out), new ExitAction(out)};
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:"
                + "0. Replace item."
                + "1. Exit."
                + "== Replace Item =="
                + "The request had been updated successfully"
                + "Menu:"
                + "0. Replace item."
                + "1. Exit."
                + "== Exit =="
        ));
    }
}