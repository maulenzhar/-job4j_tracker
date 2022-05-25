package ru.job4j.tracker.action;

import ru.job4j.tracker.inpute.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class FindAllItemsAction implements UserAction {

    private final Output out;

    public FindAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }

        return true;
    }
}
