package ru.job4j.singleton;

public class StartUI {
    public static void main(String[] args) {
        Log4File log = Log4File.getInstance();
        Log4File log1 = Log4File.getInstance();
        log.add("add new Item");
        log.save();
    }
}
