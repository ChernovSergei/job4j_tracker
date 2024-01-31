package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.util.List;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Store tracker = new MemTracker();
        String[] answers = {"0", "Create Item", "1"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        List<UserAction> action = List.of(new CreateAction(output), new ExitAction(output));
        new StartUI(output).init(input, tracker, action);
        assertThat(tracker.findAll().get(0).getName(), is("Create Item"));
    }

    @Test
    public void whenReplaceAction() {
        Store tracker = new MemTracker();
        Item item = new Item("Original name");
        tracker.add(item);
        String replacedName = "Replaced name";
        String[] answers = {"0", String.valueOf(item.getId()), replacedName, "1"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        List<UserAction> action = List.of(new ReplaceAction(output), new ExitAction(output));
        new StartUI(output).init(input, tracker, action);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteAction() {
        Store tracker = new MemTracker();
        Item item = new Item("Item to delete");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        List<UserAction> action = List.of(new DeleteAction(output), new ExitAction(output));
        new StartUI(output).init(input, tracker, action);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Store tracker = new MemTracker();
        Item item = new Item("New Name");
        tracker.add(item);
        String replacedItem = "Replaced name";
        String[] answers = {"0", String.valueOf(item.getId()), replacedItem, "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new ReplaceAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                + "0. Replace item." + ln
                + "1. Exit." + ln
                + "== Replace Item ==" + ln
                + "The request had been updated successfully" + ln
                + "Menu:" + ln
                + "0. Replace item." + ln
                + "1. Exit." + ln
                + "== Exit ==" + ln
        ));
    }

    @Test
    public void whenFindAllActionTestOutputIsSuccessfully() {
        Store tracker = new MemTracker();
        Output result = new StubOutput();
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));
        Item third = tracker.add(new Item("third"));
        result.println(first);
        result.println(second);
        result.println(third);
        String itemNames = result.toString();
        String[] answers = {"0", "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new ShowAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show items." + ln
                        + "1. Exit." + ln
                        + "== Show all items ==" + ln
                        + itemNames
                        + "Menu:" + ln
                        + "0. Show items." + ln
                        + "1. Exit." + ln
                        + "== Exit ==" + ln
        ));
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        String targetName = "second";
        Store tracker = new MemTracker();
        Output result = new StubOutput();
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item(targetName));
        Item third = tracker.add(new Item("third"));
        result.println(second);
        String itemName = result.toString();
        String[] answers = {"0", targetName, "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new FindNameAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String output = out.toString();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by name." + ln
                        + "1. Exit." + ln
                        + "== Find items by name ==" + ln
                        + itemName
                        + "Menu:" + ln
                        + "0. Find item by name." + ln
                        + "1. Exit." + ln
                        + "== Exit ==" + ln
        ));
    }

    @Test
    public void whenFindByIdActionTestOutputIsSuccessfully() {
        String targetName = "second";
        Store tracker = new MemTracker();
        Output result = new StubOutput();
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));
        Item third = tracker.add(new Item("third"));
        result.println(second);
        String itemName = result.toString();
        String[] answers = {"0", String.valueOf(second.getId()), "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        List<UserAction> actions = List.of(new FindIDAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String output = out.toString();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by ID." + ln
                        + "1. Exit." + ln
                        + "== Find request by id ==" + ln
                        + itemName
                        + "Menu:" + ln
                        + "0. Find item by ID." + ln
                        + "1. Exit." + ln
                        + "== Exit ==" + ln
        ));
    }
}