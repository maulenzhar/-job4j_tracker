package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        List<Task> bugs = tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .collect(Collectors.toList());
        bugs.forEach(System.out::println);

        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .map(task -> task.name)
                .forEach(System.out::println);

        List<String> names = tasks.stream()
                .map(task -> task.name)
                .collect(Collectors.toList());
        System.out.println(names);

        long total = tasks.stream()
                .map(task -> task.spent)
                .reduce(0L, Long::sum);
        System.out.println(total);

        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);

        System.out.println(
                List.of(1, 2, 3, 4).stream()
                        .collect(
                        Collectors.toMap(
                                e -> e,
                                e -> e * e
                        ))
        );

        System.out.println(
                List.of(1, 1, 2, 2, 9, 8).stream().collect(
                        Collectors.toMap(
                                e -> e,
                                e -> e * e,
                                (existing, replacement) -> existing
                        ))
        );
    }
}
