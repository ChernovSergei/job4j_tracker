package ru.job4j.tracker.inheritance;

public class Programmer extends Engineer {
    private String primaryLanguage;

    public Programmer(String name, String surname, String education, long birthday, String quality,
                      String primaryLanguage) {
        super(name, surname, education, birthday, quality);
        this.primaryLanguage = primaryLanguage;
    }

    public void program(int projectId, String projectName) {
        System.out.println("Smart house application had been created for project: id - " + projectId + "; name - " + projectName);
        System.out.print("Programmer: " + getName() + " " + getSurname());
        System.out.println(", " + getQuality());
        System.out.println(primaryLanguage + " had been used as the primary language to write the code");
    }
}
