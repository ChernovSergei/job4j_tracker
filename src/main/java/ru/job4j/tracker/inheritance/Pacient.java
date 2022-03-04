package ru.job4j.tracker.inheritance;

public class Pacient {
    private String name;
    private String surname;
    private long birthday;

    public Pacient() {

    }

    public Pacient(String name, String surname, long birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
