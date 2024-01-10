package ru.job4j.tracker.action;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.inpute.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.repo.MemTracker;
import ru.job4j.tracker.repo.Store;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EditActionTest {

    @Test
    public void whenItemWasEditSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction replaceAction = new EditAction(output);

        Input input = mock(Input.class);
        String str = any(String.class);
        when(input.askInt(str)).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        boolean res = replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is( "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln));
    }

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        String replacedName = "New item name";
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);
        String str = any(String.class);
        when(input.askInt(str)).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        boolean res = deleteAction.execute(input, tracker);
        assertThat(res, is( true));
        String ln = System.lineSeparator();
        assertThat(output.toString(), is( "=== Delete item ===" + ln
                + "Заявка удалена успешно." + ln));
    }

    @Test
    public void whenItemWasFindItemByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item"));
        String replacedName = "New item name";
        FindByIdAction action = new FindByIdAction(output);

        Input input = mock(Input.class);
        String str = any(String.class);
        when(input.askInt(str)).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        boolean res = action.execute(input, tracker);

        assertThat(res, is( true));
    }

    @Test
    public void whenItemWasFindItemByNameSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item"));
        String name = "New item name";
        FindByNameAction action = new FindByNameAction(output);

        Input input = mock(Input.class);
        String str = any(String.class);
        when(input.askInt(str)).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(name);

        boolean res = action.execute(input, tracker);

        assertThat(res, is( true));
    }
}