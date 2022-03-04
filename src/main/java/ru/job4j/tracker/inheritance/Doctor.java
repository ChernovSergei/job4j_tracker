package ru.job4j.tracker.inheritance;

public class Doctor extends Profession {
    private int licence;

    public Doctor() {
    }

    public Doctor(String name, String surname, String education, long birthday, int licence) {
        super(name, surname, education, birthday);
        this.licence = licence;
    }
}
