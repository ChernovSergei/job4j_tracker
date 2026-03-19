package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUIMockitoTest {

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        String ln = System.lineSeparator();
        ReplaceAction replaceAction = new ReplaceAction(output);
        String replacedName = "New item name";

        tracker.add(new Item("Replaced item"));
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        replaceAction.execute(input, tracker);

        assertThat(output.toString()).isEqualTo("== Replace Item ==" + ln
        + "The request had been updated successfully" + ln);
    }

    @Test
    public void whenItemWasReplacedUnsuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        String ln = System.lineSeparator();
        ReplaceAction replaceAction = new ReplaceAction(output);

        tracker.add(new Item("Replaced item"));
        replaceAction.execute(input, tracker);

        assertThat(output.toString()).isEqualTo("== Replace Item ==" + ln
                + "Error. There is no such id in the archive" + ln);
    }

    @Test
    public void whenItemFoundById() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        String ln = System.lineSeparator();
        FindIDAction findIDAction = new FindIDAction(output);

        tracker.add(new Item("new item"));
        when(input.askInt(any(String.class))).thenReturn(1);
        findIDAction.execute(input, tracker);

        assertThat(output.toString()).startsWith("== Find request by id ==" + ln
        + "Item{id=1, name='new item', created");
    }

    @Test
    public void whenItemNotFoundById() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        String ln = System.lineSeparator();
        FindIDAction findIDAction = new FindIDAction(output);

        tracker.add(new Item("new item"));
        when(input.askInt(any(String.class))).thenReturn(2);
        findIDAction.execute(input, tracker);

        assertThat(output.toString()).isEqualTo("== Find request by id ==" + ln
                + "Error. There is no request with such id." + ln);
    }

    @Test
    public void whenItemFoundByName() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        String ln = System.lineSeparator();
        String searchName = "new item";
        FindNameAction findNameAction = new FindNameAction(output);

        tracker.add(new Item(searchName));
        when(input.askStr(any(String.class))).thenReturn(searchName);
        findNameAction.execute(input, tracker);

        assertThat(output.toString()).startsWith("== Find items by name ==" + ln
                + "Item{id=1, name='" + searchName + "', created=");
    }

    @Test
    public void whenItemNotFoundByName() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        String ln = System.lineSeparator();
        String searchName = "old item";
        FindNameAction findNameAction = new FindNameAction(output);

        tracker.add(new Item("new item"));
        when(input.askStr(any(String.class))).thenReturn(searchName);
        findNameAction.execute(input, tracker);

        assertThat(output.toString()).isEqualTo("== Find items by name ==" + ln
                + "Error. There aren't requests with \"" + searchName
                + "\" name." + ln);
    }

    @Test
    public void whenItemDeleted() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        String ln = System.lineSeparator();
        DeleteAction deleteAction = new DeleteAction(output);

        tracker.add(new Item("new item"));
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);

        assertThat(output.toString()).isEqualTo("== Delete request ==" + ln
                + "The item had been successfully deleted" + ln);
    }

    @Test
    public void whenDeletedItemNotFound() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        String ln = System.lineSeparator();
        DeleteAction deleteAction = new DeleteAction(output);

        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);

        assertThat(output.toString()).isEqualTo("== Delete request ==" + ln
                + "ERROR! There is no such item id to delete. Enter correct id" + ln);
    }
}
