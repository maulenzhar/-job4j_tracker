package ru.job4j.collection.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        String[] atts = {"SpongeBob SquarePants", "Gary the Snail", "Patrick Star"};

        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Arrays.sort(atts, cmpText);

        System.out.println(Arrays.toString(atts));

        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        Arrays.sort(atts, cmpDescSize);

        System.out.println(Arrays.toString(atts));
    }

}