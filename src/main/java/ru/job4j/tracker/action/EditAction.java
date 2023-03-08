package ru.job4j.tracker.action;

import ru.job4j.tracker.inpute.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.repo.MemTracker;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.repo.Store;

public class EditAction implements UserAction {

    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
