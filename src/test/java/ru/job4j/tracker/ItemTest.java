package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "test3"),
                new Item(1, "test1"),
                new Item(2, "test2")

        );

        Collections.sort(items, new ItemAscByName());

        List<Item> expected = Arrays.asList(
                new Item(1, "test1"),
                new Item(2, "test2"),
                new Item(3, "test3")

        );
        assertThat(items, is(expected));
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "test3"),
                new Item(1, "test1"),
                new Item(2, "test2")

        );

        Collections.sort(items, new ItemDescByName());

        List<Item> expected = Arrays.asList(
                new Item(3, "test3"),
                new Item(2, "test2"),
                new Item(1, "test1")
        );
        assertThat(items, is(expected));
    }
}