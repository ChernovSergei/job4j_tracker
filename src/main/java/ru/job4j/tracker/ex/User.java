package ru.job4j.tracker.ex;

public class User {
    private String name;
    private boolean valid;

    public User(String name) {
        this.name = name;
        valid = isValid();
    }

    public String getName() {
        return this.name;
    }

    public boolean isValid() {
        valid = false;
        if (name.length() > 3) {
            valid = true;
        }
        return valid;
    }
}
