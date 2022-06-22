package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 3, 6, 8, -1, -3, -2, -4, -6, -5, -7, -8);
        List<Integer> positive = numbers.stream()
                .filter(f -> f > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }

}
