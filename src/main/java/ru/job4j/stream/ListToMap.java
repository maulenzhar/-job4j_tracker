package ru.job4j.stream;

import ru.job4j.stream.school.Student;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .distinct()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                e -> e,
                                (s, a) -> s,
                                LinkedHashMap::new
                        )
                );
    }
}
