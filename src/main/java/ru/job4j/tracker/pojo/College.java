package ru.job4j.tracker.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student mike = new Student();
        LocalDate entranceDate = LocalDate.now();
        mike.setFullName("Mike Vazovsky");
        mike.setGroup("MP-04-02");
        mike.setEntranceDate(entranceDate);
        System.out.println("Student: " + mike.getFullName()
                            + "\nGroup: " + mike.getGroup()
                            + "\nEntrance date: " + entranceDate);
    }
}
