package ru.job4j.tracker.ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;
    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Engine model: " + name);
    }

    public void printCountEngine() {
        int engines = ("A380".equals(this.getName())) ? (4) : (COUNT_ENGINE);
        System.out.println("Engine count = " + engines);
    }

    @Override
    public String toString() {
        return "Airbus{ name'" + name + '\'' + '}';
    }
}
