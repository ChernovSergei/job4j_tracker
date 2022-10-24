package ru.job4j.tracker.map;

import java.util.Map;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subjects>> students;

    public College(Map<Student, Set<Subjects>> students) {
        this.students = students;
    }

    public Student findByAccount(String account) {
        /*for (Student s : students.keySet()) {
            if (s.getAccount().equals(account)) {
                return s;
            }
        }
        return null;*/
        return students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    public Subjects findBySubjectName(String account, String name) {
        /*Student a = findByAccount(account);
        if (a != null) {
            Set<Subjects> subjects = students.get(a);
            for (Subjects s : subjects) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
        }
        return null;*/
        Student a = findByAccount(account);
        if (a != null) {
            return students.get(a)
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subjects>> students = Map.of(new Student("Student", "000001", "201-1815"),
                Set.of(
                        new Subjects("Math", 70),
                        new Subjects("English", 85)
                )
        );
        College college = new College(students);
        Student student = college.findByAccount("000001");
        System.out.println("Identified student: " + student);
        Subjects english = college.findBySubjectName("000001", "English");
        System.out.println("Core for identified subject: " + english.getScore());
    }
}
