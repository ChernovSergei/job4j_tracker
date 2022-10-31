package ru.job4j.tracker.map;

import java.util.Map;
import java.util.Set;
import java.util.Optional;

public class College {
    private final Map<Student, Set<Subjects>> students;

    public College(Map<Student, Set<Subjects>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : students.keySet()) {
            if (s.getAccount().equals(account)) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subjects> findBySubjectName(String account, String name) {
        Optional<Subjects> rsl = Optional.empty();
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            Set<Subjects> subjects = students.get(a.get());
            for (Subjects s : subjects) {
                if (s.getName().equals(name)) {
                    rsl = Optional.of(s);
                    break;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subjects>> students = Map.of(new Student("Student", "000001", "201-1815"),
                Set.of(
                        new Subjects("Math", 70),
                        new Subjects("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        if (student.isPresent()) {
            System.out.println("Identified student: " + student.get());
        }
        Optional<Subjects> english = college.findBySubjectName("000001", "English");
        if (english.isPresent()) {
            System.out.println("Core for identified subject: " + english.get().getScore());
        }
    }
}
