package ru.job4j.tracker.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean ative, int status, String message) {
        this.active = ative;
        this.status = status;
        this.message = message;
    }

    public void print() {
        System.out.println("The error is active: " + active);
        System.out.println("Error status: " + status);
        System.out.println("Error message: " + message);
    }

    public static void main(String[] args) {
        Error outOfMemory = new Error();
        outOfMemory.print();
        Error updateError = new Error(true, 26, "Application update failure");
        updateError.print();
    }
}
