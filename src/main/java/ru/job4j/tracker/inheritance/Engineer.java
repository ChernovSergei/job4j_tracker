package ru.job4j.tracker.inheritance;

public class Engineer extends Profession {
    private String quality;

    public Engineer() {
    }

    public Engineer(String name, String surname, String education, long birthday, String quality) {
        super(name, surname, education, birthday);
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }
}
