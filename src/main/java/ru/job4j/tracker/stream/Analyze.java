package ru.job4j.tracker.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        double allScores = stream.map(Pupil::subjects)
                .flatMap(List::stream)
                .mapToDouble(Subject::score)
                .average()
                .getAsDouble();
        return allScores;
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        List<Tuple> tuples = stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects().stream()
                        .mapToDouble(Subject::score)
                        .average()
                        .getAsDouble()
                        ))
                .collect(Collectors.toList());
        return tuples;
    }

    public static List<Tuple> averageScoreSubject(Stream<Pupil> stream) {
        Map<String, Double> pupils = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .map(subject -> new Tuple(subject.name(), subject.score()))
                .collect(Collectors.groupingBy(Tuple::name, LinkedHashMap::new,
                        Collectors.averagingDouble(Tuple::score)));

        List<Tuple> result = pupils.entrySet().stream()
                .map(subject -> new Tuple(subject.getKey(), subject.getValue()))
                .collect(Collectors.toList());
        return result;
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        Tuple bestOfTheBest = stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects().stream()
                        .mapToDouble(Subject::score)
                        .sum()
                        ))
                .max(Comparator.comparing(Tuple::score))
                .orElse(new Tuple("Default Pupil", 0D));
        return bestOfTheBest;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> pupils = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .map(subject -> new Tuple(subject.name(), subject.score()))
                .collect(Collectors.groupingBy(Tuple::name,
                        Collectors.summingDouble(Tuple::score)));

        Tuple bestOfTheBest = pupils.entrySet().stream()
                .map(subject -> new Tuple(subject.getKey(), subject.getValue()))
                .max(Comparator.comparing((Tuple::score)))
                .orElse(new Tuple("Default Subject", 0D));
        return bestOfTheBest;
    }
}