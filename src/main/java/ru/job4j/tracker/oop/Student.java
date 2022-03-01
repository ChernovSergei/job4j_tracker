package ru.job4j.tracker.oop;

public class Student {
    public void song() {
        System.out.println("We are the champions");
    }

    public void accordion() {
        System.out.println("tra ta ta");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        for (int i = 0; i < 3; i++) {
            petya.song();
            petya.accordion();
        }

    }
}
