package ru.job4j.tracker.bank;

import java.util.Objects;

/**
 * @author SERGEI CHERNOV
 * @version 1.0
 * Simple class describes an account with two properties: requisite and balance.
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * The class constructor takes two parameters.
     * @param requisite is transliterated word from Russian. Requisite means account data
     * @param balance is amount of money stored in an account
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Requisite and balance parameters have set of setters and getters
     */
    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * The equals method is overridden in the class. Requisites will be used for Account classes comparison
     * @param o is Object type. {@param o} should be Account type
     * @return true if requisites are equal. Otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * The hashCode method is overridden in the class.
     * @return requisite hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
