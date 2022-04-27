package ru.job4j.oop.poly;

public class Pet extends Animal {
    public void vaccinate() {
        System.out.println(nameClass + " нуждается в прививках, чтобы не болеть.");
    }
}