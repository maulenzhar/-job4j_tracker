package ru.job4j.stream.statistics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(
                        p.getName(),
                        p.getSubjects().stream().mapToInt(Subject::getScore)
                                .average()
                                .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .collect(groupingBy(Subject::getName, LinkedHashMap::new, averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(
                        p.getName(),
                        p.getSubjects().stream().mapToInt(Subject::getScore)
                                .sum()))
                .max(Tuple::compareTo).orElse(new Tuple("", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .collect(groupingBy(Subject::getName, LinkedHashMap::new, summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .max(Tuple::compareTo).orElse(new Tuple("", 0));
    }
}
