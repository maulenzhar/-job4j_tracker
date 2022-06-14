package ru.job4j.collection.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class RefMethodEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr"
        );
//        Consumer<String> consumer = (name) -> System.out.println(name);
        Consumer<String> consumer = System.out::println;
        names.forEach(consumer);

//        Comparator<Integer> intCmp = (left, right) -> Integer.compare(left, right);
        Comparator<Integer> intCmp = Integer::compare;
    }
}
