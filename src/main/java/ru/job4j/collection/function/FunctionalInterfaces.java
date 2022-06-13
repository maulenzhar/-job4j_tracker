package ru.job4j.collection.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        Supplier<Set<String>> sup1 = () -> new HashSet<>(list);
        BiConsumer<Integer, String> biCon =  (s, s1) ->  map.put(s, s1);
        Set<String> strings1 = sup1.get();
        int j = 1;
        for (String s : strings1) {
            biCon.accept(j++, s);
        }

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0  || s.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(list);
        List<String> strings = sup.get();

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func =  s -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}
