package ru.job4j.tracker.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {
    public static double aberageScore(List<Pupil> pupils) {
        double sum = 0D;
        int counter = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                counter++;
            }
        }
        return sum / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        Map<String, Label> labels = new HashMap<>();

        for (Pupil pupil : pupils) {
            double score;
            labels.putIfAbsent(pupil.name(), new Label(pupil.name(), 0D));
            score = 0D;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            score /= pupil.subjects().size();
            labels.replace(pupil.name(), new Label(pupil.name(), score));
        }
        return new ArrayList<>(labels.values());
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Label> labels = new HashMap<>();
        for (Pupil pupil : pupils) {
            double score;
            for (Subject subject : pupil.subjects()) {
                labels.putIfAbsent(subject.name(), new Label(subject.name(), 0D));
                score = labels.get(subject.name()).score() + subject.score();
                labels.replace(subject.name(), new Label(subject.name(), score));
            }
        }
        for (Map.Entry<String, Label> label: labels.entrySet()) {
            label.setValue(new Label(label.getValue().name(), label.getValue().score() / labels.size()));
        }
        return new ArrayList<>(labels.values());
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Map<String, Double> students = new HashMap<>();
        Label bestPupil = new Label("", 0D);

        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            students.put(pupil.name(), score);
        }
        for (Map.Entry<String, Double> student : students.entrySet()) {
            if (bestPupil.score() < student.getValue()) {
                bestPupil = new Label(student.getKey(), student.getValue());
            }
        }
        return bestPupil;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjects = new HashMap<>();
        Label bestSubject = new Label("", 0D);
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjects.putIfAbsent(subject.name(), 0);
                subjects.replace(subject.name(), subject.score() + subjects.get(subject.name()));
            }
        }
        for (Map.Entry<String, Integer> subject : subjects.entrySet()) {
            if (bestSubject.score() < subject.getValue()) {
                bestSubject = new Label(subject.getKey(), subject.getValue());
            }
        }
        return bestSubject;
    }
}
