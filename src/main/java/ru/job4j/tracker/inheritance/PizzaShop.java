package ru.job4j.tracker.inheritance;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        PizzaExtraCheese pizzaCheese = new PizzaExtraCheese();
        PizzaExtraCheeseExtraTomato pizzaCheeseTomato = new PizzaExtraCheeseExtraTomato();
        System.out.println(pizza.name());
        System.out.println(pizzaCheese.name());
        System.out.println(pizzaCheeseTomato.name());
    }
}
