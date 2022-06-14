package ru.job4j.collection.lambda;

import ru.job4j.lambda.Attachment;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Arrays.sort(atts, comparator);

        Comparator<Attachment> comparator1 = (left, right) -> Integer.compare(left.getSize(), right.getSize());

        Comparator<Attachment> comparator2 = (left, right) -> {
            return Integer.compare(left.getSize(), right.getSize());
        };
    }

}
