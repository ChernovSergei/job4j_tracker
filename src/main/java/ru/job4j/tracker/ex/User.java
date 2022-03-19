package ru.job4j.tracker.ex;

public class User {
    private String name;
    private boolean valid;

    public User(String name, boolean valid) {
        this.name = name;
        this.valid = valid;
    }

    public String getName() {
        return this.name;
    }

    public boolean isValid() {
        return valid;
    }
}
