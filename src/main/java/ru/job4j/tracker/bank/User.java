package ru.job4j.tracker.bank;

import java.util.Objects;

/**
 * @author SERGEI CHERNOV
 * @version 1.0
 * Class describes a bank client
 */
public class User {
    private String passport;
    private String username;

    /**
     * Class has constructor, which accept two parameters
     * @param passport is the bank client passport number
     * @param username is the bank client name
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * {@param passport} and {@param username} parameters have set of getters and setters
     */
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * The class overrides equals method. Two bank clients are equal if they have the same passports
     * @param o should {@param User} type
     * @return true if bank clients have the same passports and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * HashCode method is overridden in the class.
     * @return passport hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
