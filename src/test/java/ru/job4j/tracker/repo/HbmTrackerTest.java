package ru.job4j.tracker.repo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HbmTrackerTest {

    @BeforeAll
    public static void deleteAll() {
        try (var tracker = new HbmTracker()) {
            List<Item> all = tracker.findAll();
            for (Item item : all) {
                tracker.delete(item.getId());
            }
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenFindAll() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            item1.setName("test1");
            item2.setName("test2");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> rsl = tracker.findAll();
            assertThat(rsl).hasSize(2);
            assertThat(rsl).containsExactly(item1, item2);
        }
    }

    @Test
    public void whenFindByName() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            item1.setName("test1");
            item2.setName("test2");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> rsl = tracker.findByName("test1");
            assertThat(rsl).hasSize(1)
                    .containsExactly(item1);
        }
    }

    @Test
    public void whenFindById() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(item).isEqualTo(tracker.findById(item.getId()));
        }
    }

    @Test
    public void whenDelete() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            tracker.delete(item.getId());
            assertThat(tracker.findByName("test1")).isEmpty();
        }
    }
}