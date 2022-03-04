package ru.job4j.tracker.inheritance;

public class Surgeon extends Doctor {
    private String typeOfSurgeon;

    public Surgeon() {
    }

    public Surgeon(String name, String surname, String education, long birthday, int licence, String typeOfSurgeon) {
        super(name, surname, education, birthday, licence);
        this.typeOfSurgeon = typeOfSurgeon;
    }

    public void surge(String conclusion, Pacient pacient) {
        System.out.println("Patient :" + pacient.getName() + " " + pacient.getSurname());
        System.out.println("Conclusion: " + conclusion);
    }
}
