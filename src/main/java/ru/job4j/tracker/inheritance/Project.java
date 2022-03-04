package ru.job4j.tracker.inheritance;

public class Project {
    public static void main(String[] args) {
        int projectId = 3413;
        String name = "SmartHouse";
        Builder builder = new Builder("Vasiliy", "Orlov", "Builder engineer", 23121990L, "First grade", "AutoCad");
        Programmer programmer = new Programmer("Erema", "Kuznecov", "Software engineer", 3003184L, "Middle lvl", "Java");
        builder.draw(projectId, name);
        programmer.program(projectId, name);
    }
}
