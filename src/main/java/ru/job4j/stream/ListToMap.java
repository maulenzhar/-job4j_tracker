package ru.job4j.stream;

import ru.job4j.stream.school.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                e -> e,
                                (s, a) -> s
                        )
                );
    }
}
