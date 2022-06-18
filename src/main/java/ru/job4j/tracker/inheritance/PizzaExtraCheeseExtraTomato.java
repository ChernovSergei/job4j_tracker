package ru.job4j.tracker.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public String name() {
        return super.name() + " plus extra tomato";
    }
}
