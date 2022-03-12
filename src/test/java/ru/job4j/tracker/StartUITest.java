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
        Tracker tracker = new Tracker();
        UserAction[] action = {new CreateAction(), new ExitAction()};
        new StartUI().init(input, tracker, action);
        assertThat(tracker.findAll()[0].getName(), is("Create Item"));
    }

    @Test
    public void whenReplaceAction() {
        Tracker tracker = new Tracker();
        Item item = new Item("Replaced Item");
        tracker.add(item);
        String[] answers = {"1", item.getName(), "1"};
        Input input = new StubInput(answers);
        UserAction[] action = {new ReplaceAction(), new ExitAction()};
        new StartUI().init(input, tracker, action);
        assertThat(tracker.findById(item.getId()).getName(), is("Replaced Item"));
    }

    @Test
    public void whenDeleteAction() {
        Tracker tracker = new Tracker();
        Item item = new Item("Item to delete");
        tracker.add(item);
        String[] answers = {"0", "1", "1"};
        Input input = new StubInput(answers);
        UserAction[] action = {new DeleteAction(), new ExitAction()};
        new StartUI().init(input, tracker, action);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}