package ru.job4j.oop.bun;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("колобок съеден");
            return;
        }
        System.out.println("колобок сбежал");
    }
}
