package ru.job4j.tracker.action;

import ru.job4j.tracker.inpute.Input;
import ru.job4j.tracker.repo.MemTracker;
import ru.job4j.tracker.repo.Store;

public interface  UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
