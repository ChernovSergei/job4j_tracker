package ru.job4j.tracker.inheritance;

public class Builder extends Engineer {
    private String designSoftware;

    public Builder(String name, String surname, String education, long birthday, String quality, String designSoftware) {
        super(name, surname, education, birthday, quality);
        this.designSoftware = designSoftware;
    }

    public void draw(int projectId, String projectName) {
        System.out.println("All drawing documentation had been created for project: id - " + projectId + "; name - " + projectName);
        System.out.print("Drawing documentation author: " + getName() + " " + getSurname());
        System.out.println(", " + getQuality());
        System.out.println(designSoftware + " had been used as the primary design application");
    }

}
