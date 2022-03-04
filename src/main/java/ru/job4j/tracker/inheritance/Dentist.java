package ru.job4j.tracker.inheritance;

public class Dentist extends Doctor {
    private String cureTechnic;

    public Dentist() {
    }

    public Dentist(String name, String surname, String education, long birthday, int licence, String cureTechnic) {
        super(name, surname, education, birthday, licence);
        this.cureTechnic = cureTechnic;
    }

    public void cureTooth(int toothNumber, String conclusion, Pacient pacient) {
        System.out.println("Patient :" + pacient.getName() + " " + pacient.getSurname());
        System.out.println("Tooth number:" + toothNumber + ". Conclusion: " + conclusion);
    }
}
