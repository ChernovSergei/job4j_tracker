package ru.job4j.tracker.inheritance;

public class PizzaExtraCheese extends Pizza {
    public String name() {
        return super.name() + " plus extra cheese";
    }
}
