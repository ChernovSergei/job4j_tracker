package ru.job4j.tracker.map;

import java.util.Objects;

public class Subjects {
    private String name;
    private int score;

    public Subjects(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subjects subjects = (Subjects) o;
        return Objects.equals(name, subjects.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Subject{"
                + "name='" + name + '\''
                + ", score='" + score
                + '}';
    }
}
